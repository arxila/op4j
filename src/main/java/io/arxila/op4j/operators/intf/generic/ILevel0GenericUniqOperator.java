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
package io.arxila.op4j.operators.intf.generic;

import io.arxila.javaruntype.type.Type;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.intf.array.ILevel0ArrayOperator;
import io.arxila.op4j.operators.intf.list.ILevel0ListOperator;
import io.arxila.op4j.operators.intf.map.ILevel0MapOperator;
import io.arxila.op4j.operators.intf.set.ILevel0SetOperator;
import io.arxila.op4j.operators.qualities.BuilderOperator;
import io.arxila.op4j.operators.qualities.CastableToStructuresOperator;
import io.arxila.op4j.operators.qualities.CastableToTypeOperator;
import io.arxila.op4j.operators.qualities.ExecutableOperator;
import io.arxila.op4j.operators.qualities.ReplaceableIfNullOperator;
import io.arxila.op4j.operators.qualities.ReplaceableOperator;
import io.arxila.op4j.operators.qualities.SelectableOperator;
import io.arxila.op4j.operators.qualities.UniqOperator;
import java.util.Map;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericUniqOperator<I,T>
        extends UniqOperator<T>,
                CastableToStructuresOperator,
        		BuilderOperator<I,T>,
        		ExecutableOperator<T>,
                CastableToTypeOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T> {



    public ILevel0GenericUniqSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public ILevel0GenericUniqSelectedOperator<I,T> ifNull();
    public ILevel0GenericUniqSelectedOperator<I,T> ifNotNull();

    
    public ILevel0GenericUniqOperator<I,T> replaceWith(final T replacement);
    public ILevel0GenericUniqOperator<I,T> replaceIfNullWith(final T replacement);


    public <X> ILevel0GenericUniqOperator<I,X> exec(final IFunction<? super T,X> function);

    public ILevel0GenericUniqOperator<I,T> execIfNotNull(final IFunction<? super T,? extends T> function);
    public ILevel0GenericUniqOperator<I,T> execIfNull(final IFunction<? super T,? extends T> function);
    public ILevel0GenericUniqOperator<I,T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);
    public ILevel0GenericUniqOperator<I,T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);
    public <X> ILevel0GenericUniqOperator<I,X> execIfNotNull(final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel0GenericUniqOperator<I,X> execIfNull(final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel0GenericUniqOperator<I,X> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel0GenericUniqOperator<I,X> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    
    
    
    
    
    public <X> ILevel0GenericUniqOperator<I,X> castTo(final Type<X> type);
    public <X> ILevel0ArrayOperator<I,X> castToArrayOf(final Type<X> type);
    public <X> ILevel0ListOperator<I,X> castToListOf(final Type<X> type);
    public <K,V> ILevel0MapOperator<I,K,V> castToMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> ILevel0SetOperator<I,X> castToSetOf(final Type<X> type);
    

    
    public ILevel0ListOperator<I,T> intoSingletonList();
    public ILevel0SetOperator<I,T> intoSingletonSet();
    public ILevel0ArrayOperator<I,T> intoSingletonArrayOf(final Type<T> type);
    public <K,V> ILevel0MapOperator<I,K,V> intoSingletonMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder);
    
    public <K> ILevel0MapOperator<I,K,T> zipKeyBy(final IFunction<? super T,K> keyEval);
    public <V> ILevel0MapOperator<I,T,V> zipValueBy(final IFunction<? super T,V> valueEval);
    public <K> ILevel0MapOperator<I,K,T> zipKey(final K key);
    public <V> ILevel0MapOperator<I,T,V> zipValue(final V value);
    
    
}
