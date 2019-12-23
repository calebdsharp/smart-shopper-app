package com.lazygrocer.smartshoppinglist.controllers;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lazygrocer.smartshoppinglist.models.Ingredient;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.models.MealIngredient;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

public class MealApiControllerTest {
	//Takes an entity and turns into JSON
	private ObjectMapper mapper = new ObjectMapper();
	
	private Meal testMeal;
	private String testMealJson;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private MealApiController underTest;
	@Mock
	private MealRepository mealRepo;

	@Before
	public void setup() throws JsonProcessingException {
		MockitoAnnotations.initMocks(this);
		testMeal = new Meal("TestName", 1, new MealIngredient(new Ingredient("TestIngredient"), 1));
		testMealJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testMeal);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		System.out.println(testMealJson);
	}

	@Test
	public void shouldPostToApi() throws Exception {
		mockMvc.perform(post("/api/meals/add-meal")
				   .contentType(MediaType.APPLICATION_JSON_UTF8)
				   .content(testMealJson))
			   .andExpect(status().isOk());
		verify(mealRepo).save(testMeal);
	}
	@Test
	public void	shouldEditMealWIthAPutRequest() throws Exception {
		mockMvc.perform(put("/api/meals/edit-meal/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(testMealJson))
			   .andDo(print())
			   .andExpect(status().isOk());
		verify(mealRepo).save(testMeal);
	}
//	 @Test
//	    public void shouldAddArtist() throws Exception {
//	        mockMvc.perform(post(".api/artists/add")
//	                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//	                        .content(
//	                "{" +
//	                        "\"name\": \"Jane\"" +
//	                        "}"))
//	               .andDo(print())
//	               .andExpect(status().isOk());
//	    }

}
