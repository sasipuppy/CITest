package com.cicd.calculator.selenium;

import org.openqa.selenium.By;

public class LocatePageElements extends BaseClass{
	    //Type in First Value
		public void TypeFirstValue(String firstNumber) {
			driver.findElement(By.id("firstValue")).sendKeys(firstNumber);
		 }
		
		//Type in Second Value
		public void TypeSecondValue(String secondNumber) {
			driver.findElement(By.id("secondValue")).sendKeys(secondNumber);
		}
			
		//Press Add button.
		public void PressAddButton() {
			driver.findElement(By.xpath("//input[@value='Addera']")).click();
		}
		
		//Press Subtract button.
		public void PressSubtractButton() {
			driver.findElement(By.xpath("//input[@value='Subtrahera']")).click();
		}
		
		//Press Multiply button.
		public void PressMultiplyButton() {
			driver.findElement(By.xpath("//input[@value='Multiplicera']")).click();
		}
		
				
		//Press Divide button.
		public void PressDivideButton() {
			driver.findElement(By.xpath("//input[@value='Dividera']")).click();
		}
		
		//Click Add link.
		public void ClickAddLink() {
			driver.findElement(By.cssSelector("div[class='menu'] li:nth-child(1)")).click();
		}
		
		//Click Subtract link.
		public void ClickSubtractLink() {
			driver.findElement(By.cssSelector("div[class='menu'] li:nth-child(2)")).click();
		}
		
		//Click Multiply link.
		public void ClickMultiplyLink() {
			driver.findElement(By.cssSelector("div[class='menu'] li:nth-child(3)")).click();
		}
		
		//Click Divide link.
		public void ClickDivideLink() {
			driver.findElement(By.cssSelector("div[class='menu'] li:nth-child(4)")).click();
		}
		
		//Get Result
		public String GetResult() {
			return driver.findElement(By.cssSelector("div[class='calc-content'] h3:nth-child(2) p:nth-child(1)")).getText();
		}
       		
}
