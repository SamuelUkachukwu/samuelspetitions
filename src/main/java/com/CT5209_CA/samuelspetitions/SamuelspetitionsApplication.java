package com.CT5209_CA.samuelspetitions;

import com.CT5209_CA.samuelspetitions.domain.entity.Petition;
import com.CT5209_CA.samuelspetitions.domain.entity.Signature;
import com.CT5209_CA.samuelspetitions.domain.repository.PetitionRepository;
import com.CT5209_CA.samuelspetitions.domain.repository.SignatureRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SamuelspetitionsApplication implements CommandLineRunner {

	private final PetitionRepository petitionRepository;
	private final SignatureRepository signatureRepository;

	private static final Logger logger = LoggerFactory.getLogger(SamuelspetitionsApplication.class);

	public SamuelspetitionsApplication(PetitionRepository petitionRepository, SignatureRepository signatureRepository) {
		this.petitionRepository = petitionRepository;
		this.signatureRepository = signatureRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SamuelspetitionsApplication.class, args);
		logger.info("Application started");
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// --- Preload Petitions (using full constructor)
		Petition p1 = petitionRepository.save(new Petition(
				"Save the Ballinasloe Library",
				"Keep the local library open for students and residents.",
				"Emeka",
				"Okafor",
				"The library is vital for education and community events."
		));

		Petition p2 = petitionRepository.save(new Petition(
				"Clean Up The Lagoon",
				"Requesting government action to clean Lady's Island Lake.",
				"Ngozi",
				"Chukwu",
				"The lagoon pollution is affecting fishing and local health."
		));

		Petition p3 = petitionRepository.save(new Petition(
				"Ban Plastic Bags",
				"Encourage stores to stop giving out plastic bags.",
				"Sean",
				"Connor",
				"Plastic bags harm the environment and wildlife."
		));

		Petition p4 = petitionRepository.save(new Petition(
				"More Street Lighting",
				"Increase street lighting in rural areas.",
				"Aisling",
				"Murphy",
				"Better lighting improves safety and reduces crime at night."
		));

		Petition p5 = petitionRepository.save(new Petition(
				"Plant More Trees",
				"Call for more urban greenery in cities.",
				"Chinedu",
				"Eze",
				"Trees improve air quality and reduce heat in urban areas."
		));

		Petition p6 = petitionRepository.save(new Petition(
				"Upgrade Public Transport",
				"Need more buses and trains in Dublin.",
				"Patrick",
				"Kelly",
				"Frequent and reliable public transport is needed for commuters."
		));

		// Signatures
		signatureRepository.save(new Signature("Tunde", "Balogun", "tunde.balogun@example.com", p1));
		signatureRepository.save(new Signature("Oluchi", "Nwankwo", "oluchi.nwankwo@example.com", p1));
		signatureRepository.save(new Signature("Fiona", "Doyle", "fiona.doyle@example.com", p2));
		signatureRepository.save(new Signature("Liam", "Murphy", "liam.murphy@example.com", p2));
		signatureRepository.save(new Signature("Ngozi", "Uche", "ngozi.uch@example.com", p3));
		signatureRepository.save(new Signature("Sean", "Rourke", "sean.rourke@example.com", p3));
		signatureRepository.save(new Signature("Chinelo", "Okeke", "chinelo.okeke@example.com", p4));
		signatureRepository.save(new Signature("Aisling", "Brennan", "aisling.brennan@example.com", p4));
		signatureRepository.save(new Signature("Emeka", "Nnamdi", "emeka.nnamdi@example.com", p5));
		signatureRepository.save(new Signature("Patrick", "OBrien", "patrick.obrien@example.com", p5));
		signatureRepository.save(new Signature("Grace", "Oluwaseun", "grace.oluwaseun@example.com", p6));
		signatureRepository.save(new Signature("Ronan", "Flaherty", "ronan.flaherty@example.com", p6));

		logger.info("Application Started");
	}
}