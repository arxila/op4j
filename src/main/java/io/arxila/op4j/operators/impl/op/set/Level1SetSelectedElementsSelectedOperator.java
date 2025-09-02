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

import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.set.ILevel1SetSelectedElementsSelectedOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;
import java.util.Set;


public final class Level1SetSelectedElementsSelectedOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,Set<T>>, ILevel1SetSelectedElementsSelectedOperator<I,T> {


    public Level1SetSelectedElementsSelectedOperator(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperator<I,T> endIf() {
        return new Level1SetSelectedElementsOperator<I,T>(getTarget().endSelect());
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
