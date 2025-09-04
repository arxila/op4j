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

import io.arxila.op4j.exceptions.ExecutionException;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.util.ExecCtxImpl;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetSelectNullOrMatchingOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final boolean desiredResult;
    private final IFunction<Object,Boolean> eval; 

    
    
    public ExecutionTargetSelectNullOrMatchingOperation(final int internalBlock, final boolean desiredResult, final IFunction<Object,Boolean> eval) {
        super();
        this.internalBlock = internalBlock;
        this.desiredResult = desiredResult;
        this.eval = eval;
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final Integer index) {

        if (target == null) {
            
            Object result = target;
            for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                result = operations[this.internalBlock][j].execute(result, operations, index);
            }
            return result;
            
        }
            
        Boolean evalResult = null;
        try {
            evalResult = this.eval.execute(target, new ExecCtxImpl(index)); 
        } catch (Exception e) {
            throw new ExecutionException(e);
        }
        
        if ((evalResult != null && evalResult.booleanValue()) == this.desiredResult) {
            
            Object result = target;
            for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                result = operations[this.internalBlock][j].execute(result, operations, index);
            }
            return result;
            
        }
            
        return target;
        
    }
    
}
