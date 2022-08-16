package com.codingdojo.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.crud.models.Language;
import com.codingdojo.crud.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> getAll() {
		return languageRepository.findAll();
	}

	// create
	public Language create(Language language) {
		return languageRepository.save(language);
	}

	// find by id
	public Language findLanguageById(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (!optionalLanguage.isPresent()) {
			return null;
		} else {
			return optionalLanguage.get();
		}
	}

	// update
	public Language update(Long id, Language language) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			Language foundLanguage = optionalLanguage.get();
			foundLanguage.setName(language.getName());
			foundLanguage.setCreator(language.getCreator());
			foundLanguage.setVersion(language.getVersion());
			languageRepository.save(foundLanguage);
		}
		return null;
	}

	// delete
	public void delete(Long id) {
		languageRepository.deleteById(id);
	}

}