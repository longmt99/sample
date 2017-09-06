package com.saas.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.saas.common.Rest;
import com.saas.common.TestBase;
import com.saas.config.lambda.LambdaContext;
import com.saas.controller.StudentController;
import com.saas.model.StudentResponse;

@RunWith(SpringRunner.class)
@Import(LambdaContext.class)
public class StudentLambdaTest extends TestBase {

	@Test
	public void testCRUDCases() throws Exception {
		ResponseEntity<Rest> rest = null;
		StudentController controller = LambdaContext.getBean(StudentController.class);
		long id = 0;
		try {

			rest = controller.createStudent(D00, TDKEY);

			StudentResponse response = (StudentResponse) rest.getBody().getData();
			
			id = response.getId();
			
			Assert.assertEquals(HttpStatus.OK.value(), rest.getBody().getStatus());
			
			// Search Student
			String email = D00.getEmail();
			String name = D00.getFirstName();
			String phone = D00.getPhone();
			rest = controller.getStudent(String.valueOf(id),email,name, phone,TDKEY);
			Assert.assertEquals(HttpStatus.OK.value(), rest.getBody().getStatus());
			
			Assert.assertEquals(HttpStatus.OK.value(), rest.getBody().getStatus());

			StudentResponse getted = (StudentResponse) rest.getBody().getData();
			Assert.assertEquals(getted.getId(), id);

			// Update Student
			rest = controller.updateStudent(id, D00, TDKEY);
			Assert.assertEquals(HttpStatus.OK.value(), rest.getBody().getStatus());

			// Patch Student
			D00.setId(id);
			rest = controller.patchStudent(D00, TDKEY);
			Assert.assertEquals(HttpStatus.OK.value(), rest.getBody().getStatus());

			// Delete Student
			rest = controller.deleteStudent(id, TDKEY);
			Assert.assertEquals(HttpStatus.OK.value(), rest.getBody().getStatus());
		} finally {
			// Delete Student
			controller.deleteStudent(id, TDKEY);
		}
	}

}
