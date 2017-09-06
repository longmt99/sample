package com.saas.service.intf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.saas.model.student.Student;

@Service
public interface StudentService {
	long createStudent(Student student);
	Student getStudent(long id);
	Student getStudentByEmail(String email);
	int updateStudent(Student student);
	List<Student> searchStudent(Map map);
	int deleteStudent(long id);
}
