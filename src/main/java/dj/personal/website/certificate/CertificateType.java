package dj.personal.website.certificate;

import com.fasterxml.jackson.annotation.JsonValue;

enum CertificateType {
	COURSE,
	CERTIFICATE,
	AWARD,
	CONFERENCE;

	@JsonValue
	public String toValue() {
		return this.name().toLowerCase();
	}
}
