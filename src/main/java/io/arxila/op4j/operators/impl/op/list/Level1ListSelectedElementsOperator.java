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
package io.arxila.op4j.operators.impl.op.list;

import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.list.ILevel1ListSelectedElementsOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;
import java.util.List;


public final class Level1ListSelectedElementsOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,List<T>>, ILevel1ListSelectedElementsOperator<I,T> {


    public Level1ListSelectedElementsOperator(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifNull() {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifIndex(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifIndexNot(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListSelectedOperator<I,T> endFor() {
        return new Level0ListSelectedOperator<I,T>(getTarget().endIterate(null));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperator<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListSelectedElementsOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ListSelectedElementsOperator<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperator<I,T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> get() {
        return endFor().get();
    }



}
