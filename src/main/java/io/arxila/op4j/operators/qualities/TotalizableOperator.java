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
import io.arxila.op4j.operators.intf.generic.ILevel0GenericUniqOperator;



/**
 * <p>
 * This interface defines methods for executing "all" and "any" operations.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface TotalizableOperator<I,T> {
    
    
    public ILevel0GenericUniqOperator<I,Boolean> any(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqOperator<I,Boolean> all(final IFunction<? super T,Boolean> eval);

    
}
