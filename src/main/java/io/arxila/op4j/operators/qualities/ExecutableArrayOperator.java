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

import io.arxila.javaruntype.type.Type;
import io.arxila.op4j.functions.IFunction;




/**
 * <p>
 * This interface contains methods for executing functions on operators with
 * array target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableArrayOperator<T> {


    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an array of the current operator's
     * target type, and will return an array of the same type and structure.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> execAsArray(final IFunction<? super T[],? extends T[]> function);


    /**
     * <p>
     * Executes the specified function on the target object, creating a new operator
     * containing the result of the execution.
     * </p>
     * <p>
     * This function must be able to take as input an array of the current operator's
     * target type, and can return an array of a different type (specified by the type parameter), 
     * which will be from then on the new operator's target type.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param type the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> execAsArrayOf(final Type<X> type, final IFunction<? super T[],X[]> function);
    
    
    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> execIfNotNullAsArray(final IFunction<? super T[],? extends T[]> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> execIfNullAsArray(final IFunction<? super T[],? extends T[]> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> execIfTrueAsArray(final IFunction<? super T[], Boolean> eval, final IFunction<? super T[],? extends T[]> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> execIfFalseAsArray(final IFunction<? super T[], Boolean> eval, final IFunction<? super T[],? extends T[]> function);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> execIfNotNullAsArrayOf(final Type<X> type, final IFunction<? super T[],X[]> function, final IFunction<? super T[],X[]> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> execIfNullAsArrayOf(final Type<X> type, final IFunction<? super T[],X[]> function, final IFunction<? super T[],X[]> elseFunction);

    
    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> execIfTrueAsArrayOf(final Type<X> type, final IFunction<? super T[], Boolean> eval, final IFunction<? super T[],X[]> function, final IFunction<? super T[],X[]> elseFunction);


    /**
     * <p>
     * Executes a function in a way equivalent to {@link #execAsArray(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     * 
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> execIfFalseAsArrayOf(final Type<X> type, final IFunction<? super T[], Boolean> eval, final IFunction<? super T[],X[]> function, final IFunction<? super T[],X[]> elseFunction);

    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    /**
     * <p>
     * Executes the specified function on the target object, creating a new generic operator
     * containing the result of the execution and setting the new operator type to the one
     * specified.
     * </p>
     * 
     * @param <X> the type of the result object
     * @param function the function to be executed
     * @return an operator on the results of function execution
     */
    public <X> Operator exec(final IFunction<? super T[],X> function);
    
    
    

    /**
     * <p>
     * Executes the specified function on each of the elements, creating a new operator
     * containing the result of all the executions and setting the new operator type to the one
     * specified.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().exec(type, function).endFor()</tt>.
     * </p>
     * 
     * @param <X> the type of the result elements
     * @param type the new type for the operator
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public <X> ExecutableArrayOperator<X> map(final Type<X> type, final IFunction<? super T,X> function);
    

    /**
     * <p>
     * Executes the specified function on each of the elements, creating a new operator
     * containing the result of all the executions but not changing the operator type. The
     * specified function will have to return results compatible with the current operator type.
     * </p>
     * <p>
     * This method is equivalent to <tt>forEach().exec(function).endFor()</tt>.
     * </p>
     * 
     * @param function the function to be executed
     * @return an operator on the results of function execution on each element
     */
    public ExecutableArrayOperator<T> map(final IFunction<? super T,? extends T> function);
    

    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> mapIfNotNull(final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> mapIfNull(final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> mapIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @return an operator on the results of function execution
     */
    public ExecutableArrayOperator<T> mapIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);

    
    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> mapIfNotNull(final Type<X> type, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> mapIfNull(final Type<X> type, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);

    
    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     *
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> mapIfTrue(final Type<X> type, final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);


    /**
     * <p>
     * Maps a function in a way equivalent to {@link #map(IFunction)} but only
     * on selected elements, leaving all other elements untouched.
     * </p>
     * 
     * @param <X> the new type returned by the functions
     * @param type the new type returned by the functions
     * @param eval the evaluation function used to select elements
     * @param function the function to be executed on the selected elements
     * @param elseFunction the function to be executed on the non-selected elements
     * @return an operator on the results of function execution
     */
    public <X> ExecutableArrayOperator<X> mapIfFalse(final Type<X> type, final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    
    
}
