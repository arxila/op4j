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

import io.arxila.op4j.operators.intf.generic.ILevel0GenericUniqOperator;




/**
 * <p>
 * This interface contains methods for converting specialized structure operators
 * (list, set, array...) into generic operators (as if an "Op.on" was executed on
 * them instead of "Op.onList", "Op.onArray", etc.)
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface GenerizableOperator<I,T> {
   
    /**
     * <p>
     * Converts the specialized structure operator into generic operators
     * (with no specific methods for structures - e.g. forEach())
     * </p>
     * 
     * @return a generic operator on the same target object
     */
    public ILevel0GenericUniqOperator<I,T> generic();
    
}
