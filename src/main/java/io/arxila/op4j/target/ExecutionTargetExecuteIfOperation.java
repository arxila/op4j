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

import io.arxila.javaruntype.type.Types;
import io.arxila.op4j.exceptions.ExecutionException;
import io.arxila.op4j.functions.ExecCtx;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.target.Target.Normalisation;
import io.arxila.op4j.util.ExecCtxImpl;
import io.arxila.op4j.util.NormalisationUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetExecuteIfOperation implements ExecutionTargetOperation {

    private final boolean desiredResult;
    private final IFunction<Object,Boolean> condition;
    private final IFunction<Object,Object> executable;
    private final IFunction<Object,Object> elseExecutable;
    private final Normalisation normalisation;

    
    
    @SuppressWarnings("unchecked")
    public ExecutionTargetExecuteIfOperation(final boolean desiredResult, final IFunction<?,Boolean> condition, final IFunction<?,?> executable, final IFunction<?,?> elseExecutable, final Normalisation normalisation) {
        super();
        this.desiredResult = desiredResult;
        this.condition = (IFunction<Object,Boolean>) condition;
        this.executable = (IFunction<Object,Object>) executable;
        this.elseExecutable = (IFunction<Object,Object>) elseExecutable;
        this.normalisation = normalisation;
    }
    
    
    
    @SuppressWarnings("unchecked")
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final Integer index) {

        final ExecCtx ctx = new ExecCtxImpl(index);
        
        boolean conditionResult = false;
        try {
            conditionResult = this.condition.execute(target, ctx).booleanValue();
        } catch (final Exception e) {
            throw new ExecutionException("Exception raised while executing \"executeIf\" action: " +
            		"condition raised an exception", e);
        }

        
        IFunction<Object,Object> appliedExecutable = this.executable;

        if (conditionResult != this.desiredResult) {
            if (this.elseExecutable == null) {
                return target;
            }
            appliedExecutable = this.elseExecutable;
        }
        
        try {
            Object result = appliedExecutable.execute(target, ctx);
            switch (this.normalisation.getNormalisationType()) {
                case TYPE_ARRAY:
                    NormalisationUtils.checkIsArray(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArray((Object[])result, this.normalisation.getArrayComponentClass());
                    break;
                case TYPE_LIST:
                    NormalisationUtils.checkIsList(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseList((List<Object>)result);
                    break;
                case TYPE_MAP:
                    NormalisationUtils.checkIsMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMap((Map<Object, Object>)result);
                    break;
                case TYPE_MAPENTRY:
                    NormalisationUtils.checkIsMapEntry(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntry((Map.Entry<Object, Object>)result);
                    break;
                case TYPE_SET:
                    NormalisationUtils.checkIsSet(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSet((Set<Object>)result);
                    break;
                case TYPE_NONE:
            }
            return result;
        } catch (ExecutionException e) {
            throw e;
        } catch (Throwable t) {
            throw new ExecutionException(t);
        }
        
    }
    
}
