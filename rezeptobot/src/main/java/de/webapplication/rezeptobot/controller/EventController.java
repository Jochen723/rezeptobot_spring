package de.webapplication.rezeptobot.controller;

import de.webapplication.rezeptobot.models.Event;
import de.webapplication.rezeptobot.services.EventService;
import de.webapplication.rezeptobot.services.RezeptService;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

  @Autowired
  private EventService eventService;

  @GetMapping("/rezeptplaner")
  public ModelAndView getRezeptkalender() {
    return new ModelAndView("/rezeptplaner");
  }

  @GetMapping("/getAllEvents")
  public ModelAndView leave() {
    ModelAndView modelAndView = new ModelAndView("/rezeptplaner");
    modelAndView.addObject("events", eventService.getAllEvents());
    return modelAndView;
  }

  @GetMapping("/heuteGekocht/{id}")
  public ModelAndView saveEvent(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("redirect:/rezeptplaner");
    eventService.cookedToday(id);
    return modelAndView;
  }

  @RequestMapping(
    value = "/getJsonEvents",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  public ResponseEntity<String> getPlanificado() {
    List<Event> events = eventService.getAllEvents();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json; charset=utf-8");

    JSONArray array = new JSONArray();

    for (Event event : events) {
      JSONObject resp = new JSONObject();

      resp.put("id", event.getId());
      resp.put("title", event.getTitel());
      resp.put("start", event.getKochdatum());
      resp.put("hintergrundfarbe", event.getHintergrundfarbe());
      array.put(resp);
    }

    return new ResponseEntity<String>(array.toString(), HttpStatus.CREATED);
  }
}
