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
import java.util.Map;


/**
 * <p>
 * This interface contains methods for conversions to map of array (array group map).
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ConvertibleToMapOfListOperator<T> {
    
    
    /**
     * <p>
     * Converts the target object to a map by inputting the original target's
     * elements into the specified map builder (a function returning map entries)
     * which will create the resulting keys and values. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param <V> the type of the values that will be created
     * @param mapBuilder the map builder function to be used
     * @return an operator holding the converted object as target.
     */
    public <K,V> Operator toGroupMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    
    /**
     * <p>
     * Converts the target object to a map by inputting the original target's
     * elements into the specified map builder (a function returning map entries)
     * which will create the resulting keys and values. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param <V> the type of the values that will be created
     * @param keyFunction the function for building the keys
     * @param valueFunction the function for building the values
     * @return an operator holding the converted object as target.
     */
    public <K,V> Operator toGroupMap(final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction);

    
    
    /**
     * <p>
     * Converts the target object to a map, by using the even elements 
     * (starting at 0) as keys, and the odd elements as values. Values with
     * the same key will be grouped into lists.
     * </p>
     * 
     * @return an operator holding the converted object as target.
     */
    public Operator coupleAndGroup();
    
    
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values and applying an evaluator (keyEval) to them
     * in order to obtain their corresponding keys. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param keyEval the evaluator used for obtaining the keys
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipAndGroupKeysBy(final IFunction<? super T,K> keyEval);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and applying an evaluator (valueEval) to them
     * in order to obtain their corresponding value. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <V> the type of the values that will be created
     * @param valueEval the evaluator used for obtaining the values
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipAndGroupValuesBy(final IFunction<? super T,V> valueEval);
    
    
    
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values the specified objects as keys. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param keys the keys to be zipped
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipAndGroupKeys(final K... keys);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and the specified objects as values. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <V> the type of the values that will be created
     * @param values the values to be zipped
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipAndGroupValues(final V... values);
    
    
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values the specified objects as keys. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param keys the keys to be zipped
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipAndGroupKeysFrom(final Collection<K> keys);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and the specified objects as values. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <V> the type of the values that will be created
     * @param values the values to be zipped
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipAndGroupValuesFrom(final Collection<V> values);
    
    
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as values the specified objects as keys. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <K> the type of the keys that will be created
     * @param keys the keys to be zipped
     * @return an operator holding the converted object as target.
     */
    public <K> Operator zipAndGroupKeysFrom(final K[] keys);
    
    /**
     * <p>
     * Converts the target object to a map by using the original target's
     * elements as keys and the specified objects as values. Values with the same key
     * will be grouped into lists.
     * </p>
     * 
     * @param <V> the type of the values that will be created
     * @param values the values to be zipped
     * @return an operator holding the converted object as target.
     */
    public <V> Operator zipAndGroupValuesFrom(final V[] values);
    
}
