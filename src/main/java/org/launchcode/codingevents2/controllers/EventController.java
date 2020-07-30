package org.launchcode.codingevents2.controllers;

import org.launchcode.codingevents2.data.EventData;
import org.launchcode.codingevents2.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
//import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    //private static List<Event> events = new ArrayList<>();
     //private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());

        /*List<String> events = new ArrayList<>();*events.add("Code With Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");
        events.add("SpringOne Platform");
        model.addAttribute("events", events);*/
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    //lives at /events/create (can have same path as above because they handle the same kinds of requests)
    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent){
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam (required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
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
