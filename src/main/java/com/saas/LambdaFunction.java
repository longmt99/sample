package com.saas;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saas.common.Rest;
import com.saas.config.lambda.APIRequest;
import com.saas.config.lambda.LambdaContext;
import com.saas.controller.StudentController;
import com.saas.model.student.Student;

/**
 * @longmt99
 */
public class LambdaFunction implements RequestHandler<APIRequest, Object> {

	private static final Logger log = LoggerFactory.getLogger(LambdaFunction.class);
	public static final Region REGION = Region.getRegion(Regions.US_EAST_1);


	@Value("${spring.datasource.url}")
	String datasource;

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Rest handleRequest(APIRequest apiRequest, Context context) {
		log.info("Starting LambdaContext : " + new Date());
		String operation = apiRequest.getOperation();
		HttpMethod method = apiRequest.getHttpMethod();
		log.debug("RUN handleRequest getOperation: " + operation + "method: "+ method);
		log.debug("RUN handleRequest getBody: " +  apiRequest.getBody());
		try {
			String json = mapper.writeValueAsString(apiRequest);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new Rest(HttpStatus.BAD_REQUEST,e.getMessage());
		}

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			log.info("operation: "+operation);
			StudentController app = LambdaContext.getBean(StudentController.class);
			String tenantKey = apiRequest.getHeaders().get("tenantKey");
			if (method.equals(HttpMethod.POST)) {
				Student request = objectMapper.convertValue(apiRequest.getBody(), Student.class);
				return app.createStudent(request,tenantKey).getBody();
			}else if (method.equals(HttpMethod.PUT)) {
				String id = apiRequest.getQueryParams().get("id");
				Student request = objectMapper.convertValue(apiRequest.getBody(), Student.class);
				return app.updateStudent(Long.parseLong(id), request, tenantKey).getBody();
			}else if (method.equals(HttpMethod.GET)) {
				String id = apiRequest.getQueryParams().get("id");
				String email = apiRequest.getQueryParams().get("email");
				String name = apiRequest.getQueryParams().get("name");
				String phone = apiRequest.getQueryParams().get("phone");
				tenantKey = apiRequest.getQueryParams().get("tenantKey");// GET method
				return app.getStudent(id,email,name,phone,tenantKey).getBody();
			}else if (method.equals(HttpMethod.PATCH)) {
				log.debug(method.toString());
				Student request = objectMapper.convertValue(apiRequest.getBody(), Student.class);
				return app.patchStudent(request, tenantKey).getBody();
			}else if (method.equals(HttpMethod.DELETE)) {
				String id = apiRequest.getQueryParams().get("id");
				return app.deleteStudent(Long.parseLong(id), tenantKey).getBody();
			}
			return new Rest(HttpStatus.METHOD_NOT_ALLOWED);

		} catch (Exception e) {
			e.printStackTrace();
			context.getLogger().log("error.\n");
			return new Rest(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
	}
}
