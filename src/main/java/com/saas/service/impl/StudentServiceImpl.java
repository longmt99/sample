package com.saas.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.saas.mapping.StudentMapper;
import com.saas.model.student.Student;
import com.saas.service.intf.StudentService;

@Service
@Component
public class StudentServiceImpl implements StudentService {
	
	static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentMapper studentMapper;
 
    public StudentServiceImpl(){
    }
    @Override
	public long createStudent(Student student) {
    	return studentMapper.createStudent(student);
	}

	@Override
	public Student getStudent(long id) {
		return studentMapper.getStudent(id);
	}
	
    @Override
    public Student getStudentByEmail(String name) {
    	return studentMapper.getStudentByEmail(name);
    }
    

	@Override
	public int updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}

	@Override
	public List<Student> searchStudent(Map map) {
		return studentMapper.searchStudent(map);
	}

	@Override
	public int deleteStudent(long studentId) {
		return studentMapper.deleteStudent(studentId);
	}
    
}
