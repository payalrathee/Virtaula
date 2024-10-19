package com.virtaula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
