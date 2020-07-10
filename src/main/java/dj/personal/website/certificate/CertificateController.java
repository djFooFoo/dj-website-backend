package dj.personal.website.certificate;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Comparator;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dj.personal.website.Role;

@RestController()
class CertificateController {
	private final CertificateRepository certificateRepository;

	@Autowired
	public CertificateController(CertificateRepository certificateRepository) {
		this.certificateRepository = certificateRepository;
	}

	@GetMapping("api/certificates")
	@RolesAllowed(Role.ADMIN)
	public Collection<CertificateDTO> findAll() {
		return certificateRepository.findAll()
				.stream()
				.map(Certificate::toDTO)
				.sorted(Comparator.comparing(CertificateDTO::getIssueDate).reversed().thenComparing(CertificateDTO::getName))
				.collect(toList());
	}
}

