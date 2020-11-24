package com.cicd.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(controllers=CalculatorController.class)
public class ControllerTest {
	
	@Autowired
	CalculatorController controller= new  CalculatorController();
	    
	@Autowired
	private MockMvc mockMvc;
			
	@Before
		public void setup() throws Exception{
		this.mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
		
	@Test
	public void controllerObjectTest(){
	   assertNotNull(controller);//verifies whether the controller object is not null
	}
	
	@Test
	public void contentTypeAddTest() throws Exception{
	MvcResult	result=	mockMvc.perform(MockMvcRequestBuilders.get("/add")).andReturn();
	String contentType=result.getResponse().getContentType().toString();
	assertEquals("text/html;charset=UTF-8",contentType);//verifies if the content type is html.
	}
	
	@Test
	public void statusAddPostTest() throws Exception{
	MvcResult result=mockMvc.perform(MockMvcRequestBuilders.post("/ad")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(404,statusCode);//verifies if status code returned is 404 for the unsuccessful post.
	}
	
	@Test
	public void statusAddGetTest() throws Exception{
	MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/add")).andReturn();
	String ErrorMessage=result.getResponse().getErrorMessage();
	assertEquals(null,ErrorMessage); //verifies if the error message is null for an successful request.
	}
	
	/*This test is expected to fail because subtract is not correct URL. It should be /subtract */
	@Test 
	public void statusSubtractPostTest() throws Exception{
	MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.post("subtract")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(200,statusCode); 
	}
	
	/*verifies if exception is thrown for the wrong arguments.*/
	@Test
	  void testExpectedExceptionMultiply() {
	 	   assertThrows(IllegalArgumentException.class, () -> { 
		   mockMvc.perform(MockMvcRequestBuilders.post("multiply"));
	    });
	  }
	
	/*verifies if the status code is 200 for the successful get request for subtract */
	@Test
	public void statusSubtractGetTest() throws Exception{
	MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/subtract")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(200,statusCode);
	}
	
	/*verifies if the status code is 200 for the successful get request for multiply */
	@Test
	public void statusMultiplyGetTest() throws Exception{
	MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.get("/multiply")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(200,statusCode);
	}
	
	/*verifies if the status code is 200 for the successful post request for multiply */
	@Test
	public void statusMultiplyPostTest() throws Exception{
	MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.post("/multiply")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(200,statusCode);
	}
	
	/*verifies if the status code is 200 for the successful get request for divide */
	@Test
	public void statusDivideGetTest() throws Exception{
	MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.get("/divide")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(200,statusCode);
	}
	
	/*verifies if the status code is 200 for the successful post request for divide */
	@Test
	public void statusDividePostTest() throws Exception{
	MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.post("/divide")).andReturn();
	int statusCode=result.getResponse().getStatus();
	assertEquals(200,statusCode);
	}
}
