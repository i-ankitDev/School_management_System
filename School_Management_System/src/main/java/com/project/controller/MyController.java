package com.project.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.ProjectDao;
import com.project.dto.CourseDetails;
import com.project.dto.Student;

@Controller
public class MyController {
	@Autowired
	private ProjectDao dao;

	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(@RequestParam String username, String password) {
		if (username != null && username.equals("admin") && password.equals(password)) {
			ModelAndView modelAndView = new ModelAndView("dashboard.jsp");
			modelAndView.addObject("student", dao.findAll());
			return findAll();
		}
		ModelAndView modelAndView = new ModelAndView("AdminLogin.jsp");
		return modelAndView;
	}

	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("dashboard.jsp");
		modelAndView.addObject("list", dao.findAll());
		return modelAndView;
	}

	@RequestMapping("/StudentSignup")
	public ModelAndView studentSignUp() {
		ModelAndView modelAndView = new ModelAndView("StudentSignup.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping("/studentsignup")
	public ModelAndView signUp(@ModelAttribute Student student, @RequestParam String db) {
		student.setDob(Date.valueOf(db));
		student.setStatus("Inactive");
		student.setCourses(new ArrayList<>());
		dao.saveStudentObject(student);
		return new ModelAndView("studentLogin.jsp");
	}

	@RequestMapping("/studentLogin")
	public ModelAndView name(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
		Student student = dao.findStudentByEmail(email);
		if (student != null && student.getEmail().equals(email) && student.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			ModelAndView modelAndView = new ModelAndView("CourseDetails.jsp");
			modelAndView.addObject("course", new CourseDetails());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("studentLogin.jsp");
		return modelAndView;
	}

	@RequestMapping("/addCourse")
	public String addCourse(@ModelAttribute CourseDetails course, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
		System.out.println(student.getId());
		if (student.getCourses() == null) {
			student.setCourses(new ArrayList<>());
		}
		student.getCourses().add(course);
		course.setStudent(student);
		dao.addCourse(student, course);
		return "LastPage.jsp";

	}

	@RequestMapping("/changeStatus")
	public ModelAndView changeStatus(@RequestParam int id) {
		Student student = dao.findStudentById(id);
		if (student.getStatus() == "Inactive") {
			student.setStatus("Active");
		} else {
			student.setStatus("Inactive");
		}
		dao.updateStudent(student);
		return findAll();
	}

}
