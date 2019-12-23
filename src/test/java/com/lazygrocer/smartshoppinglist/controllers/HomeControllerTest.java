package com.lazygrocer.smartshoppinglist.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.lazygrocer.smartshoppinglist.controllers.HomeController;
import com.lazygrocer.smartshoppinglist.models.Meal;
import com.lazygrocer.smartshoppinglist.repositories.MealRepository;

public class HomeControllerTest {

	@InjectMocks
	HomeController underTest;
	@Mock
	MealRepository mealRepo;
	@Mock
	private Meal meal;
	@Mock
	private Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddListOfMealsToModel() {
		when(mealRepo.findAll()).thenReturn(Collections.singletonList(meal));
		underTest.serveHomePage(model);
		verify(model).addAttribute("meals", Collections.singletonList(meal));

	}

	@Test
	public void serveHomePageShouldReturnViewName() throws Exception {
		assertEquals("home", underTest.serveHomePage(model));

	}

}
