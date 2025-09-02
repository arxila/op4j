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
package io.arxila.op4j.operators.impl.op.array;

import io.arxila.javaruntype.type.Type;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.array.ILevel1ArrayElementsSelectedOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;


public final class Level1ArrayElementsSelectedOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,T[]>, ILevel1ArrayElementsSelectedOperator<I,T> {


    private final Type<T> type;


    public Level1ArrayElementsSelectedOperator(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayElementsOperator<I,T> endIf() {
        return new Level1ArrayElementsOperator<I,T>(this.type, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ArrayElementsSelectedOperator<I,T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperator<I,T> replaceWith(final T replacement) {
        return new Level1ArrayElementsSelectedOperator<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endIf().get();
    }



}
