package org.amstel.Kates.controllers;

import static org.hamcrest.Matchers.containsString;

import static 
	org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static
	org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static
	org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static
	org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.amstel.Kates.web.LandingController;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(LandingController.class)
public class LandingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void landingTest() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("root")) // TODO Optional conditioning between "root", "home" and "landing".
		.andExpect(content().string(containsString("Hello World ..."))); // NOTE Use of "Hello World" in HTML document for testing.
	}
}
