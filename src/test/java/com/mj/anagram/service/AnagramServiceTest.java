package com.mj.anagram.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AnagramServiceTest {

	@InjectMocks private AnagramServiceImpl anagramServiceTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testNormaliseAnagram() {
//		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAnagrams() {
//		fail("Not yet implemented"); // TODO
	}

}
