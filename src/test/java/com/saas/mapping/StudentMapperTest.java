package com.saas.mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.saas.common.TestBase;
import com.saas.mapping.StudentMapper;
import com.saas.model.Paging;
import com.saas.model.student.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-${spring.profiles.active}.properties")
public class StudentMapperTest extends TestBase {

	long updated = 0, deleted = 0;

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	CommonMapper commonMapper;

	@Test
	public void testCRUDStudent() {
		// Create
		long id = -1;
		try {
			
			id = studentMapper.createStudent(D00);

			Assert.assertTrue(id > 0);
			D00.setId(id);
			// Read Student by Id
			Student student = studentMapper.getStudent(id);

			Assert.assertNotNull(student);
			Assert.assertEquals(id, student.getId());
			Assert.assertEquals(D00.getEmail(), student.getEmail());

			// Read Student by Name
			student = studentMapper.getStudentByEmail(D00.getEmail());

			Assert.assertNotNull(student);
			Assert.assertEquals(id, student.getId());
			Assert.assertTrue(D00.getFirstName().equals(student.getFirstName()));

			// Update
			String updateName = "Updated";
			D00.setFirstName(updateName);
			updated = studentMapper.updateStudent(D00);

			Assert.assertTrue(updateName.equals(studentMapper.getStudent(id).getFirstName()));
			Assert.assertEquals(1, updated);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			studentMapper.deleteStudent(id);
		}
	}

	@Test
	public void testListStudent() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Student student = new Student();
			Paging paging = new Paging(1, 10);
			map.put(Paging.class.getSimpleName(), paging);
			map.put(Student.class.getSimpleName(), student);

			List<Student> list = studentMapper.searchStudent(map);
			
			log.debug("search ("+list.size()+")");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
