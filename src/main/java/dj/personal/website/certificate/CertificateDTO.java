package dj.personal.website.certificate;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class CertificateDTO {
	private final String name;
	private final LocalDate issueDate;
	private final String organization;
	private final String credentialUrl;
	private final CertificateType certificateType;
}
