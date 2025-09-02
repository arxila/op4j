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
import io.arxila.op4j.exceptions.ExecutionException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnBoolean {

    
    private static final ToNumber<BigDecimal> TO_BIG_DECIMAL = new ToNumber<BigDecimal>(Types.BIG_DECIMAL);
    private static final ToNumber<BigInteger> TO_BIG_INTEGER = new ToNumber<BigInteger>(Types.BIG_INTEGER);
    private static final ToNumber<Double> TO_DOUBLE = new ToNumber<Double>(Types.DOUBLE);
    private static final ToNumber<Float> TO_FLOAT = new ToNumber<Float>(Types.FLOAT);
    private static final ToNumber<Long> TO_LONG = new ToNumber<Long>(Types.LONG);
    private static final ToNumber<Integer> TO_INTEGER = new ToNumber<Integer>(Types.INTEGER);
    private static final ToNumber<Short> TO_SHORT = new ToNumber<Short>(Types.SHORT);
    private static final ToNumber<Byte> TO_BYTE = new ToNumber<Byte>(Types.BYTE);
    private static final Negate NEGATE = new Negate();
    
    @SuppressWarnings("unchecked")
    private static final Function<Boolean,Boolean> IS_TRUE = (Function<Boolean,Boolean>) (Function<?,?>) eq(true);
    
    @SuppressWarnings("unchecked")
    private static final Function<Boolean,Boolean> IS_FALSE = (Function<Boolean,Boolean>) (Function<?,?>) eq(false);

    
    
	private FnBoolean() {
		super();           
	}

	
	
	
	

	/**
	 * <p>
	 * Converts a Boolean to a BigDecimal. true = 1, false = 0.
	 * </p>
	 * 
	 * @return a BigDecimal representing the boolean target.
	 */
	public static final Function<Boolean,BigDecimal> toBigDecimal() {
        return TO_BIG_DECIMAL;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a BigInteger. true = 1, false = 0.
     * </p>
     * 
     * @return a BigInteger representing the boolean target.
     */
    public static final Function<Boolean,BigInteger> toBigInteger() {
        return TO_BIG_INTEGER;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a Double. true = 1, false = 0.
     * </p>
     * 
     * @return a Double representing the boolean target.
     */
    public static final Function<Boolean,Double> toDouble() {
        return TO_DOUBLE;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a Float. true = 1, false = 0.
     * </p>
     * 
     * @return a Float representing the boolean target.
     */
    public static final Function<Boolean,Float> toFloat() {
        return TO_FLOAT;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a Long. true = 1, false = 0.
     * </p>
     * 
     * @return a Long representing the boolean target.
     */
    public static final Function<Boolean,Long> toLong() {
        return TO_LONG;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a Integer. true = 1, false = 0.
     * </p>
     * 
     * @return a Integer representing the boolean target.
     */
    public static final Function<Boolean,Integer> toInteger() {
        return TO_INTEGER;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a Short. true = 1, false = 0.
     * </p>
     * 
     * @return a Short representing the boolean target.
     */
    public static final Function<Boolean,Short> toShort() {
        return TO_SHORT;
    }
    
    
    /**
     * <p>
     * Converts a Boolean to a Byte. true = 1, false = 0.
     * </p>
     * 
     * @return a Byte representing the boolean target.
     */
    public static final Function<Boolean,Byte> toByte() {
        return TO_BYTE;
    }

    
    
    /**
     * <p>
     * Negates the target Boolean, returning Boolean.FALSE if the
     * target object is Boolean.TRUE, and Boolean.TRUE if it is Boolean.FALSE.
     * </p>
     * 
     * @return the negation of the target object.
     */
    public static final Function<Boolean,Boolean> negate() {
        return NEGATE;
    }
    
	

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final Boolean object) {
        return FnObject.eq(object);
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final boolean object) {
        return FnObject.eq(object);
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final Boolean object) {
        return FnObject.notEq(object);
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final boolean object) {
        return FnObject.notEq(object);
    }


    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final Boolean object) {
        return FnFunc.chain(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.chain(by, eq(object));
    }
    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final Boolean object) {
        return FnFunc.chain(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.chain(by, notEq(object));
    }

    
    
    /**
     * <p>
     * Returns true if the target object is <tt>Boolean.TRUE</tt>, false 
     * if it is <tt>Boolean.FALSE</tt>.
     * </p>
     * 
     * @return true if the target object is Boolean.TRUE, false if Boolean.FALSE
     */
    public static final Function<Boolean,Boolean> isTrue() {
        return IS_TRUE;
    }

    
    /**
     * <p>
     * Returns true if the target object is <tt>Boolean.FALSE</tt>, false 
     * if it is <tt>Boolean.TRUE</tt>.
     * </p>
     * 
     * @return true if the target object is Boolean.FALSE, false if Boolean.TRUE
     */
    public static final Function<Boolean,Boolean> isFalse() {
        return IS_FALSE;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * <p>
     * Takes two boolean functions (<tt>Function&lt;?,Boolean&gt;</tt>) as
     * parameters and returns another one which returns true if both functions
     * return true, and false if not.
     * </p>
     * 
     * @param left the left side of the "and" operation
     * @param right the right side of the "and" operation
     * @return a function returning true if both functions return true, and false if not.
     */
    public static final <X, R extends X> Function<R,Boolean> and(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
        return new And<X,R>(left, right);
    }

    
    /**
     * <p>
     * Takes two boolean functions (<tt>Function&lt;?,Boolean&gt;</tt>) as
     * parameters and returns another one which returns true if any of the functions
     * returns true, and false if not.
     * </p>
     * 
     * @param left the left side of the "or" operation
     * @param right the right side of the "or" operation
     * @return a function returning true if any of the functions return true, and false if not.
     */
    public static final <X, R extends X> Function<R,Boolean> or(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
        return new Or<X,R>(left, right);
    }

    
    /**
     * <p>
     * Takes a boolean function (<tt>Function&lt;?,Boolean&gt;</tt>) as a
     * parameter and returns another one which returns true if the specified function
     * returns false, and false if the function returns true.
     * </p>
     * 
     * @param function the function to be negated
     * @return a function returning true if the specified function returns false, and false if 
     *         it returns true.
     */
    public static final <T> Function<T,Boolean> not(final IFunction<T, Boolean> function) {
        return new Not<T>(function);
    }
    
    
    
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the
     * specified function on the target object is null or not.
     * </p>
     * 
     * @return true if the function result is null, false if not.
     */
    public static final <X> Function<X,Boolean> isNullBy(final IFunction<X,?> by) {
        return FnFunc.chain(by, FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the
     * specified function on the target object is null or not.
     * </p>
     * 
     * @return false if the function result is null, true if not.
     */
    public static final <X> Function<X,Boolean> isNotNullBy(final IFunction<X,?> by) {
        return FnFunc.chain(by, FnObject.isNotNull());
    }
    
    
    
    
	
    
	
    
    static final class ToNumber<X extends Number> extends AbstractNullAsNullFunction<Boolean,X> {

        private final Number trueValue;
        private final Number falseValue;
        
        
        protected ToNumber(final Type<X> type) {
            super();
            if (type.equals(Types.BIG_DECIMAL)) {
                this.trueValue = BigDecimal.valueOf(1);
                this.falseValue = BigDecimal.valueOf(0);
            } else if (type.equals(Types.BIG_INTEGER)) {
                this.trueValue = BigInteger.valueOf(1);
                this.falseValue = BigInteger.valueOf(0);
            } else if (type.equals(Types.DOUBLE)) {
                this.trueValue = Double.valueOf(1);
                this.falseValue = Double.valueOf(0);
            } else if (type.equals(Types.FLOAT)) {
                this.trueValue = Float.valueOf(1);
                this.falseValue = Float.valueOf(0);
            } else if (type.equals(Types.LONG)) {
                this.trueValue = Long.valueOf(1);
                this.falseValue = Long.valueOf(0);
            } else if (type.equals(Types.INTEGER)) {
                this.trueValue = Integer.valueOf(1);
                this.falseValue = Integer.valueOf(0);
            } else if (type.equals(Types.SHORT)) {
                this.trueValue = Short.valueOf((short)1);
                this.falseValue = Short.valueOf((short)0);
            } else if (type.equals(Types.BYTE)) {
                this.trueValue = Byte.valueOf((byte)1);
                this.falseValue = Byte.valueOf((byte)0);
            } else {
                throw new ExecutionException("Unsupported type \"" + type + "\"");
            }
        }

        
        @Override
        @SuppressWarnings("unchecked")
        public final X nullAsNullExecute(final Boolean number, final ExecCtx ctx) throws Exception {
            return (number.booleanValue()? (X) this.trueValue : (X) this.falseValue);
        }
        
    }

    
 
    
    
    

    
    
    
    static class Negate extends AbstractNullAsNullFunction<Boolean, Boolean> {

        public Negate() {
            super();
        }

        @Override
        protected Boolean nullAsNullExecute(final Boolean object, final ExecCtx ctx) throws Exception {
            return (object.booleanValue()? Boolean.FALSE : Boolean.TRUE);
        }
        
        
    }
    
    
    
    
    static class And<X,R extends X> extends Function<R, Boolean> {

        private final IFunction<X,Boolean> left;
        private final IFunction<? super R,Boolean> right;
        
        public And(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
            super();
            Validate.notNull(left, "Null function found: None of the specified functions can be null");
            Validate.notNull(right, "Null function found: None of the specified functions can be null");
            this.left = left;
            this.right = right;
        }

        public Boolean execute(final R object, final ExecCtx ctx) throws Exception {
            
            Boolean result = this.left.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"and\"");
            }
            if (!result.booleanValue()) {
                return Boolean.FALSE;
            }
            result = this.right.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"and\"");
            }
            if (!result.booleanValue()) {
                return Boolean.FALSE;
            }
                
            return Boolean.TRUE;
            
        }
        
        
    }
    
    
    
    
    static class Or<X,R extends X> extends Function<R, Boolean> {

        private final IFunction<X,Boolean> left;
        private final IFunction<? super R,Boolean> right;
        
        public Or(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
            super();
            Validate.notNull(left, "Null function found: None of the specified functions can be null");
            Validate.notNull(right, "Null function found: None of the specified functions can be null");
            this.left = left;
            this.right = right;
        }

        public Boolean execute(final R object, final ExecCtx ctx) throws Exception {
            
            Boolean result = this.left.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"or\"");
            }
            if (result.booleanValue()) {
                return Boolean.TRUE;
            }
            
            result = this.right.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"or\"");
            }
            if (result.booleanValue()) {
                return Boolean.TRUE;
            }
                
            return Boolean.FALSE;
            
        }
        
        
    }
    



    
    
    static class Not<T> extends Function<T, Boolean> {

        private final IFunction<T,Boolean> function;
        
        public Not(final IFunction<T,Boolean> function) {
            super();
            Validate.notNull(function, "Null function found: None of the specified functions can be null");
            this.function = function;
        }

        public Boolean execute(final T object, final ExecCtx ctx) throws Exception {
            final Boolean result = this.function.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"or\"");
            }
            if (result.booleanValue()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        
        
    }


}
