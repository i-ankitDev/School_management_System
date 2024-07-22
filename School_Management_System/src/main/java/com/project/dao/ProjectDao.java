package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dto.CourseDetails;
import com.project.dto.Student;

@Component
public class ProjectDao {
	@Autowired
	private EntityManager manager;

	public List<Student> findAll() {
		return manager.createQuery("from Student s order by id").getResultList();
	}
	public void saveStudentObject(Student student) {
		manager.getTransaction().begin();
		manager.persist(student);
		manager.getTransaction().commit();
	}
	public Student findStudentByEmail(String email) {
		Query query=manager.createQuery("from Student s where email = ?1");
		query.setParameter(1, email);
		List<Student> students = query.getResultList();
		if (students.isEmpty()) {
			return null;
		}
		return students.get(0);
	}
	public void addCourse(Student student, CourseDetails courseDetails) {
		manager.getTransaction().begin();
		manager.persist(student);
		manager.persist(courseDetails);
		manager.getTransaction().commit();
	}

	public Student findStudentById(int id) {
		return manager.find(Student.class, id);
	}
	public void updateStudent(Student student) {
		manager.getTransaction().begin();
		manager.merge(student);
		manager.getTransaction().commit();
	}
}

