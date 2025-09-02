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
import io.arxila.op4j.operators.intf.list.ILevel1ListElementsOperator;
import io.arxila.op4j.operators.qualities.ExecutableMapEntryOperator;
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
public interface ILevel1MapEntriesOperator<I,K,V>
		extends UniqOperator<Map<K,V>>,
		        NavigableMapEntryOperator,
                NavigatingMapOperator<K,V>,
                ExecutableMapEntryOperator<K,V>,
                ReplaceableOperator<Map.Entry<K,V>>,
                SelectableMapEntryOperator<K, V> {


    public ILevel1MapEntriesSelectedOperator<I,K,V> ifIndex(final int... indexes);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifTrue(final IFunction<? super Map.Entry<K, V>,Boolean> eval);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifFalse(final IFunction<? super Map.Entry<K, V>,Boolean> eval);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifIndexNot(final int... indexes);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifKeyEquals(final K... keys);
    public ILevel1MapEntriesSelectedOperator<I,K,V> ifKeyNotEquals(final K... keys);
    

    public ILevel2MapEntriesKeyOperator<I,K,V> onKey();
    public ILevel2MapEntriesValueOperator<I,K,V> onValue();
    
    public ILevel0MapOperator<I,K,V> endFor();
    
    public <X,Y> ILevel1MapEntriesOperator<I,X,Y> execAsMapEntry(final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<X,Y>> function);
    
    public ILevel1MapEntriesOperator<I,K,V> replaceWith(final Map.Entry<K,V> replacement);



    public <X> ILevel1ListElementsOperator<I,X> exec(final IFunction<? super Map.Entry<K,V>,X> function);
    
    public ILevel1MapEntriesOperator<I,K,V> execIfTrueAsMapEntry(final IFunction<? super Map.Entry<K,V>, Boolean> eval, final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<? extends K,? extends V>> function);
    public ILevel1MapEntriesOperator<I,K,V> execIfFalseAsMapEntry(final IFunction<? super Map.Entry<K,V>, Boolean> eval, final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<? extends K,? extends V>> function);
    public <X,Y> ILevel1MapEntriesOperator<I,X,Y> execIfTrueAsMapEntry(final IFunction<? super Map.Entry<K,V>, Boolean> eval, final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<X,Y>> function, final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<X,Y>> elseFunction);
    public <X,Y> ILevel1MapEntriesOperator<I,X,Y> execIfFalseAsMapEntry(final IFunction<? super Map.Entry<K,V>, Boolean> eval, final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<X,Y>> function, final IFunction<? super Map.Entry<K,V>,? extends Map.Entry<X,Y>> elseFunction);
    
    
    
    
}
