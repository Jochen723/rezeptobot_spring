package de.webapplication.rezeptobot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.webapplication.rezeptobot.models.Rezept;

public interface RezeptRepository extends JpaRepository<Rezept, Long> {

}
