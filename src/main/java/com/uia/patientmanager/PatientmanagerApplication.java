package com.uia.patientmanager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uia.patientmanager.dao.PatientRepository;
import com.uia.patientmanager.entities.Patient;

@SpringBootApplication
public class PatientmanagerApplication implements CommandLineRunner {
	
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		patientRepository.save(new Patient(null, "Murad", new Date(), false));
		patientRepository.save(new Patient(null, "Laila", new Date(), true));
		patientRepository.save(new Patient(null, "Ahmed", new Date(), true));
		patientRepository.save(new Patient(null, "Samira", new Date(), false));
		patientRepository.save(new Patient(null, "Tarik", new Date(), true));
		
		patientRepository.save(new Patient(null, "Aisha", new Date(), false));
		patientRepository.save(new Patient(null, "Souad", new Date(), true));
		patientRepository.save(new Patient(null, "Rachid", new Date(), true));
		patientRepository.save(new Patient(null, "Karim", new Date(), false));
		patientRepository.save(new Patient(null, "Chaima", new Date(), true));
		
		patientRepository.save(new Patient(null, "Badr", new Date(), false));
		patientRepository.save(new Patient(null, "Karima", new Date(), true));
		patientRepository.save(new Patient(null, "Safaa", new Date(), true));
		patientRepository.save(new Patient(null, "Salim", new Date(), false));
		patientRepository.save(new Patient(null, "Asmae", new Date(), true));
		
	}

}
