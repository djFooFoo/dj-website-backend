package dj.personal.website.translation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface TranslatedValueRepository extends JpaRepository<TranslatedValue, Long> {
	List<TranslatedValue> findByLanguageKeyLanguage(String language);
}
