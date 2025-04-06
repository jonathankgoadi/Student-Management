package com.studentmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.studentmanagement.model.Student;
import com.studentmanagement.util.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudenController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
			
			String action = request.getServletPath();
			
			switch(action) {
			case "/getStudents":
				getAllStudents(request,response);
			case "/getStudent":
				getStudent(request,response);
			}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void getAllStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();		
		Connection connection = (Connection)sc.getAttribute("DBConnection");
		StudentDao studentDao = new StudentDao(connection);
		List<Student> students = studentDao.findAll();
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
		dispatcher.forward(request, response);
		
	}
	private void getStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection)request.getAttribute("DBConnection");
		StudentDao studentDao = new StudentDao(connection);
		Student student = studentDao.findById(serialVersionUID);
		request.setAttribute("students", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
		dispatcher.forward(request, response);
		
	}

}
