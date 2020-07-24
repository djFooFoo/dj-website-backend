package dj.personal.website.certificate;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(columnDefinition = "DATE")
	private LocalDate issueDate;

	private String organization;

	private String credentialUrl;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "smallint")
	private CertificateType certificateType;

	CertificateDTO toDTO() {
		return CertificateDTO.builder()
				.name(name)
				.issueDate(issueDate)
				.organization(organization)
				.credentialUrl(credentialUrl)
				.certificateType(certificateType)
				.build();
	}
}
