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
import io.arxila.op4j.operators.qualities.ExecutableMapEntrySelectedOperator;
import io.arxila.op4j.operators.qualities.NavigableMapEntryOperator;
import io.arxila.op4j.operators.qualities.NavigatingMapOperator;
import io.arxila.op4j.operators.qualities.ReplaceableOperator;
import io.arxila.op4j.operators.qualities.SelectableMapEntryOperator;
import io.arxila.op4j.operators.qualities.UniqOperator;
import java.util.Map;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1MapSelectedEntriesOperator<I,K,V>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntrySelectedOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V> {


    public ILevel1MapSelectedEntriesSelectedOperator<I,K,V> ifIndex(final int... indexes);
    public ILevel1MapSelectedEntriesSelectedOperator<I,K,V> ifTrue(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel1MapSelectedEntriesSelectedOperator<I,K,V> ifFalse(final IFunction<? super Map.Entry<K,V>,Boolean> eval);
    public ILevel1MapSelectedEntriesSelectedOperator<I,K,V> ifIndexNot(final int... indexes);
    public ILevel1MapSelectedEntriesSelectedOperator<I,K,V> ifKeyEquals(final K... keys);
    public ILevel1MapSelectedEntriesSelectedOperator<I,K,V> ifKeyNotEquals(final K... keys);
    

    public ILevel2MapSelectedEntriesKeyOperator<I,K,V> onKey();
    public ILevel2MapSelectedEntriesValueOperator<I,K,V> onValue();
    
    public ILevel0MapSelectedOperator<I,K,V> endFor();
    
    public ILevel1MapSelectedEntriesOperator<I,K,V> replaceWith(final Map.Entry<K,V> replacement);

    public ILevel1MapSelectedEntriesOperator<I,K,V> execAsMapEntry(final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<? extends K,? extends V>> function);
    
}
