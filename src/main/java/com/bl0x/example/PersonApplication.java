package com.bl0x.example;

import com.bl0x.example.entities.Person;
import com.bl0x.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(MongoProperties.class)
@EnableScheduling
public class PersonApplication implements ApplicationRunner{


	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}


	@Override
	public void run(final ApplicationArguments args) throws Exception {
		Person p = new Person();
		p.setName("Loki-Afro");
		repository.insert(p);

		Person person = repository.findAll().get(0);

		System.out.println(person.getName() + " is a great Person!");

		repository.deleteAll();
	}
}