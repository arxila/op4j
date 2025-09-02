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

import io.arxila.javaruntype.type.Type;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.CastType;
import io.arxila.op4j.target.Target.Normalisation;
import java.util.Map;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level2MapEntriesValueOperator<I,K,V> extends AbstractOperator
        implements UniqOpOperator<I,Map<K,V>>, ILevel2MapEntriesValueOperator<I,K,V> {

    
    public Level2MapEntriesValueOperator(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<I,K, V> endOn() {
        return new Level1MapEntriesOperator<I,K, V>(getTarget().endOn());
    }


    public <X> Level2MapEntriesValueOperator<I,K, X> castTo(final Type<X> type) {
        return new Level2MapEntriesValueOperator<I,K, X>(getTarget().cast(CastType.OBJECT, type));
    }

    
    
    
    
    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifNotNull() {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectNotNull());
    }


    


    


    public Level2MapEntriesValueSelectedOperator<I,K, V> ifNull() {
        return new Level2MapEntriesValueSelectedOperator<I,K, V>(getTarget().selectNull());
    }


    


    




    public <X> Level2MapEntriesValueOperator<I,K, X> exec(final IFunction<? super V,X> function) {
        return new Level2MapEntriesValueOperator<I,K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I,K, V> replaceWith(final V replacement) {
        return new Level2MapEntriesValueOperator<I,K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I,K, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
    
    
    
    
    public Level2MapEntriesValueOperator<I, K, V> execIfFalse(final IFunction<? super V, Boolean> eval, final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfFalse(eval, function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfFalse(final IFunction<? super V, Boolean> eval, final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I, K, V> execIfNotNull(final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfNotNull(function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfNotNull(final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I, K, V> execIfNull(final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfNull(function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfNull(final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfNull(function, elseFunction, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<I, K, V> execIfTrue(final IFunction<? super V, Boolean> eval, final IFunction<? super V, ? extends V> function) {
        return new Level2MapEntriesValueOperator<I, K, V>(getTarget().executeIfTrue(eval, function, null, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<I, K, X> execIfTrue(final IFunction<? super V, Boolean> eval, final IFunction<? super V, X> function, final IFunction<? super V, X> elseFunction) {
        return new Level2MapEntriesValueOperator<I, K, X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.NONE));
    }


    
}
