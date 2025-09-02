/*
 * =========================================================================
 *
 *   Copyright (c) 2010-2025 Arxila OSS (https://arxila.io)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *   implied. See the License for the specific language governing
 *   permissions and limitations under the License.
 *
 * =========================================================================
 */
package io.arxila.op4j.operators.qualities;

import io.arxila.op4j.functions.IFunction;
import java.util.Collection;

/**
 * <p>
 * This interface contains methods for modifying structures (adding/removing elements).
 * </p> 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ModifiableCollectionOperator<T> {
    

    /**
     * <p>
     * Adds the specified element at the end of the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param newElement the element to be added
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> add(final T newElement);
    
    
    /**
     * <p>
     * Adds all the specified elements at the end of the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param newElements the elements to be added
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> addAll(final T... newElements);
    

    /**
     * <p>
     * Inserts a new element into the specified position (starting in 0) of the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param position the position in which the new element will be inserted (starting in 0)
     * @param newElement the element to be inserted
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> insert(final int position, final T newElement);

    
    /**
     * <p>
     * Inserts new elements into the specified position (starting in 0) of the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param position the position in which the new element will be inserted (starting in 0)
     * @param newElements the elements to be inserted
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> insertAll(final int position, final T... newElements);
    
    
    /**
     * <p>
     * Adds all the elements in the specified collection to the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param collection the collection containing the elements to be added
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> addAll(final Collection<T> collection);


    /**
     * <p>
     * Removes all the elements in the target structure object which position (index) in it
     * matches one the specified indexes.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param indexes the positions of the elements to be removed
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllIndexes(final int... indexes);
    
    
    /**
     * <p>
     * Removes the specified values from the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param values the values to be removed from the target.
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllEqual(final T... values);
    
    
    /**
     * <p>
     * Removes from the target structure object all the elements which evaluate as true
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllTrue(final IFunction<? super T,Boolean> eval);
    
    
    /**
     * <p>
     * Removes from the target structure object all the elements which evaluate as false
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllFalse(final IFunction<? super T,Boolean> eval);
    
    
    /**
     * <p>
     * Removes from the target structure object all the elements which either are null or evaluate as false
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval);
    

    /**
     * <p>
     * Removes from the target structure object all the elements which are not null and evaluate as false
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    
    
    /**
     * <p>
     * Removes from the target structure object all the elements which are not null and evaluate as true
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval);
    
    
    /**
     * <p>
     * Removes from the target structure object all the elements which either are null or evaluate as true
     * using the specified evaluator.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param eval the evaluator to be used, which must return Boolean 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval);
    
    
    /**
     * <p>
     * Removes all the elements in the target structure object except those which position (index) in it
     * matches one of the specified indexes.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @param indexes the positions of the elements to be kept
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllIndexesNot(final int... indexes);
    
    
    /**
     * <p>
     * Remove all the null elements in the target structure object.
     * </p>
     * <p>
     * The original target object is not modified, but copied instead.
     * </p>
     * 
     * @return an operator holding the modified target object
     */
    public ModifiableCollectionOperator<T> removeAllNull();
    
}
