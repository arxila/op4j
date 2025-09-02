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






/**
 * <p>
 * This interface contains methods for accessing keys and values at map entries.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface NavigableMapEntryOperator {

    
    /**
     * <p>
     * Accesses the key of a map entry. After the execution of this method, all subsequent
     * operations will be performed on the map entry's key, until an "endOn()" method
     * is executed.
     * </p>
     * 
     * @return an operator which will execute all operations on the key of the map entry.
     */
    public NavigatingMapEntryOperator onKey();

    
    /**
     * <p>
     * Accesses the value of a map entry. After the execution of this method, all subsequent
     * operations will be performed on the map entry's value, until an "endOn()" method
     * is executed.
     * </p>
     * 
     * @return an operator which will execute all operations on the value of the map entry.
     */
    public NavigatingMapEntryOperator onValue();
	
    
}
