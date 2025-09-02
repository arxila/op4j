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
package io.arxila.op4j.operators.impl.op.generic;

import io.arxila.javaruntype.type.Type;
import io.arxila.javaruntype.type.Types;
import io.arxila.op4j.functions.FnList;
import io.arxila.op4j.functions.FnObject;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.impl.op.array.Level0ArrayOperator;
import io.arxila.op4j.operators.impl.op.list.Level0ListOperator;
import io.arxila.op4j.operators.impl.op.map.Level0MapOperator;
import io.arxila.op4j.operators.impl.op.set.Level0SetOperator;
import io.arxila.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
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
public final class Level0GenericUniqOperator<I,T> extends AbstractOperator
        implements UniqOpOperator<I,T>, ILevel0GenericUniqOperator<I,T>  {

    
    public Level0GenericUniqOperator(final Target target) {
        super(target);
    }


    public Level0ArrayOperator<I,T> intoSingletonArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<I,T>(type, getTarget().execute(FnObject.intoSingletonArrayOf(type)));
    }


    public Level0ListOperator<I,T> intoSingletonList() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> zipKeyBy(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipKeysBy((IFunction)keyEval)));
    }


    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T, V> zipValueBy(final IFunction<? super T,V> valueEval) {
        return new Level0MapOperator<I,T, V>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipValuesBy((IFunction)valueEval)));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K, T> zipKey(final K key) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipKeys(key)));
    }


    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T, V> zipValue(final V value) {
        return new Level0MapOperator<I,T, V>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().zipValues(value)));
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V> intoSingletonMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnObject.intoSingletonListOf(Types.OBJECT)).execute(FnList.ofObject().toMap((IFunction)mapBuilder)));
    }


    public Level0SetOperator<I,T> intoSingletonSet() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnObject.intoSingletonSetOf(Types.OBJECT)));
    }


    public <X> Level0ArrayOperator<I,X> castToArrayOf(final Type<X> type) {
        return new Level0ArrayOperator<I,X>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level0ListOperator<I,X> castToListOf(final Type<X> type) {
        return new Level0ListOperator<I,X>(getTarget().cast(CastType.LIST, type));
    }


    public <K,V> Level0MapOperator<I,K,V> castToMapOf(final Type<K> keyType, final Type<V> valueType) {
        return new Level0MapOperator<I,K,V>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level0SetOperator<I,X> castToSetOf(final Type<X> type) {
        return new Level0SetOperator<I,X>(getTarget().cast(CastType.SET, type));
    }


    public <X> Level0GenericUniqOperator<I,X> castTo(final Type<X> type) {
        return new Level0GenericUniqOperator<I,X>(getTarget().cast(CastType.OBJECT, type));
    }

    


    


    


    


    


    


    


    

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }




    public Level0GenericUniqSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<I,T> ifNotNull() {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    


    


    public Level0GenericUniqSelectedOperator<I,T> ifNull() {
        return new Level0GenericUniqSelectedOperator<I,T>(getTarget().selectNull());
    }


    


    



    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super T,X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I,T> replaceWith(final T replacement) {
        return new Level0GenericUniqOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
    public Level0GenericUniqOperator<I, T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfFalse(eval, function, null, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I, X> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I, T> execIfNotNull(final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfNotNull(function, null, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I, X> execIfNotNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I, T> execIfNull(final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfNull(function, null, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<I, X> execIfNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfNull(function, elseFunction, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<I, T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level0GenericUniqOperator<I, T>(getTarget().executeIfTrue(eval, function, null, Normalisation.NONE));
    }

    
    public <X> Level0GenericUniqOperator<I, X> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level0GenericUniqOperator<I, X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.NONE));
    }
    
    
    
    
    
    
}
