package com.cicd.calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cicd.calculator.domain.Calculator;

public class CalculatorTest {
	
Calculator calc;

@BeforeEach
public void init()
{
 calc=new Calculator();
}

@Test
public void calculatorObjectTest(){
  assertNotNull(calc);
 }

@Nested
class Value
{
	void testFirstvalue() {
		calc.setFirstValue(5);
		assertEquals(5,calc.getFirstValue());
	}	
	
	void testSecondValue() {
		calc.setSecondValue(800);
		assertEquals(800,calc.getSecondValue());
	}
}

@Nested
class Addition
{ 
	
	@Test
	void addPositiveNumbers() {
		assertEquals(105,calc.Add(5,100));
	}
	
	
	@Test
	void addNegativeNumbers() {
		assertEquals(-56,calc.Add(-50,-6));
	}
	
		
	@Test
	void addMixedNumbers() {
		assertEquals(-24,calc.Add(-30,6));
	}
		
	@Test
	void addWithZero() {
		assertEquals(-6,calc.Add(0,-6));
	}
	
}

@Nested
class Subtraction
{
	@Test
	void subtractPositiveNumbers() {
		assertEquals(-95,calc.Subtract(5,100));
		assertEquals(95,calc.Subtract(100,5));
	}
		
	@Test
	void subtractNegativeNumbers() {
		assertEquals(-44,calc.Subtract(-50,-6));
		assertEquals(44,calc.Subtract(-6,-50));
	}
	
	@Test
	void subtractMixedNumbers() {
		assertEquals(-36,calc.Subtract(-30,6));
	}
	
	@Test
	void subtractZero() {
		assertEquals(6,calc.Subtract(6,0));
	}
}	

@Nested
class Multiply
{	
	@Test
	void multiplyPositive() {
		assertEquals(500,calc.Multiply(5,100));
	}
	
	@Test
	void multiplyNegative() {
		assertEquals(500,calc.Multiply(-5,-100));
	}
	
	@Test
	void multiplyZero() {
		assertEquals(0,calc.Multiply(0,-100));
	}
	
	@Test
	void multiplyMixed() {
		assertEquals(-500,calc.Multiply(-50,10));
	}
}

@Nested
class Divide
{
	@Test
	void DividePositive() {
		assertEquals(5,calc.Divide(500,100));
	}
	
	@Test
	void DivideNegative() {
		assertEquals(5,calc.Divide(-500,-100));
	}
	
	@Test
	void DivideByZero() {
		assertEquals(0,calc.Divide(100,0));
	}
	
	@Test
	void DivideMixed() {
		assertEquals(-5,calc.Divide(-500,100));
	}
	
	@Test
	void DivideZero() {
		assertEquals(0,calc.Divide(0,10));
	}
  }
}
