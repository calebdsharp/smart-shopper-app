package com.lazygrocer.smartshoppinglist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Meal Name already exists")
public class MealAlreadyFoundException extends RuntimeException {

}
