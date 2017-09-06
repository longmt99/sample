package com.saas.controller;


import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saas.common.Rest;
import com.saas.exception.InvalidTenantKeyException;
import com.saas.model.user.Tenant;
import com.saas.service.intf.CommonService;

/**
 * Common function verify Token, load Session Token
 * Format request, response REST API 
 * Switch schema by tenant
 *
 */
public class BaseController {
	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
	protected String langCode = null;
	protected String callback = null;
	
	protected HttpStatus status;
	protected Tenant ssTenant;
	@Autowired
	protected  CommonService commonService;
	
	public BaseController() {
	}
	protected ResponseEntity<Rest> responseEntity(Rest rest) {
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.set(HttpHeaders.CONTENT_LENGTH,String.valueOf(new ObjectMapper().writeValueAsString(rest).length()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Rest>(rest,headers, HttpStatus.valueOf(rest.getStatus()));
	}
	protected ResponseEntity<Rest> responseEntity(HttpStatus httpStatus) {
		Rest rest = new Rest(httpStatus);
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.set(HttpHeaders.CONTENT_LENGTH,String.valueOf(new ObjectMapper().writeValueAsString(rest).length()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Rest>(rest,headers, httpStatus);
	}
	protected ResponseEntity<Rest> responseEntity(HttpStatus httpStatus, String message) {
		Rest rest = new Rest(httpStatus, message);
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.set(HttpHeaders.CONTENT_LENGTH,String.valueOf(new ObjectMapper().writeValueAsString(rest).length()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Rest>(rest,headers, httpStatus);
	}
	/**
	 * Verify the tenant & also set the schema
	 * @param tenantKey
	 * @param setSchema 
	 * @throws SQLException 
	 */
	protected void verifyKey(String tenantKey, boolean setSchema) throws InvalidTenantKeyException {
		ssTenant = commonService.getTenantByKey(tenantKey);
		if (ssTenant == null) {
			throw new InvalidTenantKeyException("Tenant Key [" + tenantKey + "] invalid ");
		}
		if (setSchema) {
			String schema = ssTenant.getSchema();
			try {
				commonService.setConnectionSchema(schema);
			} catch (SQLException e) {
				throw new InvalidTenantKeyException("Set Schema [" + schema + "] error ");
			}
		}

	}
	protected void verifyKey(String tenantKey) throws InvalidTenantKeyException {
		verifyKey(tenantKey,true);
	}
	protected void validateDomain(String domainName) {
		ssTenant = commonService.getTenantByDomain(domainName);
		if (ssTenant == null) {
			throw new InvalidTenantKeyException("Tenant Domain [" + domainName + "] invalid ");
		}
	}
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	/**
	 * Validate the request OBject Json 
	 * @param t
	 */
	public static <T> void validateRequest(T t) {
		
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
		if (constraintViolations.size() > 0) {
			// Validation failed, build error set and throw invalid input error
			Set<String> errors = constraintViolations.stream()
					.map(c -> c.getMessage()).collect(Collectors.toSet());
			String error = "";
			for (String e : errors) {
				error = error + e + ".";
			}
			;
			throw new IllegalArgumentException(error);
		}
	}
}
