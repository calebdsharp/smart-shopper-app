package com.lazygrocer.smartshoppinglist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason="Bad Request! Meal not found!!")
public class MealNotFoundException extends RuntimeException {

}
