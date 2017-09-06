package com.saas.mapping;

import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;

import com.saas.model.student.Student;

/**
 * @longmt99
 */
@Mapper
public interface StudentMapper {

	public Student getStudent(long id);
	public Student getStudentByEmail(String name);
	public long createStudent(Student student);
	public int updateStudent(Student student);
	public List<Student> searchStudent(Map map);
	public List<Student> listAll();
	public int deleteStudent(long id);
	public void setSchema(String schemaName);
}
