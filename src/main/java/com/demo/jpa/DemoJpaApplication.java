package com.demo.jpa;

import com.demo.jpa.dao.jpaDao.IUserDao;
import com.demo.jpa.dao.jpaDao.JPARepositoryPackage;
import com.demo.jpa.models.jpa.Users;
import com.demo.jpa.models.mongo.Account;
import com.demo.jpa.dao.mongoDao.IAccountDao;
import com.demo.jpa.dao.mongoDao.MongoRepositoryPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=JPARepositoryPackage.class)
@EnableMongoRepositories(basePackageClasses=MongoRepositoryPackage.class)
public class DemoJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(IUserDao userRepository, IAccountDao accountRepository) {
		return (args) -> {
			// save a couple of customers
			userRepository.save(new Users("Jack", "Bauer", "bauer@gmail.com"));
			userRepository.save(new Users("Chloe", "O'Brian", "obrian@gmail.com"));
			userRepository.save(new Users("Kim", "Bauer"));
			userRepository.save(new Users("David", "Palmer"));
			userRepository.save(new Users("Michelle", "Dessler"));

			// fetch all customers
			log.info("JPA repo demo.");
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (Users users : userRepository.findAll()) {
				log.info(users.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Users users = userRepository.findOne(1L);
			log.info("Users found with findOne(1L):");
			log.info("--------------------------------");
			log.info(users.toString());
			log.info("");

			// fetch customers by last name
			log.info("Account found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Users bauer : userRepository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("JPA repo demo end");

			log.info("Mongo repo demo.");
			accountRepository.deleteAll();

			// save a couple of customers
			accountRepository.save(new Account("admin"));
			accountRepository.save(new Account("super_user"));

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Account account : accountRepository.findAll()) {
				System.out.println(account);
			}
			System.out.println();

			// fetch an individual customer
			System.out.println("Account found with findByName('admin'):");
			System.out.println("--------------------------------");
			System.out.println(accountRepository.findByName("admin"));

			System.out.println("Customers found with findByName('super_user'):");
			System.out.println("--------------------------------");
			System.out.println(accountRepository.findByName("super_user"));

			log.info("Mongo repo demo end");

		};
	}
}
