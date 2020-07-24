package dj.personal.website.certificate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Order(1)
@Component
@Slf4j
public class CertificateRunner implements CommandLineRunner {

	private final CertificateRepository certificateRepository;

	@Autowired
	public CertificateRunner(CertificateRepository certificateRepository) {
		this.certificateRepository = certificateRepository;
	}

	@Override
	public void run(String... args) {
		Collection<Certificate> certificates = createCertificates();

		int size = certificates.size();
		log.info(size + " certificates have been saved to the database.");
	}

	private Collection<Certificate> createCertificates() {
		createAndSaveCertificate("Oracle Certified Professional: Java SE 11 Programmer", LocalDate.of(2019, Month.DECEMBER, 1), "Oracle", CertificateType.CERTIFICATE,
				"https://www.youracclaim.com/badges/6479b37c-a8aa-4412-adc4-f7ada40176a6/public_url");
		createAndSaveCertificate("Oracle Certified Associate, Java SE 8 Programmer", LocalDate.of(2019, Month.SEPTEMBER, 1), "Oracle", CertificateType.CERTIFICATE,
				"https://www.youracclaim.com/badges/3ec8731f-0c1a-4075-bdf0-b6c8d5f0cbe3/public_url");
		createAndSaveCertificate("Professional Scrum Developer I", LocalDate.of(2017, Month.APRIL, 1), "Scrum.org", CertificateType.CERTIFICATE,
				"https://www.scrum.org/user/243806");
		createAndSaveCertificate("EXIN Agile Scrum Foundation", LocalDate.of(2019, Month.SEPTEMBER, 1), "Exin", CertificateType.CERTIFICATE,
				"https://exeed.pro/badge/43740");
		createAndSaveCertificate("deep.learning.specialization", LocalDate.of(2019, Month.MAY, 1), "Coursera", CertificateType.COURSE,
				"https://www.coursera.org/account/accomplishments/specialization/SXJNRZSW2FNQ");
		createAndSaveCertificate("ai.for.everyone", LocalDate.of(2019, Month.MARCH, 1), "Coursera", CertificateType.COURSE,
				"https://www.coursera.org/account/accomplishments/verify/FL5WAVUSXLXE");
		createAndSaveCertificate("angular.challenge", LocalDate.of(2019, Month.MAY, 1), "NG-BE, Google, Innovatus, Showpad, EDITx", CertificateType.AWARD,
				"https://photos.google.com/share/AF1QipMGr_Fnj3VeEW0UJ7GJ_71Imb5zBI6m8JhO99nQPDmf_5mOqX9EtOi4rlBuEtU18Q?key=QXplbTItTExCZGhrd0FCNGMzc3Jwd05EVTJRYVlB");
		createAndSaveCertificate("pytorch.deep.learning", LocalDate.of(2020, Month.MAY, 1), "Udemy", CertificateType.COURSE,
				"https://www.udemy.com/certificate/UC-ae1c4739-0ce8-4153-bc4d-9492d58aed8c/");

		return certificateRepository.findAll();
	}

	private void createAndSaveCertificate(String name, LocalDate issueDate, String organization, CertificateType certificateType, String credentialUrl) {
		Certificate certificate = Certificate.builder()
				.name(name)
				.issueDate(issueDate)
				.organization(organization)
				.credentialUrl(credentialUrl)
				.certificateType(certificateType)
				.build();

		certificateRepository.save(certificate);
	}
}
