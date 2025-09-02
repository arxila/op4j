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
 * This interface contains methods for iterating the entries in a map.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface NavigableMapOperator<K,V>  {

    
    /**
     * <p>
     * Iterates the target map's entries. After executing this method, any further operations
     * will be applied on each of the map entries (java.util.Map.Entry<?,?> objects) until 
     * an "endFor()" method is called.
     * </p>
     * 
     * @return an operator which will execute all operations on each entry of the map.
     */
    public NavigatingMapOperator<K,V> forEachEntry();
    
   
}
