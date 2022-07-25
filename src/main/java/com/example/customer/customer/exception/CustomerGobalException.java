package com.example.customer.customer.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerGobalException extends ResponseEntityExceptionHandler{

	public void springHandleNotFound(HttpServletResponse res) throws IOException{
		res.sendError(HttpStatus.NOT_FOUND.value());
	}
}
