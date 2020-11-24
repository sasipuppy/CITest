package com.cicd.calculator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cicd.calculator.domain.Calculator;


@WebMvcTest(controllers=CalculatorController.class)
public class ControllerMockMVCTest {
	
	@Autowired
	CalculatorController controller= new  CalculatorController();
	    
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Calculator calculator;
	
	@Before
		public void setup() throws Exception{
		this.mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void controllerObjectTest(){
	   assertNotNull(controller);
	}
	
	
	@Test
	public void controllerAddTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/add")).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}
	
	@Test
	public void controllersubtractTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/subtract")).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}
	
	@Test
	public void controllerMultiplyTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/multiply")).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}
	
	@Test
	public void controllerDivideTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/divide")).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}
}
  

