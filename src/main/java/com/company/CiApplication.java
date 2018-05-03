package com.company;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.company.model.Department;
import com.company.repository.DepartmentRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class CiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiApplication.class, args);
	}

	@Bean
	ApplicationRunner init(DepartmentRepository departmentRepository) {
		return args -> {
			Department department1 = new Department();
			department1.setName("Computer engineering");
			department1.setDescription(
					"Department that will handle matters related to information technology and communication.");
			departmentRepository.save(department1);
			Department department2 = new Department();
			department2.setName("Pre sales");
			department2.setDescription(
					"Department responsible for making the first contact with the customer to present commercial proposals.");
			departmentRepository.save(department2);
			Department department3 = new Department();
			department3.setName("Human resources");
			department3.setDescription("Department that will admit new employees and take care of business benefits.");
			departmentRepository.save(department3);
		};
	}
}
