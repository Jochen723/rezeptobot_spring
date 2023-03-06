package de.webapplication.rezeptobot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.repositories.RezeptRepository;

@Service
public class RezeptService {

	@Autowired
	private RezeptRepository rezeptRepository;

	public Iterable<Rezept> getAll() {
		return rezeptRepository.findAll();
	}

	public Optional<Rezept> getById(Long id) {
		return rezeptRepository.findById(id);
	}

	public Rezept save(Rezept rezept) {
		return rezeptRepository.save(rezept);
	}

	public void delete(Rezept rezept) {
		rezeptRepository.delete(rezept);
	}
}
