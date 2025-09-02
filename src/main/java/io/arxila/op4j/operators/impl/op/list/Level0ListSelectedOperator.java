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

import io.arxila.op4j.functions.FnList;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.operators.impl.AbstractOperator;
import io.arxila.op4j.operators.intf.list.ILevel0ListSelectedOperator;
import io.arxila.op4j.operators.qualities.UniqOpOperator;
import io.arxila.op4j.target.Target;
import io.arxila.op4j.target.Target.Normalisation;
import io.arxila.op4j.target.Target.Structure;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public final class Level0ListSelectedOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,List<T>>, ILevel0ListSelectedOperator<I,T> {


    public Level0ListSelectedOperator(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperator<I,T> forEach() {
        return new Level1ListSelectedElementsOperator<I,T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListSelectedOperator<I,T> distinct() {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().distinct()));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> sortBy(final IFunction<? super T,?> by) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().sortBy((IFunction)by)));
    }


    public Level0ListSelectedOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElements)));
    }


    public Level0ListSelectedOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ListSelectedOperator<I,T> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    public Level0ListSelectedOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0ListSelectedOperator<I,T> removeAllNull() {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().removeAllNull()));
    }


    public Level0ListOperator<I,T> endIf() {
        return new Level0ListOperator<I,T>(getTarget().endSelect());
    }


    public Level0ListSelectedOperator<I,T> execAsList(final IFunction<? super List<T>,? extends List<? extends T>> function) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(function, Normalisation.LIST));
    }


    public Level0ListSelectedOperator<I,T> add(final T newElement) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().add(newElement)));
    }


    public Level0ListSelectedOperator<I,T> addAll(final T... newElements) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().add(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().addAll((Collection)collection)));
    }


    public Level0ListSelectedOperator<I,T> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElement)));
    }


    public Level0ListSelectedOperator<I,T> sort() {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperator<I,T>(getTarget().execute(FnList.ofObject().sort((Comparator)comparator)));
    }


    public Level0ListSelectedOperator<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0ListSelectedOperator<I,T>(getTarget().map(Structure.LIST, function, null));
    }


    public Level0ListSelectedOperator<I,T> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public List<T> get() {
        return endIf().get();
    }



}
