package com.saas;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.saas.mapping.StudentMapperTest;
import com.saas.service.StudentLambdaTest;


/**
 * All test cases
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	
	// All Mappers
	StudentMapperTest.class,
	// All Service 	
	StudentLambdaTest.class,
	})
public final class STUDENT_TEST_RUNNER {}