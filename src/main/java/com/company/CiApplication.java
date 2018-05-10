package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.company.model.Department;
import com.company.model.User;
import com.company.repository.DepartmentRepository;
import com.company.repository.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class CiApplication {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CiApplication.class, args);
	}

	@Bean
	ApplicationRunner init(DepartmentRepository departmentRepository, UserRepository userRepository) {
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

			User u1 = new User();
			u1.setEmail("admin@admin.com");
			u1.setUsername("admin");
			u1.setPassword(passwordEncoder.encode("admin"));
			u1.setDepartment(departmentRepository.findById(1l));
			userRepository.save(u1);
		};
	}
}
