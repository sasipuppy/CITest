package com.cicd.calculator.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.cicd.calculator.CalculatorApplication;

public class BaseClass {
	public static WebDriver driver;
	protected static ConfigurableApplicationContext context;
	
	@BeforeAll
	public static void setUp()
	{
	  context=SpringApplication.run(CalculatorApplication.class);
	  //Driver for Firefox browser 
	  //System.setProperty("webdriver.gecko.driver", "C:\\Users\\venky\\Desktop\\Java Tools\\WebDriver\\geckodriver.exe");
	  //driver= new FirefoxDriver();
	  //Driver for Chrome browser 
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\venky\\Desktop\\Java Tools\\WebDriver\\driver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("http://localhost:8181/add");
	  driver.manage().window().maximize();
	}
	
	@BeforeEach
    public void init(){
       driver.get("http://localhost:8181/add");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
	
	@AfterAll
	public static void teardown()
	{
	  driver.quit();
	}

}
