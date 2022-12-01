package com.finalsem.cms;

import com.finalsem.cms.repositories.StudentRepo;
import com.finalsem.cms.users.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(CmsApplication.class, args);
		StudentRepo stRepo=ctx.getBean(StudentRepo.class);
		System.out.println(stRepo);
		stRepo.save(new Student("abc",9847733,"abc@gmail.com","abc","India",null,null));
		System.out.println(stRepo.findById(1).get());
	}

}
