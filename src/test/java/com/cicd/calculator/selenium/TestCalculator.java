package com.cicd.calculator.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

@TestMethodOrder(Alphanumeric.class)
public class TestCalculator extends LocatePageElements{
	
	//Test to verify the Add page URL
	@Test
	public void aurlAddTest(){
    String urlActual=driver.getCurrentUrl();
	String urlExpected= "http://localhost:8181/add";
	assertEquals(urlExpected,urlActual);
  }
	
	//Test to verify the Add Page Title
	@Test
	public void bTitleAdd(){
	String actualPageTitle=driver.getTitle();
	String expected= "Calculator - ADD";
	assertEquals(expected,actualPageTitle);
  }
	
	//Test to verify the Add Page header
	@Test
	public void cHeaderAddTest(){
	String actualValue= driver.findElement(By.cssSelector("div:nth-child(1)> h1")).getText();
	String expected= "CI/CD Miniräknare";
	assertEquals(expected,actualValue);
  }
	
	//Test to verify the result of addition
	@Test
	public void dResultAddTest() throws InterruptedException { 
	 TypeFirstValue("7");
	 TypeSecondValue("3");
	 Thread.sleep(1500);
	 PressAddButton();
	 Thread.sleep(3000);
	 String actualResult= GetResult();
     String expectedResult="10";
     assertEquals(expectedResult,actualResult);
   }
	
	//Test to verify the Subtract Page URL
	@Test
	public void eUrlSubtractTest(){
	  ClickSubtractLink();
	  String urlActual=driver.getCurrentUrl();
	  String urlExpected= "http://localhost:8181/subtract";
	  assertEquals(urlExpected,urlActual);
	}
		
		//Test to verify the Subtract Page Title
		@Test
		public void fTitleSubtractTest(){
		ClickSubtractLink();	
		String actualPageTitle=driver.getTitle();
		String expected= "Calculator - SUBTRACT";
		assertEquals(expected,actualPageTitle);
	}

		//Test to verify the Subtract Page header
		@Test
		public void gHeaderSubtractTest(){
		ClickSubtractLink();	
		String actualValue= driver.findElement(By.cssSelector("div:nth-child(1)> h1")).getText();
		String expected= "CI/CD Miniräknare";
		assertEquals(expected,actualValue);
	 }
		
		//Test to verify the Subtraction result
		@Test
		public void hResultSubtractTest() throws InterruptedException{ 
		 ClickSubtractLink();
		 Thread.sleep(3000);
		 TypeFirstValue("7");
		 TypeSecondValue("3");
		 Thread.sleep(1500);
		 PressSubtractButton();
		 Thread.sleep(3000);
		 String actualResult= GetResult();
	     String expectedResult="4";
	     assertEquals(expectedResult,actualResult);
	  }
		
		//Test to verify the Multiplication URL
		@Test
		public void iUrlMultiplyTest(){
		ClickMultiplyLink();
	    String urlActual=driver.getCurrentUrl();
		String urlExpected= "http://localhost:8181/multiply";
		assertEquals(urlExpected,urlActual);
		}
		
		//Test to verify the Multiplication Page Title
		@Test
		public void jTitleMultiplyTest(){
		ClickMultiplyLink();
		String actualPageTitle=driver.getTitle();
		String expected= "Calculator - MULTIPLY";
		assertEquals(expected,actualPageTitle);
	    }

		//Test to verify the Multiplication Header
		@Test
		public void kHeaderMultiplyTest(){
		ClickMultiplyLink();	
		String actualValue= driver.findElement(By.cssSelector("div:nth-child(1)> h1")).getText();
		String expected= "CI/CD Miniräknare";
		assertEquals(expected,actualValue);
	    }
		
		//Test to verify the Multiplication result
		@Test
		public void lResultMultiplyTest() throws InterruptedException{ 
		 ClickMultiplyLink();
		 Thread.sleep(3000);
		 TypeFirstValue("7");
		 TypeSecondValue("3");
		 Thread.sleep(3000);
		 PressMultiplyButton();
		 Thread.sleep(3000);
		 String actualResult= GetResult();
	     String expectedResult="21";
	     assertEquals(expectedResult,actualResult);
	    }
		
		//Test to verify the Division URL
		@Test
		public void mUrlDivideTest(){
		ClickDivideLink();
	    String urlActual=driver.getCurrentUrl();
		String urlExpected= "http://localhost:8181/divide";
		assertEquals(urlExpected,urlActual);
		}
		
		//Test to verify the Division Page Title
		@Test
		public void nTitleDivideTest(){
		ClickDivideLink();
		String actualPageTitle=driver.getTitle();
		String expected= "Calculator - DIVIDE";
		assertEquals(expected,actualPageTitle);
	    }

		//Test to verify the Division Header
		@Test
		public void oHeaderDivideTest(){
		ClickDivideLink();	
		String actualValue= driver.findElement(By.cssSelector("div:nth-child(1)> h1")).getText();
		String expected= "CI/CD Miniräknare";
		assertEquals(expected,actualValue);
	    }
		
		//Test to verify the Division Result
		@Test
		public void wResultDivideTest() throws InterruptedException 
		{ 
		 ClickDivideLink();	
		 Thread.sleep(3000);
		 TypeFirstValue("6");
		 TypeSecondValue("3");
		 Thread.sleep(1500);
		 PressDivideButton();
		 Thread.sleep(3000);
		 String actualResult= GetResult();
	     String expectedResult="2.0";
	     assertEquals(expectedResult,actualResult);
	    }
			
}