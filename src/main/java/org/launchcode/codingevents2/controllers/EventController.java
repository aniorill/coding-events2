package org.launchcode.codingevents2.controllers;

import org.launchcode.codingevents2.data.EventRepository;
import org.launchcode.codingevents2.models.Event;
import org.launchcode.codingevents2.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//import java.util.ArrayList;
//import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    //private static List<Event> events = new ArrayList<>();
     //private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());

        /*List<String> events = new ArrayList<>();*events.add("Code With Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");
        events.add("SpringOne Platform");
        model.addAttribute("events", events);*/
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    //lives at /events/create (can have same path as above because they handle the same kinds of requests)
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){

        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            //model.addAttribute("errorMsg", "Bad data!");
                    return "events/create";
        }
            eventRepository.save(newEvent);
            return "redirect:";
    }


    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam (required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
            return "redirect:";
    }


   /* @Controller
    @RequestMapping("events")
    public class EventController {

        private static List<String> events = new ArrayList<>();

        @GetMapping
        public String displayAllEvents(Model model) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", events);
            return "events/index";
        }

        @GetMapping("create")
        public String displayCreateEventForm(Model model) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        @PostMapping("create")
        public String processCreateEventForm(@RequestParam String eventName) {
            events.add(eventName);
            return "redirect:";
        }

    }*/



}
