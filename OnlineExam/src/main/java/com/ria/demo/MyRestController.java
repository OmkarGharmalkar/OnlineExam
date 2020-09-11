package com.ria.demo;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyRestController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String helloWeb()
	{
		return "Hello Web";
	}
	
	
	@GetMapping(value = "/studentLogin")
	public void studentlog(HttpServletRequest request, @RequestParam("password") String password,
			@RequestParam("username") String username) {

		StudentDAO st = new StudentDAO();
		

		if (!username.equals("admin")) {

			if (st.authenticateStudent(username, password)) {
				HttpSession session = request.getSession();
				System.out.println("Login: "+session.hashCode());
				session.setAttribute("username", username);
			}

		}

	}
    
    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        System.out.println("Logout: "+session.hashCode());
        session.invalidate();
    }
    
	
	/*
	 * @GetMapping(value = "/studentProfileTrial") public String
	 * displayProfileTrial(HttpServletRequest request) { HttpSession session =
	 * request.getSession(false);
	 * 
	 * if (session != null) { String username = (String)
	 * session.getAttribute("username");
	 * 
	 * StudentDAO dao = new StudentDAO(); Student s = dao.display(username);
	 * System.out.println("trial"+session.hashCode()); return
	 * "Profile for Student number :" + s.toString(); } else return
	 * "Please login first!!"; }
	 */
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student)
	{
		StudentDAO dao=new StudentDAO();
		
		 return dao.insertStudent(student);
	}
	
	@PostMapping("/addExam")
	public void addExam(@RequestParam("question") String question,@RequestParam("option1") String option1,
			@RequestParam("option2") String option2,@RequestParam("option3") String option3,@RequestParam("option4") String option4,@RequestParam("correctAns") String correctAns)
	{
		StudentDAO dao=new StudentDAO();
		
		dao.insertExam(question, option1, option2, option3, option4, correctAns);
	}
	
	
	
	/*
	 * @GetMapping("/displayStudent/{rollno}") public Student
	 * displayStudent(@PathVariable("rollno") Integer rollno) { StudentDAO dao=new
	 * StudentDAO(); return dao.display(rollno);
	 * 
	 * }
	 */

	@GetMapping("/displayAllStudents")
	public List<Student> displayAllStudents()
	{
		StudentDAO dao=new StudentDAO();
		return dao.displayall();
		
	}
	
	@GetMapping("/displayStudent")
	public Student displayStudent(@RequestParam String username,@RequestParam String password)
	{
		StudentDAO dao=new StudentDAO();
		return dao.display(username,password);
		
	}
	
	@PutMapping("/enableStudent/{rollno}")
	public void enableStudent(@PathVariable("rollno") Integer rollno)
	{
		StudentDAO dao=new StudentDAO();
		dao.enableStudent(rollno);
		
	}
	
	@PutMapping("/enableAllStudents")
	public void enableAllStudents()
	{
		StudentDAO dao=new StudentDAO();
		dao.enableAllStudents();
	}
	
	@GetMapping("/displayMarks")
	public List<Marks> displayMarks(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		StudentDAO dao=new StudentDAO();
		 return dao.displayMarks( username, password);
	}
	
	@GetMapping("/startExam")
	public List<String> startExam()
	{
		StudentDAO dao=new StudentDAO();
		
	return dao.startExam();
		
		
		
	}
	@PostMapping("/submitExam")
	public Answers submitExam(@RequestParam("rollno") String rollno,@RequestBody Answers answers)
	{
		StudentDAO dao=new StudentDAO();
		System.err.println("In Submit Exam");
		dao.submitExam(Integer.parseInt(rollno), answers);
		return answers;
	}
	


}
