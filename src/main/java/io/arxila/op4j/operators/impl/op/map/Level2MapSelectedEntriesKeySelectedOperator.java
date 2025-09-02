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
package io.arxila.op4j.operators.impl.op.map;

import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.map.ILevel2MapSelectedEntriesKeySelectedOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;
import java.util.Map;


public final class Level2MapSelectedEntriesKeySelectedOperator<I,K,V> extends AbstractOperator implements UniqOpOperator<I,Map<K,V>>, ILevel2MapSelectedEntriesKeySelectedOperator<I,K,V> {


    public Level2MapSelectedEntriesKeySelectedOperator(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesKeyOperator<I,K,V> endIf() {
        return new Level2MapSelectedEntriesKeyOperator<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesKeySelectedOperator<I,K,V> exec(final IFunction<? super K,? extends K> function) {
        return new Level2MapSelectedEntriesKeySelectedOperator<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<I,K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesKeySelectedOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
