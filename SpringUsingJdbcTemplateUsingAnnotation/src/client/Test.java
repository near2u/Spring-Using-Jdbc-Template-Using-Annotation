package client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.dao.StudentDaoImpl;
import com.project.model.Student;
import com.project.service.StudentService;
import com.project.service.StudentServiceImpl;

public class Test {

	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/beans.xml");
		
		StudentService studentService = context.getBean("studentService", StudentServiceImpl.class);
		
		//createStudent(studentService);
		
		//updateStudent(studentService);
		
		//findById(studentService);
		
		findAll(studentService);
		
		/*Student student = new  Student();
		student.setId(62);
		studentService.deleteStudent(student);*/
		
		
	}

	private static void findAll(StudentService studentService) {
		List<Student> list = studentService.findAll();
		
		for (Student student : list) {
			System.out.println("Stundent Id: "+student.getId()+"\t student Name: "+student.getStudName()+"\t Email: "+student.getEmail()+"\t Address: "+student.getAddress());
			
		}
	}

	private static void findById(StudentService studentService) {
		Student student =  studentService.findByID(61);
		System.out.println("Stundent Id: "+student.getId()+"\t student Name: "+student.getStudName()+"\t Email: "+student.getEmail()+"\t Address: "+student.getAddress());
	}

	private static void updateStudent(StudentService studentService) {
		Student student = new  Student();
		student.setId(61);
		student.setStudName("Vishal");
		student.setEmail("vishalkawade17@gmail.com");
		student.setAddress("Pune");
		
		studentService.updateStudent(student);
	}

	private static void createStudent(StudentService studentService) {
		Student student = new  Student();
		student.setId(61);
		student.setStudName("Pravin");
		student.setEmail("pk@gmail.com");
		student.setAddress("Bhose");
		
		studentService.save(student);
	}

}
