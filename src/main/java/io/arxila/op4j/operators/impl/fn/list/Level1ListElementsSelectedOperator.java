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
package io.arxila.op4j.operators.impl.fn.list;

import io.arxila.op4j.functions.Function;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.list.ILevel1ListElementsSelectedOperator;
import io.arxila.op4j.operators.qualities.UniqFnOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;
import java.util.List;


public final class Level1ListElementsSelectedOperator<I,T> extends AbstractOperator implements UniqFnOperator<I,List<T>>, ILevel1ListElementsSelectedOperator<I,T> {


    public Level1ListElementsSelectedOperator(final Target target) {
        super(target);
    }


    public Level1ListElementsOperator<I,T> endIf() {
        return new Level1ListElementsOperator<I,T>(getTarget().endSelect());
    }


    public Level1ListElementsSelectedOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListElementsSelectedOperator<I,T> replaceWith(final T replacement) {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Function<I,List<T>> get() {
        return endIf().get();
    }



}
