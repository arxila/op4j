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
 * This interface contains methods for ending selections on map entries.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface SelectedMapEntryOperator<K,V> {

    
    /**
     * <p>
     * Ends the selection currently active for this level.
     * </p>
     * 
     * @return an operator which will execute all subsequent operations on 
     *         all the target objects instead of only on the previously selected ones. 
     */
    public SelectableMapEntryOperator<K,V> endIf();
	
}
