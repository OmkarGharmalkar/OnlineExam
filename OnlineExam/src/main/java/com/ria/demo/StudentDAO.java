package com.ria.demo;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class StudentDAO {
Configuration cfg;
SessionFactory sessionFactory;
Session session;
Transaction tx;
public StudentDAO()
{
	cfg=new Configuration();
	sessionFactory=cfg.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Marks.class).addAnnotatedClass(Exam.class).addAnnotatedClass(Questions.class).buildSessionFactory();
}
public Student insertStudent(Student student)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	/*
	 * Criteria c=session.createCriteria(Student.class);
	 * c.add(Restrictions.gt("marks", 50.0)); String s1= c.list().toString();
	 */
	
	/*
	 * Marks m1=new Marks(rollno, 1, 90, "pass"); session.save(m1);
	 * 
	 * List<Marks> marks=new ArrayList<>(); marks.add(m1);
	 */
	
	session.save(student);
	System.out.println(student);
	
	tx.commit();
	session.close();
	sessionFactory.close();
	
	return student;
}

public void insertExam(String question, String option1, String option2, String option3, String option4, String correctAns)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	/*
	 * Criteria c=session.createCriteria(Student.class);
	 * c.add(Restrictions.gt("marks", 50.0)); String s1= c.list().toString();
	 */
	
	
	
	Questions q1=new Questions(1, question, option1, option2, option3, option4, correctAns, 1);
	List<Questions> questions=new ArrayList<>();
	questions.add(q1);
	session.save(q1);
	Exam exam=new Exam(2, "MCQ", 50, 28, questions);
	session.save(exam);

	
	tx.commit();
	session.close();
	sessionFactory.close();
	
	
}

public List<Student> displayall()
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	/*
	 * Criteria c=session.createCriteria(Student.class);
	 * c.add(Restrictions.gt("marks", 50.0)); String s1= c.list().toString();
	 */
	


	 List<Student> list=   session.createCriteria(Student.class).list();
	
	tx.commit();
	session.close();
	sessionFactory.close();
	return list;
}


public Student display(String username,String password)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	/*
	 * Criteria c=session.createCriteria(Student.class);
	 * c.add(Restrictions.gt("marks", 50.0)); String s1= c.list().toString();
	 */
	Criteria criteria = session.createCriteria(Student.class);
	Criterion userCriterion=Restrictions.eq("username", username);
	Criterion passwordCriterion=Restrictions.eq("password", password);
	
	criteria.add(Restrictions.and(userCriterion,passwordCriterion));
    
	Student student=(Student)criteria.uniqueResult();
	Hibernate.initialize(student.getMarks());
	System.err.println(student);
	tx.commit();
	session.close();
	sessionFactory.close();
	return student;
}

public List<Marks> displayMarks(String username, String password)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	
	Criteria criteria=session.createCriteria(Student.class);
	Criterion userCriterion=Restrictions.eq("username", username);
	Criterion passwordCriterion=Restrictions.eq("password", password);
	
	criteria.add(Restrictions.and(userCriterion,passwordCriterion));
	Student student=(Student)criteria.uniqueResult();
	
	
	Criteria criteria2=session.createCriteria(Marks.class);
	criteria2.add(Restrictions.eq("rollno", student.getrollno()));
	List<Marks> list=criteria2.list();
	
	// List<Marks> list=   session.createCriteria(Marks.class).list();
	
	
	tx.commit();
	session.close();
	sessionFactory.close();
	return list;
}

public void enableStudent(Integer rollno)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	
	Student student=(Student)session.get(Student.class, rollno);
	student.setStatus(true);
	session.saveOrUpdate(student);
	
	tx.commit();
	session.close();
	sessionFactory.close();
}

public void enableAllStudents()
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	
	Criteria criteria=session.createCriteria(Student.class);
	criteria.add(Restrictions.eq("status", false));
	ScrollableResults items = criteria.scroll();
    int count=0;
	while (items.next()) 
	{
		Student e = (Student) items.get(0);
		e.setStatus(true);
		session.saveOrUpdate(e);
		if (++count % 100 == 0)
		{
			session.flush();
			session.clear();
		}

	}
	tx.commit();
	session.close();
	sessionFactory.close();
}

public boolean checkIfenabled(Integer rollno)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	
	Criteria criteria = session.createCriteria(Student.class);
    criteria.add(Restrictions.eq("rollno", rollno));
Student student=(Student)criteria.uniqueResult();
boolean status=student.isStatus();
	
	
	tx.commit();
	session.close();
	sessionFactory.close();
	return status;
}

public boolean authenticateStudent(String username,String password)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	
	Criteria criteria = session.createCriteria(Student.class);
    criteria.add(Restrictions.eq("username", username));
Student student=(Student)criteria.uniqueResult();
boolean status=false;
Hibernate.initialize(student.getMarks());
if(student.getUsername().equals(username)&&student.getPassword().equals(password))
{
	status=true;
	System.out.println(student);
}
	
	tx.commit();
	session.close();
	sessionFactory.close();
	return status;
}

public List<String> startExam()
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	Criteria criteria=session.createCriteria(Questions.class);
	
	
	

	
	  // create a projection list
	  ProjectionList projectionList = Projections.projectionList();
	  // create a projection for fetching "name" property value
	  Projection questionProjection = Projections.property("question");
	  // add it to list
	  projectionList.add(questionProjection);
	  // create a projection for fetching "employeeId" property value
	  Projection option1Projection = Projections.property("option1");
	  // add it to list
	  projectionList.add(option1Projection);
	  Projection option2Projection = Projections.property("option2");
	  // add it to list
	  projectionList.add(option2Projection);
	  Projection option3Projection = Projections.property("option3");
	  // add it to list
	  projectionList.add(option3Projection);
	  Projection option4Projection = Projections.property("option4");
	  // add it to list
	  projectionList.add(option4Projection);
	  // associate projection list to criteria
	  criteria.setProjection(projectionList);
	  // get all employee records
	  List<Object []> list = criteria.list();
	  // iterate over records
	  List<String> str=new ArrayList<>();
	  for (Object[] question : list) {
		    str.add("Question: " + question[0]+"  " +
		                    "  Option1: " + question[1]+"  "+"  Option2: " + question[2]+"  "+"  Option3: " + question[3]+"  "+"  Option4: " + question[4]+"  ");
		 
		  }
	
	
	
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return str;
	
	
		
	
	
}
public void submitExam(Integer rollno,Answers a)
{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	List<String> answers=a.getAnswers();
	System.err.println("size of answers list : "+answers.size());
	Criteria criteria = session.createCriteria(Questions.class);
	// create a projection to fetch only name column
	Projection p = Projections.property("correctAns");
	// add projection to criteria
	criteria.setProjection(p); 
	// get all employee names
	List<String> list = criteria.list();
	// iterate over records
	int count=0;
	for (int i=0;i<list.size();i++) {
	  if(answers.get(i+1).equalsIgnoreCase(list.get(i)))
	  {
		  count++;
		
	  }
	}
	

	Criteria criteria2=session.createCriteria(Marks.class);
	criteria2.add(Restrictions.eq("rollno", rollno));
	Marks StudentMarks=(Marks)criteria2.uniqueResult();
	StudentMarks.setMarks(count);
	session.saveOrUpdate(StudentMarks);
	System.err.println(answers);
	
	tx.commit();
	session.close();
	sessionFactory.close();
}




}

