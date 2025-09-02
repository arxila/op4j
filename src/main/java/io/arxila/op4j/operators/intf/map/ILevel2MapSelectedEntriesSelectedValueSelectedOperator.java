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
package io.arxila.op4j.operators.intf.map;

import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.qualities.ExecutableSelectedOperator;
import io.arxila.op4j.operators.qualities.ReplaceableOperator;
import io.arxila.op4j.operators.qualities.SelectedMapEntryComponentOperator;
import io.arxila.op4j.operators.qualities.UniqOperator;
import java.util.Map;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V>
        extends UniqOperator<Map<K,V>>,
        		ExecutableSelectedOperator<V>,
                ReplaceableOperator<V>,
                SelectedMapEntryComponentOperator<V> {



    public ILevel2MapSelectedEntriesSelectedValueOperator<I,K,V> endIf();


    public ILevel2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> replaceWith(final V replacement);

    public ILevel2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> exec(final IFunction<? super V,? extends V> function);

    
}
