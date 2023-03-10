package de.webapplication.rezeptobot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.webapplication.rezeptobot.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    
}
