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
import java.util.List;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnListOfListOf<T> extends FnListOf<List<T>> {

    
    
    
    public final Function<List<List<T>>,List<T>> flattenLists() {
        return new FlattenLists<T>();
    }
    
    

    
    
    protected FnListOfListOf(final Type<T> type) {
        super(Types.listOf(type));
    }
    
    
    
    
    
    static final class FlattenLists<T> extends FnCollection.FlattenCollectionOfCollections<T, List<T>, List<List<T>>> {

        
        FlattenLists() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
}
