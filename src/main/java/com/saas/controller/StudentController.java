package com.saas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.common.Path;
import com.saas.common.Rest;
import com.saas.common.JConstants.Status;
import com.saas.model.Paging;
import com.saas.model.StudentResponse;
import com.saas.model.student.Student;
import com.saas.service.intf.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StudentController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(StudentController.class.getName());

	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "Register new student")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successful retrieval of student created", response = Rest.class),
			@ApiResponse(code = 404, response = String.class, message = "Invalid data"),
			@ApiResponse(code = 500, response = String.class, message = "Internal server error") })
	@PostMapping(value = Path.STUDENTS, headers = {"content-type=application/json" }, produces = "application/json")
	public ResponseEntity<Rest> createStudent(@ApiParam(value = "Object json student") @RequestBody Student student,
			@RequestHeader(name = "Authorization", required = true) String tenantKey){
		log.info("Create Student:" + student);
		super.verifyKey(tenantKey);
		Student existed = studentService.getStudentByEmail(student.getEmail());
		if (existed != null) {
			Rest rest = new Rest(HttpStatus.CREATED, "Student already existed " + existed.getEmail());
			rest.setData(new StudentResponse(existed));
			return responseEntity(rest);
		}
		student.setStatus(Status.ACTIVE.name());
		long id = studentService.createStudent(student);
		student.setId(id);
		log.info("Created student with id = " + student.getId() + " and status = " + student.getStatus());
		Rest rest = new Rest(HttpStatus.OK);
		rest.setData(new StudentResponse(student));
		return responseEntity(rest);
	}

	@ApiOperation(value = "Update student")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successful retrieval of student update", response = Rest.class),
			@ApiResponse(code = 404, response = String.class, message = "Invalid data"),
			@ApiResponse(code = 500, response = String.class, message = "Internal server error") })
	@PutMapping(value = Path.STUDENTS, headers = { "content-type=application/json" }, produces = "application/json")
	public ResponseEntity<Rest> updateStudent(
			@ApiParam(value = "ID of student") @RequestParam Long id,
			@ApiParam(value = "Object json student") @RequestBody Student student,
			@RequestHeader(name = "Authorization", required = true) String tenantKey) {
		log.info("Update Student:" + student);
		super.verifyKey(tenantKey);
		Student existed = studentService.getStudent(id);
		if (existed == null) {
			return responseEntity(new Rest(HttpStatus.NOT_FOUND, "Student Id ["+id+"] invalid "));
		}
		student.setId(id);
		studentService.updateStudent(student);
		Rest rest = new Rest(HttpStatus.OK);
		rest.setData(new StudentResponse(student));
		log.info("Update Student with id = " + id + " and status = " + student.getStatus());
		return new ResponseEntity<>(rest, HttpStatus.OK);
	}

	@ApiOperation(value = "Patch student update")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successful retrieval of student update", response = Rest.class),
			@ApiResponse(code = 404, response = String.class, message = "Invalid data"),
			@ApiResponse(code = 500, response = String.class, message = "Internal server error") })
	@PatchMapping(value = Path.STUDENTS, headers = { "content-type=application/json" }, produces = "application/json")
	public ResponseEntity<Rest> patchStudent(
			@ApiParam(value = "Object json student") @RequestBody Student student,
			@RequestHeader(name = "Authorization", required = true) String tenantKey) {
		log.info("Patch Student:" + student);
		super.verifyKey(tenantKey);

		long id = student.getId();
		Student existed = studentService.getStudent(id);
		if (existed == null) {
			return responseEntity(new Rest(HttpStatus.NOT_FOUND, "Student Id ["+id+"] invalid "));
		}

		studentService.updateStudent(student);
		Rest rest = new Rest(HttpStatus.OK);
		rest.setData(new StudentResponse(student));
		log.info("Patch Student with id = " + id + " and status = " + student.getStatus());
		return new ResponseEntity<>(rest, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get student by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Successful retrieval of student", response = StudentResponse.class),
			@ApiResponse(code = 404, response = String.class, message = "Invalid data, not found"),
			@ApiResponse(code = 500, response = String.class, message = "Internal server error") })
	@CrossOrigin(origins = "*")
	@GetMapping(value = Path.STUDENTS, produces = "application/json")
	public ResponseEntity<Rest> getStudent(
			@ApiParam(value = "ID of student") @RequestParam(required = false) String id,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String phone,
			@RequestHeader(name = "Authorization", required = true) String tenantKey) {
		log.info("Get Student: " + tenantKey);
		super.verifyKey(tenantKey);
		Rest rest = new Rest();
		if(StringUtils.isNotEmpty(id)){
			Student student = studentService.getStudent(Long.parseLong(id));
			log.info("Get Student ");
			if(student!=null){
				rest.setStatus(HttpStatus.OK);
				rest.setData(new StudentResponse(student));
			}else{
				rest.setStatus(HttpStatus.NOT_FOUND);
				rest.setMessage("Could not get Student id: "+ id);
			}
		}else{
			Map<String, Object> map = new HashMap<String, Object>();
			Paging paging = new Paging(1, 10);
			map.put(Paging.class.getSimpleName(), paging);
			Student student = new Student();
			student.setFirstName(name);
			student.setEmail(email);
			student.setPhone(phone);
			map.put(Student.class.getSimpleName(), student);
			List<Student> list = studentService.searchStudent(map);
			log.info("search Student ");
			rest.setStatus(HttpStatus.OK);
			rest.setData(list);
		}	
		return responseEntity(rest);
	}

	@ApiOperation(value = "Delete student ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successful deleted", response = Rest.class),
        @ApiResponse(code = 404, response = String.class, message = "Invalid data"),
        @ApiResponse(code = 500, response = String.class, message = "Internal server error")
	})
	@DeleteMapping(value = Path.STUDENTS, produces = "application/json")
	public ResponseEntity<Rest> deleteStudent(
			@ApiParam(value = "ID of student") @RequestParam(required = true) Long id,
			@RequestHeader(name = "Authorization", required = true) String tenantKey ) {
		log.info("List Student:" + id + ","+ tenantKey);
		super.verifyKey(tenantKey);
		Student student = studentService.getStudent(id);
		if(student==null){
			return responseEntity(new Rest(HttpStatus.NOT_FOUND,"Student Id ["+id+"] invalid "));
		}
		studentService.deleteStudent(id);
		log.info("Delete Student " + student);
		return responseEntity(new Rest(HttpStatus.OK, "Delete Student " + student));
	}
}