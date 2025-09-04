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
import io.arxila.op4j.functions.ExecCtx;
import io.arxila.op4j.functions.IFunction;
import io.arxila.op4j.target.Target.Structure;
import io.arxila.op4j.util.ExecCtxImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
final class ExecutionTargetMapIfOperation implements ExecutionTargetOperation {

    private final boolean desiredResult;
    private final IFunction<Object,Boolean> condition;
    private final IFunction<Object,Object> executable;
    private final IFunction<Object,Object> elseExecutable;
    private final Structure structure;
    private final Class<?> arrayComponentClass;

    
    
    
    @SuppressWarnings("unchecked")
    public ExecutionTargetMapIfOperation(final boolean desiredResult, final Structure structure, final IFunction<?,Boolean> condition, final IFunction<?,?> executable, final IFunction<?,?> elseExecutable, final Class<?> arrayComponentClass) {
        super();
        this.desiredResult = desiredResult;
        this.structure = structure;
        this.condition = (IFunction<Object,Boolean>) condition;
        this.executable = (IFunction<Object,Object>) executable;
        this.elseExecutable = (IFunction<Object,Object>) elseExecutable;
        this.arrayComponentClass = arrayComponentClass;
    }
    

    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final Integer index) {
        
        if (target == null) {
            
            throw new IllegalArgumentException("Cannot iterate on null: the \"map if not null\"" +
            		"operation allows any element of the iterated structure to be null, but " +
            		"not the structure being iterated itself.");
            
        }

        try {
            
            switch(this.structure) {
            
                case ARRAY:
                    
                    final Object[] arrayTarget = (Object[])target;
                    final Object[] arrayResult = 
                        (Object[]) Array.newInstance(this.arrayComponentClass, arrayTarget.length);
                    for (int i = 0, z = arrayTarget.length; i < z; i++) {
                        final ExecCtx ctx = new ExecCtxImpl(Integer.valueOf(i));
                        final boolean conditionResult = 
                            this.condition.execute(arrayTarget[i], ctx).booleanValue();
                        arrayResult[i] =
                            (conditionResult != this.desiredResult?
                                (this.elseExecutable == null?
                                        arrayTarget[i] :
                                        this.elseExecutable.execute(arrayTarget[i], ctx)) :
                                this.executable.execute(arrayTarget[i], ctx));
                    }
                    return arrayResult;
    
                case LIST:
                    
                    final List<?> listTarget = (List<?>)target;
                    final List<Object> listResult = new ArrayList<Object>();
                    int iList = 0;
                    for (final Object element : listTarget) {
                        final ExecCtx ctx = new ExecCtxImpl(Integer.valueOf(iList)); 
                        final boolean conditionResult = 
                            this.condition.execute(element, ctx).booleanValue();
                        listResult.add(
                                (conditionResult != this.desiredResult?
                                        (this.elseExecutable == null?
                                                element :
                                                this.elseExecutable.execute(element, ctx)) :
                                        this.executable.execute(element, ctx)));
                        iList++;
                    }
                    return listResult;
                    
                    
                case SET:
                    
                    final Set<?> setTarget = (Set<?>)target;
                    final Set<Object> setResult = new LinkedHashSet<Object>();
                    int iSet = 0;
                    for (final Object element : setTarget) {
                        final ExecCtx ctx = new ExecCtxImpl(Integer.valueOf(iSet)); 
                        final boolean conditionResult = 
                            this.condition.execute(element, ctx).booleanValue();
                        setResult.add(
                                (conditionResult != this.desiredResult?
                                        (this.elseExecutable == null?
                                                element :
                                                this.elseExecutable.execute(element, ctx)) :
                                        this.executable.execute(element, ctx)));
                        iSet++;
                    }
                    return setResult;
                    
                default:
                    
                    throw new IllegalStateException("Unsupported structure: " +  this.structure);
                    
            }

        } catch (ExecutionException e) {
            throw e;
        } catch (Throwable t) {
            throw new ExecutionException(t);
        }
            
    }
    
}
