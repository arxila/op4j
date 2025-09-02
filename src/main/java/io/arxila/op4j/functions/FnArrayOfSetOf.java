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
import io.arxila.javaruntype.type.Types;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnArrayOfSetOf<T> extends FnArrayOf<Set<T>> {

    
    
    
    public final Function<Set<T>[],T[]> flattenSets() {
        return new FlattenSets<T>(Types.setComponentOf(this.type));
    }
    
    
    
    
    protected FnArrayOfSetOf(final Type<T> type) {
        super(Types.setOf(type));
    }
    
    
    

    

    
    static final class FlattenSets<T> extends AbstractNotNullFunction<Set<T>[],T[]> {

        private final Type<T> type; 

        FlattenSets(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected T[] notNullExecute(final Set<T>[] object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final Set<T> element : object) {
                result.addAll(element);
            }
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
            
        }

    }
    
    
    
    
}
