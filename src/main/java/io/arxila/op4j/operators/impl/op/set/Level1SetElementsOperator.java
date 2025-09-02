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
package io.arxila.op4j.operators.impl.op.set;

import io.arxila.javaruntype.type.Type;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.set.ILevel1SetElementsOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;
import java.util.Set;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1SetElementsOperator<I,T> extends AbstractOperator
        implements UniqOpOperator<I,Set<T>>, ILevel1SetElementsOperator<I,T>  {

    
    public Level1SetElementsOperator(final Target target) {
        super(target);
    }


    public Level0SetOperator<I,T> endFor() {
        return new Level0SetOperator<I,T>(getTarget().endIterate(null));
    }


    public <X> Level1SetElementsOperator<I,X> castTo(final Type<X> type) {
    	return endFor().generic().castToSetOf(type).forEach();
    }

    


    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }


    public Level1SetElementsSelectedOperator<I,T> ifIndex(final int... indexes) {
        return new Level1SetElementsSelectedOperator<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1SetElementsSelectedOperator<I,T> ifIndexNot(final int... indexes) {
        return new Level1SetElementsSelectedOperator<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level1SetElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetElementsSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<I,T> ifNotNull() {
        return new Level1SetElementsSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    


    


    public Level1SetElementsSelectedOperator<I,T> ifNull() {
        return new Level1SetElementsSelectedOperator<I,T>(getTarget().selectNull());
    }


    


    



    public <X> Level1SetElementsOperator<I,X> exec(final IFunction<? super T,X> function) {
        return new Level1SetElementsOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetElementsOperator<I,T> replaceWith(final T replacement) {
        return new Level1SetElementsOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetElementsOperator<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    
    public Level1SetElementsOperator<I,T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level1SetElementsOperator<I,T>(getTarget().executeIfFalse(eval, function, null, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<I,X> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1SetElementsOperator<I,X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.NONE));
    }


    public Level1SetElementsOperator<I,T> execIfIndex(final int[] indexes, final IFunction<? super T, ? extends T> function) {
        return new Level1SetElementsOperator<I,T>(getTarget().executeIfIndex(indexes, function, null, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<I,X> execIfIndex(final int[] indexes, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1SetElementsOperator<I,X>(getTarget().executeIfIndex(indexes, function, elseFunction, Normalisation.NONE));
    }


    public Level1SetElementsOperator<I,T> execIfIndexNot(final int[] indexes, final IFunction<? super T, ? extends T> function) {
        return new Level1SetElementsOperator<I,T>(getTarget().executeIfIndexNot(indexes, function, null, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<I,X> execIfIndexNot(final int[] indexes, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1SetElementsOperator<I,X>(getTarget().executeIfIndexNot(indexes, function, elseFunction, Normalisation.NONE));
    }


    
    public Level1SetElementsOperator<I, T> execIfNotNull(final IFunction<? super T, ? extends T> function) {
        return new Level1SetElementsOperator<I,T>(getTarget().executeIfNotNull(function, null, Normalisation.NONE));
    }
    
    

    public <X> Level1SetElementsOperator<I,X> execIfNotNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1SetElementsOperator<I,X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.NONE));
    }



    public Level1SetElementsOperator<I,T> execIfNull(final IFunction<? super T, ? extends T> function) {
        return new Level1SetElementsOperator<I,T>(getTarget().executeIfNull(function, null, Normalisation.NONE));
    }



    public <X> Level1SetElementsOperator<I,X> execIfNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1SetElementsOperator<I,X>(getTarget().executeIfNull(function, elseFunction, Normalisation.NONE));
    }



    public Level1SetElementsOperator<I,T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level1SetElementsOperator<I,T>(getTarget().executeIfTrue(eval, function, null, Normalisation.NONE));
    }



    public <X> Level1SetElementsOperator<I,X> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1SetElementsOperator<I,X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.NONE));
    }

    

    
    
}
