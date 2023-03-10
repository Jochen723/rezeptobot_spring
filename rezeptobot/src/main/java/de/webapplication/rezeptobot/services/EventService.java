package de.webapplication.rezeptobot.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.webapplication.rezeptobot.models.Event;
import de.webapplication.rezeptobot.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
}
