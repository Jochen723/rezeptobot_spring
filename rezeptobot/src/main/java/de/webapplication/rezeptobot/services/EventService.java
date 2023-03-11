package de.webapplication.rezeptobot.services;

import de.webapplication.rezeptobot.models.Event;
import de.webapplication.rezeptobot.models.Rezept;
import de.webapplication.rezeptobot.models.enums.EventHintergrundEnum;
import de.webapplication.rezeptobot.repositories.EventRepository;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private RezeptService rezeptService;

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  public Event saveEvent(Event event) {

    switch (event.getTitel()) {
      case "ess":
        event.setTitel("Essensbestellung");
        event.setHintergrundfarbe(EventHintergrundEnum.ESSENSBESTELLUNG.getHintergrundfarbe());
        break;
        case "aus":
        event.setTitel("Auswärts");
        event.setHintergrundfarbe(EventHintergrundEnum.AUSWAERTS.getHintergrundfarbe());
        break;
        case "son":
        event.setTitel("Alternativ: " + event.getBeschreibungSonstigesGericht());
        event.setHintergrundfarbe(EventHintergrundEnum.AUSWAERTS.getHintergrundfarbe());
        break;
      default:
        event.setHintergrundfarbe(EventHintergrundEnum.ALTERNATIVES_REZEPT.getHintergrundfarbe());
        break;
    }
    
    return eventRepository.save(event);
  }

  public JSONArray getAllEventsAsJsonArray() {
    JSONArray eventJsonArray = new JSONArray();

    for (Event event : getAllEvents()) {
      JSONObject resp = new JSONObject();

      resp.put("id", event.getId());
      resp.put("title", event.getTitel());
      resp.put("start", event.getKochdatum());
      resp.put("hintergrundfarbe", event.getHintergrundfarbe());
      eventJsonArray.put(resp);
    }
    return eventJsonArray;
  }

  public void cookedToday(Long id) {
    Rezept rezept = rezeptService.getRecipeById(id);

    Event event = new Event();
    event.setKochdatum(new Date());
    event.setTitel(rezept.getTitel());
    event.setHintergrundfarbe(EventHintergrundEnum.INTERNES_REZEPT.getHintergrundfarbe());
    eventRepository.save(event);
  }
}
