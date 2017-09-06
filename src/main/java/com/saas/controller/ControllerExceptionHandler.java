package com.saas.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saas.common.Rest;
import com.saas.exception.ExistedEmailException;
import com.saas.exception.ExistedPhoneException;
import com.saas.exception.InvalidDomainNameException;
import com.saas.exception.InvalidTenantKeyException;
import com.saas.exception.NotFoundException;
import com.saas.exception.UserNotConfirmed;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	Rest handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.UNPROCESSABLE_ENTITY,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	Rest handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.UNPROCESSABLE_ENTITY,"Not Readable Exception request - Json Format");
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidTenantKeyException.class)
	@ResponseBody
	Rest handleUnAuthorized(InvalidTenantKeyException e,HttpServletResponse response) throws IOException {
		Rest error=new Rest(HttpStatus.UNAUTHORIZED,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidDomainNameException.class)
	@ResponseBody
	Rest handleI(InvalidTenantKeyException e,HttpServletResponse response) throws IOException {
		Rest error=new Rest(HttpStatus.NOT_FOUND,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}

	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	Rest handleUnAuthorized(NotFoundException e,HttpServletResponse response) throws IOException {
		Rest error=new Rest(HttpStatus.NOT_FOUND,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}

	@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
	@ExceptionHandler(UserNotConfirmed.class)
	@ResponseBody
	Rest userNotConfirmed(UserNotConfirmed e,HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.BAD_REQUEST,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}

	@ResponseStatus(HttpStatus.IM_USED)
	@ExceptionHandler(ExistedPhoneException.class)
	@ResponseBody
	Rest duplicateUserException(ExistedPhoneException e,HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.IM_USED,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}
	

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ExistedEmailException.class)
	@ResponseBody
	Rest duplicateDataException(ExistedEmailException e,HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.CONFLICT,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	Rest handleUnknown(Exception e,HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	Rest handleUnknownRuntime(RuntimeException e,HttpServletResponse response) throws IOException {
		e.printStackTrace();
		Rest error=new Rest(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(new ObjectMapper().writeValueAsString(error).length()));
		return error;
	}
}
