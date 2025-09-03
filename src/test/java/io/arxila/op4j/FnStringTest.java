package io.arxila.op4j;


import io.arxila.op4j.functions.FnString;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings (value = "cast")
public class FnStringTest {
	
	@BeforeEach
	public void setUp() throws Exception {
		
	}

	@SuppressWarnings({ "boxing" })
	@Test
	public void testDouble() {
		List<Double> resultD = Op.on(new String[] { "-180.0" }).toList().map(FnString.toDouble()).get();
		assertTrue(resultD.containsAll(Op.onListFor(Double.valueOf(-180)).get()));
		assertTrue(Op.onListFor(Double.valueOf(-180)).get().containsAll(resultD));
		
		resultD = Op.onListFor("-10.2").forEach().exec(FnString.toDouble()).get();
		assertTrue(resultD.containsAll(Op.onListFor(Double.valueOf(-10.2)).get()));
		assertTrue(Op.onListFor(Double.valueOf(-10.2)).get().containsAll(resultD));
				
	}
	
	@SuppressWarnings({ "boxing" })
	@Test
	public void testFloat() {
		
		List<Float> resultF = Op.on(new String[] { "-180" }).toList().map(FnString.toFloat()).get();
		assertTrue(resultF.containsAll(Op.onListFor(Float.valueOf(-180)).get()));
		assertTrue(Op.onListFor(Float.valueOf(-180)).get().containsAll(resultF));
		
		
		resultF = Op.onListFor("-10").forEach().exec(FnString.toFloat()).get();
		assertTrue(resultF.containsAll(Op.onListFor(Float.valueOf(-10)).get()));
		assertTrue(Op.onListFor(Float.valueOf(-10)).get().containsAll(resultF));
		
		
		resultF = Op.onListFor("-10.45").forEach().exec(FnString.toFloat()).get();
		assertTrue(resultF.containsAll(Op.onListFor(Float.valueOf("-10.45")).get()));
		assertTrue(Op.onListFor(Float.valueOf("-10.45")).get().containsAll(resultF));
				
	}
}
