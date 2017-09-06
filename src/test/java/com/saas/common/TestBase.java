package com.saas.common;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.saas.model.student.Student;
import com.saas.service.intf.StudentService;

/**
 * @longmt99
 */

public class TestBase extends Dummy{
	
	protected static long ID = 0;

	protected Student D00 =null;
	
	
	@Autowired
	protected StudentService studentService = null;

	@Value("${spring.profiles.active}")
	String env;
	
	@Before
	public void setUp() throws Exception {
		log.info("set Up test env ["+ env +"] ");
		D00 = (Student) parserDummy(new Student());
		setSchemaByKey(TDKEY);
	}
	
}
