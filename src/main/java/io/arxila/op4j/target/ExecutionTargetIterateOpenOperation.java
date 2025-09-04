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

package io.arxila.op4j.target;

import io.arxila.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetIterateOpenOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final Structure structure;

    
    
    public ExecutionTargetIterateOpenOperation(final int internalBlock, final Structure structure) {
        super();
        this.internalBlock = internalBlock;
        this.structure = structure;
    }

    
    public ExecutionTargetIterateClosedOperation close(final Class<?> arrayComponentClass) {
        return new ExecutionTargetIterateClosedOperation(this.internalBlock, this.structure, arrayComponentClass);
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final Integer index) {
        throw new IllegalStateException("Cannot execute while open");
    }
    
    
}
