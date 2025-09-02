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


/**
 * <p>
 * This interface contains methods for casts to array (T[]).
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface CastableToArrayOperator {
    
    
    /**
     * <p>
     * Casts the operator's target as an array of the specified type.
     * </p>
     * 
     * @param <X> the type of the elements of the array
     * @param type the type of the elements of the array
     * @return the resulting casted operator
     */
    public <X> Operator of(final Type<X> type);
    
    /**
     * <p>
     * Casts the operator's target as an array of the specified type.
     * </p>
     * 
     * @param <X> the type of the elements of the array
     * @param type the type of the elements of the array
     * @return the resulting casted operator
     */
    public <X> Operator castToArrayOf(final Type<X> type);
    
}
