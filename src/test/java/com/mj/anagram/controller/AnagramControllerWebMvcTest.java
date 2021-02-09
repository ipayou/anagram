package com.mj.anagram.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mj.anagram.application.MjAnagramApplication;
import com.mj.anagram.service.AnagramService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnagramController.class)
@ContextConfiguration(classes={MjAnagramApplication.class})
public class AnagramControllerWebMvcTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

    @MockBean
    private AnagramService anagramService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
//		this.mockMvc.perform( get("/anagram/{\"abc\",\"bca\",\"cab\"}") ).andDo( print() )
//		.andExpect( status().isOk() )
//        .andExpect(content().string( containsString("Hello World")) );
	}

}
