package com.finalsem.cms;

import com.finalsem.cms.entities.Assignment;
import com.finalsem.cms.entities.Course;
import com.finalsem.cms.entities.Schedule;
import com.finalsem.cms.entities.StudyMaterial;
import com.finalsem.cms.repositories.StudentRepo;
import com.finalsem.cms.users.Instructor;
import com.finalsem.cms.users.Student;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.finalsem.cms.repositories.CourseRepo;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(CmsApplication.class, args);

		//CourseRepo courseRepo = ctx.getBean(CourseRepo.class);
		//Course course = new Course("Advance course in java", 2.5, 10, "Java", null, 5000, null, null, null, null);
		//courseRepo.save(course);
		//System.out.println(courseRepo.findAll());


		//StudentRepo stRepo=ctx.getBean(StudentRepo.class);
		//System.out.println(stRepo);
		//List<Course> courses = new ArrayList<>();
		//courses.add(course);
		//stRepo.save(new Student("abc",9847733,"abc@gmail.com","abc","India", courses,null));
		//System.out.println(stRepo.findById(1).get());

	}

}
