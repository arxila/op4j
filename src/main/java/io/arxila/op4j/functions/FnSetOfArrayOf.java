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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnSetOfArrayOf<T> extends FnSetOf<T[]> {

    
    
    
    public final Function<Set<T[]>,Set<T>> flattenArrays() {
        return new FlattenArrays<T>();
    }
    
    

    
    
    protected FnSetOfArrayOf(final Type<T> type) {
        super(Types.arrayOf(type));
    }
    
    
    
    
    
    static final class FlattenArrays<T> extends FnCollection.FlattenCollectionOfArrays<T, Set<T>, Set<T[]>> {

        
        FlattenArrays() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
}
