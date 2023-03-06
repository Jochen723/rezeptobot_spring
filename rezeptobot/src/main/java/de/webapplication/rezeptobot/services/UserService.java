package de.webapplication.rezeptobot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.webapplication.rezeptobot.models.User;
import de.webapplication.rezeptobot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}
}
