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
package io.arxila.op4j.functions;

import io.arxila.javaruntype.type.Type;
import io.arxila.op4j.exceptions.ExecutionException;
import io.arxila.op4j.util.ExecCtxImpl;
import io.arxila.op4j.util.VarArgsUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnSetOf<T> {


    
    protected final Type<T> type;
    
    

    public final Function<Set<T>,Set<T>> sort() {
        return new Sort<T>();
    }

    public final Function<Set<T>,Set<T>> sort(final Comparator<? super T> comparator) {
        return new SortByComparator<T>(comparator);
    }
    
    public final Function<Set<T>,Set<T>> sortBy(final IFunction<? super T, ?> by) {
        return new SortBy<T>(by);
    }

    
    
    
    public final Function<Set<T>,Set<T>> add(final T... newElements) {
        return new Add<T>(newElements);
    }
    
    public final Function<Set<T>,Set<T>> insert(final int position, final T... newElements) {
        return new Insert<T>(position, newElements);
    }
    
    public final Function<Set<T>,Set<T>> addAll(final Collection<T> collection) {
        return new AddAll<T>(collection);
    }
    
    public final Function<Set<T>,Set<T>> removeAllIndexes(final int... indexes) {
        return new RemoveAllIndexes<T>(indexes);
    }
    
    public final Function<Set<T>,Set<T>> removeAllEqual(final T... values) {
        return new RemoveAllEqual<T>(values);
    }
    
    public final Function<Set<T>,Set<T>> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllTrue<T>(eval);
    }
    
    public final Function<Set<T>,Set<T>> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllFalse<T>(eval);
    }
    
    public final Function<Set<T>,Set<T>> removeAllIndexesNot(final int... indexes) {
        return new RemoveAllIndexesNot<T>(indexes);
    }
    
    public final Function<Set<T>,Set<T>> removeAllNull() {
        return new RemoveAllNull<T>();
    }
    
    public final Function<Set<T>,Set<T>> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndTrue<T>(eval);
    }
    
    public final Function<Set<T>,Set<T>> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNotNullAndFalse<T>(eval);
    }
    
    public final Function<Set<T>,Set<T>> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrTrue<T>(eval);
    }
    
    public final Function<Set<T>,Set<T>> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new RemoveAllNullOrFalse<T>(eval);
    }
    

    
    public final Function<Set<T>,T[]> toArray() {
        return new ToArray<T>(this.type);
    }

    public final Function<Set<T>,List<T>> toList() {
        return new ToList<T>();
    }
    
    public final <K> Function<Set<T>,Map<K,T>> zipKeysBy(final IFunction<? super T, K> eval) {
        return new ZipKeysBy<K,T>(eval);
    }
    
    public final <V> Function<Set<T>,Map<T,V>> zipValuesBy(final IFunction<? super T, V> eval) {
        return new ZipValuesBy<T,V>(eval);
    }
    
    public final <K> Function<Set<T>,Map<K,T>> zipKeys(final K... keys) {
        return new ZipKeys<K,T>(VarArgsUtil.asRequiredObjectList(keys));
    }
    
    public final <V> Function<Set<T>,Map<T,V>> zipValues(final V... values) {
        return new ZipValues<T,V>(VarArgsUtil.asRequiredObjectList(values));
    }
    
    public final <K> Function<Set<T>,Map<K,T>> zipKeysFrom(final Collection<K> keys) {
        return new ZipKeys<K,T>(keys);
    }
    
    public final <V> Function<Set<T>,Map<T,V>> zipValuesFrom(final Collection<V> values) {
        return new ZipValues<T,V>(values);
    }
    
    public final <K> Function<Set<T>,Map<K,T>> zipKeysFrom(final K[] keys) {
        return new ZipKeys<K,T>(keys);
    }
    
    public final <V> Function<Set<T>,Map<T,V>> zipValuesFrom(final V[] values) {
        return new ZipValues<T,V>(values);
    }
    
    public final <K,V> Function<Set<T>,Map<K,V>> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToMap<K,V,T>(mapBuilder);
    }
    
    public final <K,V> Function<Set<T>,Map<K,V>> toMap(final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction) {
        return new ToMapByKeyValueFunctions<K,V,T>(keyFunction, valueFunction);
    }
    
    public final <K,V> Function<Set<T>,Map<K,Set<V>>> toGroupMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new ToGroupMap<K,V,T>(mapBuilder);
    }
    
    public final <K,V> Function<Set<T>,Map<K,Set<V>>> toGroupMap(final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction) {
        return new ToGroupMapByKeyValueFunctions<K,V,T>(keyFunction, valueFunction);
    }
    
    public final Function<Set<T>,Map<T,T>> couple() {
        return new Couple<T>();
    }
    
    public final <K> Function<Set<T>,Map<K,Set<T>>> zipAndGroupKeysBy(final IFunction<? super T, K> eval) {
        return new ZipAndGroupKeysBy<K,T>(eval);
    }
    
    public final <V> Function<Set<T>,Map<T,Set<V>>> zipAndGroupValuesBy(final IFunction<? super T, V> eval) {
        return new ZipAndGroupValuesBy<T,V>(eval);
    }
    
    public final <K> Function<Set<T>,Map<K,Set<T>>> zipAndGroupKeys(final K... keys) {
        return new ZipAndGroupKeys<K,T>(VarArgsUtil.asRequiredObjectList(keys));
    }
    
    public final <V> Function<Set<T>,Map<T,Set<V>>> zipAndGroupValues(final V... values) {
        return new ZipAndGroupValues<T,V>(VarArgsUtil.asRequiredObjectList(values));
    }
    
    public final <K> Function<Set<T>,Map<K,Set<T>>> zipAndGroupKeysFrom(final Collection<K> keys) {
        return new ZipAndGroupKeys<K,T>(keys);
    }
    
    public final <V> Function<Set<T>,Map<T,Set<V>>> zipAndGroupValuesFrom(final Collection<V> values) {
        return new ZipAndGroupValues<T,V>(values);
    }
    
    public final <K> Function<Set<T>,Map<K,Set<T>>> zipAndGroupKeysFrom(final K[] keys) {
        return new ZipAndGroupKeys<K,T>(keys);
    }
    
    public final <V> Function<Set<T>,Map<T,Set<V>>> zipAndGroupValuesFrom(final V[] values) {
        return new ZipAndGroupValues<T,V>(values);
    }
    
    
    
    
    
    
    public final Function<Set<T>,Map<T,Set<T>>> coupleAndGroup() {
        return new CoupleAndGroup<T>();
    }
    
    
    
    
    public final Function<Set<T>,Boolean> all(final IFunction<? super T,Boolean> eval) {
        return new All<T>(eval);
    }
    
    public final Function<Set<T>,Boolean> any(final IFunction<? super T,Boolean> eval) {
        return new Any<T>(eval);
    }

    
    
    
    
    public final Function<Set<T>,Integer> count() {
        return new Count<T>();
    }
    
    
    
    
    public final Function<Set<T>,Boolean> contains(final T object) {
        return new Contains<T>(object);
    }
    
    public final Function<Set<T>,Boolean> notContains(final T object) {
        return FnBoolean.not(contains(object));
    }
    
    public final Function<Set<T>,Boolean> containsAll(final T... objects) {
        return new ContainsAll<T>(VarArgsUtil.asRequiredObjectList(objects));
    }
    
    public final Function<Set<T>,Boolean> containsAny(final T... objects) {
        return new ContainsAny<T>(VarArgsUtil.asRequiredObjectList(objects));
    }
    
    public final Function<Set<T>,Boolean> containsNone(final T... objects) {
        return new ContainsNone<T>(VarArgsUtil.asRequiredObjectList(objects));
    }
    
    
    
    
    
    public final Function<Set<T>,Set<T>> reverse() {
        return new Reverse<T>();
    }
    
    
    
    
    
    

    
    
    protected FnSetOf(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    static final class Sort<T> extends FnCollection.Sort<T, Set<T>> {

        Sort() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }


    
    
    
    static final class SortByComparator<T> extends FnCollection.SortByComparator<T, Set<T>> {

        SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }
    
    
    
    static final class SortBy<T> extends FnCollection.SortBy<T, Set<T>> {

        SortBy(final IFunction<? super T, ?> by) {
            super(by);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }
    
    
    
    
    static final class Add<T> extends FnCollection.Add<T, Set<T>> {

        Add(final T... newElements) {
            super(newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    
    static final class Insert<T> extends FnCollection.Insert<T, Set<T>> {

        Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    static final class AddAll<T> extends FnCollection.AddAll<T, Set<T>> {

        AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllIndexes<T> extends FnCollection.RemoveAllIndexes<T, Set<T>> {

        
        RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllEqual<T> extends FnCollection.RemoveAllEqual<T, Set<T>> {

        RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllTrue<T> extends FnCollection.RemoveAllTrue<T, Set<T>> {

        RemoveAllTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllFalse<T> extends FnCollection.RemoveAllFalse<T, Set<T>> {

        RemoveAllFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllIndexesNot<T> extends FnCollection.RemoveAllIndexesNot<T, Set<T>> {

        RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllNull<T> extends FnCollection.RemoveAllNull<T, Set<T>> {

        RemoveAllNull() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllNotNullAndTrue<T> extends FnCollection.RemoveAllNotNullAndTrue<T, Set<T>> {

        RemoveAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    static final class RemoveAllNotNullAndFalse<T> extends FnCollection.RemoveAllNotNullAndFalse<T, Set<T>> {

        RemoveAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    static final class RemoveAllNullOrTrue<T> extends FnCollection.RemoveAllNullOrTrue<T, Set<T>> {

        RemoveAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    static final class RemoveAllNullOrFalse<T> extends FnCollection.RemoveAllNullOrFalse<T, Set<T>> {

        RemoveAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    static final class ToArray<T> extends AbstractNotNullFunction<Set<T>,T[]>  {

        private final Type<T> type;
        
        ToArray(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }
    
    
    
    static final class ToList<T> extends AbstractNotNullFunction<Set<T>,List<T>> {

        ToList() {
            super();
        }

        @Override
        protected List<T> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(object);
        }
        
    }
    
    
    
    
    
    
    static final class ZipKeysBy<K, T> extends AbstractNotNullFunction<Set<T>,Map<K, T>>  {

        private final IFunction<? super T,K>  eval;
        
        ZipKeysBy(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, T> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, T> result = new LinkedHashMap<K, T>();
            for (final T element: object) {
                result.put(this.eval.execute(element, ctx), element);
            }
            return result;
        }
        
    }


    
    
    
    static final class ZipValuesBy<T, V> extends AbstractNotNullFunction<Set<T>,Map<T, V>>  {

        private final IFunction<? super T,V>  eval;
        
        ZipValuesBy(final IFunction<? super T,V>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<T, V> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<T, V> result = new LinkedHashMap<T, V>();
            for (final T element: object) {
                result.put(element, this.eval.execute(element, ctx));
            }
            return result;
        }
        
    }
    
    
    


    
    
    static final class ZipKeys<K, T> extends AbstractNotNullFunction<Set<T>,Map<K, T>>  {

        private final List<K> keys;
        
        ZipKeys(final Collection<K> keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = new ArrayList<K>(keys);
        }
        
        ZipKeys(final K[] keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = Arrays.asList(keys);
        }

        @Override
        protected Map<K, T> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() != this.keys.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of keys specified: should be " + object.size() + 
                        " but are " + this.keys.size());
            }
            final Map<K, T> result = new LinkedHashMap<K, T>();
            int index = 0;
            for (final T element: object) {
                result.put(this.keys.get(index), element);
                index++;
            }
            return result;
        }
        
    }
    
    static final class ZipValues<T, V> extends AbstractNotNullFunction<Set<T>,Map<T, V>>  {

        private final List<V> values;
        
        ZipValues(final Collection<V> values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = new ArrayList<V>(values);
        }
        
        ZipValues(final V[] values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = Arrays.asList(values);
        }

        @Override
        protected Map<T, V> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() != this.values.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of values specified: should be " + object.size() + 
                        " but are " + this.values.size());
            }
            final Map<T, V> result = new LinkedHashMap<T, V>();
            int index = 0;
            for (final T element: object) {
                result.put(element, this.values.get(index));
                index++;
            }
            return result;
        }
        
    }
    
    
    
    
    
    
    static final class ToMap<K, V, T> extends AbstractNotNullFunction<Set<T>,Map<K, V>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, V> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
        
    }

    
    
    
    static final class ToMapByKeyValueFunctions<K, V, T> extends AbstractNotNullFunction<Set<T>,Map<K,V>> {

        private final IFunction<? super T,K> keyFunction;
        private final IFunction<? super T,V> valueFunction;
        
        ToMapByKeyValueFunctions(final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction) {
            super();
            Validate.notNull(keyFunction, "A function for obtaining keys must be specified");
            Validate.notNull(valueFunction, "A function for obtaining keys must be specified");
            this.keyFunction = keyFunction;
            this.valueFunction = valueFunction;
        }

        @Override
        protected Map<K, V> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, V> result = new LinkedHashMap<K, V>();
            for (final T element: object) {
                final K key = this.keyFunction.execute(element, ctx);
                final V value = this.valueFunction.execute(element, ctx);
                result.put(key, value);
            }
            return result;
        }
        
    }
    
    
    
    static final class Couple<T> extends AbstractNotNullFunction<Set<T>,Map<T, T>>  {

        Couple() {
            super();
        }

        @Override
        protected Map<T, T> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, T> result = new LinkedHashMap<T, T>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                result.put(objectAsList.get(i), objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    protected static final <K,V> Map<K, V[]> createFromMapOfList(final Type<V> type, final Map<K, List<V>> mapOfList) {
        final Map<K, V[]> result = new LinkedHashMap<K, V[]>();
        for (final Map.Entry<K, List<V>> listEntry : mapOfList.entrySet()) {
            final K key = listEntry.getKey();
            final List<V> listValue = listEntry.getValue();
            final V[] arrayValue = (V[]) Array.newInstance(type.getRawClass(), listValue.size());
            result.put(key, listValue.toArray(arrayValue));
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    static final class ZipAndGroupKeysBy<K, T> extends AbstractNotNullFunction<Set<T>,Map<K, Set<T>>>  {

        private final IFunction<? super T,K>  eval;
        
        ZipAndGroupKeysBy(final IFunction<? super T,K>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<K, Set<T>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            for (final T element: object) {
                final K key = this.eval.execute(element, ctx);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(element);
            }
            return result;
        }
        
    }

    
    
    static final class ZipAndGroupValuesBy<T, V> extends AbstractNotNullFunction<Set<T>,Map<T,Set<V>>> {

        private final IFunction<? super T,V>  eval;
        
        ZipAndGroupValuesBy(final IFunction<? super T,V>  eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected Map<T,Set<V>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            final Map<T, Set<V>> result = new LinkedHashMap<T, Set<V>>();
            for (final T element: object) {
                final V valueElement = this.eval.execute(element, ctx);
                Set<V> value = result.get(element);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(element, value);
                }
                value.add(valueElement);
            }
            
            return result;
            
        }
        
    }

    

    
    
    
    
    
    
    static final class ZipAndGroupKeys<K, T> extends AbstractNotNullFunction<Set<T>,Map<K, Set<T>>>  {

        private final List<K> keys;
        
        ZipAndGroupKeys(final Collection<K> keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = new ArrayList<K>(keys);
        }
        
        ZipAndGroupKeys(final K[] keys) {
            super();
            Validate.notNull(keys, "Keys must be specified");
            this.keys = Arrays.asList(keys);
        }

        @Override
        protected Map<K, Set<T>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            if (object.size() != this.keys.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of keys specified: should be " + object.size() + 
                        " but are " + this.keys.size());
            }
            final Map<K, Set<T>> result = new LinkedHashMap<K, Set<T>>();
            int index = 0;
            for (final T element: object) {
                final K key = this.keys.get(index);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(element);
                index++;
            }
            return result;
            
        }
        
    }

    
    
    static final class ZipAndGroupValues<T, V> extends AbstractNotNullFunction<Set<T>,Map<T,Set<V>>> {

        private final List<V> values;
        
        ZipAndGroupValues(final Collection<V> values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = new ArrayList<V>(values);
        }
        
        ZipAndGroupValues(final V[] values) {
            super();
            Validate.notNull(values, "Values must be specified");
            this.values = Arrays.asList(values);
        }

        @Override
        protected Map<T,Set<V>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            if (object.size() != this.values.size()) {
                throw new IllegalArgumentException(
                        "Incorrect number of values specified: should be " + object.size() + 
                        " but are " + this.values.size());
            }
            final Map<T, Set<V>> result = new LinkedHashMap<T, Set<V>>();
            int index = 0;
            for (final T element: object) {
                final V valueElement = this.values.get(index);
                Set<V> value = result.get(element);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(element, value);
                }
                value.add(valueElement);
                index++;
            }
            
            return result;
            
        }
        
    }

    
    
    
    
    static final class ToGroupMap<K, V, T> extends AbstractNotNullFunction<Set<T>,Map<K, Set<V>>>  {

        private final IFunction<? super T,Map.Entry<K,V>> mapBuilder;
        
        ToGroupMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
            super();
            Validate.notNull(mapBuilder, "A map builder must be specified");
            this.mapBuilder = mapBuilder;
        }

        @Override
        protected Map<K, Set<V>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final Map.Entry<K,V> entry = this.mapBuilder.execute(element, ctx);
                if (entry == null) {
                    throw new ExecutionException(
                            "Map builder returned null, but a map builder should never return null");
                }
                final K key = entry.getKey();
                Set<V> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<V>();
                    result.put(key, value);
                }
                value.add(entry.getValue());
            }
            return result;
        }
        
    }

    
    

    
    static final class ToGroupMapByKeyValueFunctions<K, V, T> extends AbstractNotNullFunction<Set<T>,Map<K,Set<V>>> {

        
        private final IFunction<? super T,K> keyFunction;
        private final IFunction<? super T,V> valueFunction;
        
        ToGroupMapByKeyValueFunctions(final IFunction<? super T,K> keyFunction, final IFunction<? super T,V> valueFunction) {
            super();
            Validate.notNull(keyFunction, "A function for obtaining keys must be specified");
            Validate.notNull(valueFunction, "A function for obtaining keys must be specified");
            this.keyFunction = keyFunction;
            this.valueFunction = valueFunction;
        }

        @Override
        protected Map<K, Set<V>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            
            final Map<K, Set<V>> result = new LinkedHashMap<K, Set<V>>();
            for (final T element: object) {
                final K key = this.keyFunction.execute(element, ctx);
                final V value = this.valueFunction.execute(element, ctx);
                Set<V> valueList = result.get(key);
                if (valueList == null) {
                    valueList = new LinkedHashSet<V>();
                    result.put(key, valueList);
                }
                valueList.add(value);
            }
            
            return result;
            
        }
        
    }
    
    
    
    static final class CoupleAndGroup<T> extends AbstractNotNullFunction<Set<T>,Map<T, Set<T>>>  {

        CoupleAndGroup() {
            super();
        }

        @Override
        protected Map<T, Set<T>> notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            if (object.size() % 2 != 0) {
                throw new IllegalArgumentException("Cannot create a map from objects: the number of objects must be even.");
            }
            final List<T> objectAsList = new ArrayList<T>(object);
            final Map<T, Set<T>> result = new LinkedHashMap<T, Set<T>>();
            for (int i = 0, n = objectAsList.size() - 1; i < n; i += 2) {
                final T key = objectAsList.get(i);
                Set<T> value = result.get(key);
                if (value == null) {
                    value = new LinkedHashSet<T>();
                    result.put(key, value);
                }
                value.add(objectAsList.get(i + 1));
            }
            return result;
        }
        
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    static final class Any<T> extends AbstractNotNullFunction<Set<T>,Boolean> {

        private final IFunction<? super T, Boolean> function;
        
        
        public Any(IFunction<? super T, Boolean> function) {
            super();
            this.function = function;
        }
        
        
        @Override
        protected Boolean notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            int index = 0;
            for (final T element : object) {
                final Boolean elementResult = 
                    this.function.execute(element, new ExecCtxImpl(Integer.valueOf(index)));
                if (elementResult == null) {
                    throw new ExecutionException("Evaluation function returned null, which is " +
                            "not allowed executing \"any\"");
                }
                if (elementResult.booleanValue()) {
                    return Boolean.TRUE;
                }
                index++;
            }
            return Boolean.FALSE;
        }
        
    }

    
    
    static final class All<T> extends AbstractNotNullFunction<Set<T>,Boolean> {

        private final IFunction<? super T, Boolean> function;
        
        
        public All(IFunction<? super T, Boolean> function) {
            super();
            this.function = function;
        }
        
        
        @Override
        protected Boolean notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            int index = 0;
            for (final T element : object) {
                final Boolean elementResult = 
                    this.function.execute(element, new ExecCtxImpl(Integer.valueOf(index)));
                if (elementResult == null) {
                    throw new ExecutionException("Evaluation function returned null, which is " +
                            "not allowed executing \"all\"");
                }
                if (!elementResult.booleanValue()) {
                    return Boolean.FALSE;
                }
                index++;
            }
            return Boolean.TRUE;
        }
        
    }


    
    
    
    
    
    
    
    
    static final class Contains<T> extends AbstractNotNullFunction<Set<T>,Boolean> {
        
        private final T object;
        
        public Contains(final T object) {
            super();
            this.object = object;
        }

        @Override
        protected Boolean notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            for (final T element : input) {
                if (element == null) {
                    if (this.object == null) {
                        return Boolean.TRUE;
                    }
                } else if (element.equals(this.object)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        
    }
    
    
    static final class ContainsAll<T> extends AbstractNotNullFunction<Set<T>,Boolean> {
        
        private final List<T> objects;
        
        public ContainsAll(final List<T> objects) {
            super();
            this.objects = objects;
        }

        @Override
        protected Boolean notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            final Set<T> notContained = new HashSet<T>(this.objects);
            for (final T element : input) {
                for (final T comparedElement : this.objects) {
                    if (element == null) {
                        if (comparedElement == null) {
                            notContained.remove(null);
                        }
                    } else if (element.equals(comparedElement)) {
                        notContained.remove(comparedElement);
                    }
                }
            }
            return (notContained.isEmpty()? Boolean.TRUE : Boolean.FALSE);
        }
        
    }
    
    
    
    static final class ContainsAny<T> extends AbstractNotNullFunction<Set<T>,Boolean> {
        
        private final List<T> objects;
        
        public ContainsAny(final List<T> objects) {
            super();
            this.objects = objects;
        }

        @Override
        protected Boolean notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            for (final T element : input) {
                for (final T comparedElement : this.objects) {
                    if (element == null) {
                        if (comparedElement == null) {
                            return Boolean.TRUE;
                        }
                    } else if (element.equals(comparedElement)) {
                        return Boolean.TRUE;
                    }
                }
            }
            return Boolean.FALSE;
        }
        
    }
    
    
    
    static final class ContainsNone<T> extends AbstractNotNullFunction<Set<T>,Boolean> {
        
        private final List<T> objects;
        
        public ContainsNone(final List<T> objects) {
            super();
            this.objects = objects;
        }

        @Override
        protected Boolean notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            for (final T element : input) {
                for (final T comparedElement : this.objects) {
                    if (element == null) {
                        if (comparedElement == null) {
                            return Boolean.FALSE;
                        }
                    } else if (element.equals(comparedElement)) {
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }
        
    }
    

    
    
    
    static final class Reverse<T> extends AbstractNotNullNonConvertingFunc<Set<T>> {
        
        public Reverse() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected Set<T> notNullExecute(final Set<T> input, final ExecCtx ctx) throws Exception {
            
            final Object[] revertArray = input.toArray(new Object[input.size()]); 
            if (revertArray.length < 2) {
                return new LinkedHashSet<T>(input);
            }
            int size = revertArray.length;
            Object aux = null;
            for (int i = 0, z = size / 2; i < z; i++) {
                aux = revertArray[i];
                revertArray[i] = revertArray[size - (i + 1)];
                revertArray[size - (i + 1)] = aux;
            }
            final Set<T> result = new LinkedHashSet<T>();
            for (final Object element : revertArray) {
                result.add((T)element);
            }
            return result;
        }
        
    }
    
    static final class Count<T> extends AbstractNotNullFunction<Set<T>,Integer> {
        
        public Count() {
            super();
        }
        
        @Override
        protected Integer notNullExecute(final Set<T> object, final ExecCtx ctx) throws Exception {
            return Integer.valueOf(object.size());
        }
        
    }
}
