package in.pwskills.nitin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import in.pwskills.nitin.calculator.CalculatorApp;

public class CalculatorAppTest {
	
	static {
		System.out.println("CalculatorAppTest.class file is loading()");
	}
	
	public CalculatorAppTest() {
		System.out.println("CalcualtorAppTestObject is created...");
	}
	
	static CalculatorApp app =null;
	
	@BeforeAll
	public static void setUp() {
		//creating a setup for testing environment
		System.out.println("Calculatortestapp.setUp()");
		app=new CalculatorApp();
	}
	
	//Test case for add(a,b)
	@Test
	public void addtest() {
		System.out.println("addtest is testing");
		int actual=app.add(12, 12);
		int expacted=24;
		//use junit annotations to test the result
		assertEquals(expacted, actual);
	}
	
	//Test case for isEven(a)
	@Test
	public void isEven() {
		System.out.println("isEven is testing");
		boolean yes=app.isEven(22);
		
		assertTrue(yes);
	}
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("CalculatorAppTest.cleanUp()");
		app =null;
		System.out.println("*************");
	}
}
