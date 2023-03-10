package de.webapplication.rezeptobot.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.webapplication.rezeptobot.models.Event;
import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RezeptService rezeptService;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void cookedToday(Long id) {

        Rezept rezept = rezeptService.getRecipeById(id);

        Event event = new Event();
        event.setKochdatum(new Date());
        event.setTitel(rezept.getTitel());
        eventRepository.save(event);
    }
    
}
