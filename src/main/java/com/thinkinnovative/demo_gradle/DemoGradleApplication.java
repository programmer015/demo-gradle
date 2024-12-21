package com.thinkinnovative.demo_gradle;

import com.thinkinnovative.demo_gradle.entity.StoreInformation;
import com.thinkinnovative.demo_gradle.repository.StoreInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.thinkinnovative.demo_gradle.repository")
public class DemoGradleApplication  {

	@Autowired
	StoreInformationRepository storeInformationRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoGradleApplication.class, args);
		System.out.println("I have started my first project");
	}

//	@Override
//	public void run(String... args) {
//		StoreInformation s1 = new StoreInformation("Mahesh", "AN5114", 1, 5);
//		StoreInformation s2 = new StoreInformation("Ramesh", "RM5114", 1, 6);
//		StoreInformation s3 = new StoreInformation("Suresh", "SR5114", 1, 1);
//		StoreInformation s4 = new StoreInformation("Nitesh", "NH5114", 1, 1);
//		StoreInformation s5 = new StoreInformation("Mitesh", "MH5114", 1, 10);
//		storeInformationRepository.save(s1);
//		storeInformationRepository.save(s2);
//		storeInformationRepository.save(s3);
//		storeInformationRepository.save(s4);
//		storeInformationRepository.save(s5);
//
//		storeInformationRepository.findByName("Mahesh").forEach(
//				v1 -> System.out.println(v1)
//				);
//		storeInformationRepository.findByBalance(6).forEach(
//				v2 -> System.out.println(v2)
//		);
//
//	}


}
