package org.launchcode.codingevents2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    public static HashMap<String,String> eventHashMap = new HashMap<String,String>();


    @GetMapping
    public String displayAllEvents(Model model) {
        eventHashMap.put("StrangeLoop","Coding conference");
        eventHashMap.put("Code With Pride","Coding but with extra pride");
        eventHashMap.put("WWDC","What would Developers Code?");
        model.addAttribute("events",eventHashMap);
        //model.addAttribute("title", "All Events");
        //model.addAttribute("events", events);
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





    /*@GetMapping
    public String displayAllEvents(Model model) {
        List<String> events = new ArrayList<>();
        events.add("Code With Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");
        events.add("SpringOne Platform");
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }*/
}
