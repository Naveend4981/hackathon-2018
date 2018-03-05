package com.hpe.event_optimizer.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.event_optimizer.data.Event;
import com.hpe.event_optimizer.service.EventService;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages = { "com.hpe.event_optimizer.controller" })
public class ApplicatonController {

    @Autowired
    private EventService service;

    @GetMapping("test")
    public String test() {
        // service.getEvents();
        return "events...";
    }

    @GetMapping("events")
    public Set<String> getEvent() {
        return service.getEvents();
    }

    // @PostMapping("events")
    @RequestMapping(value = "events", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public String insertEvent(@RequestBody String eventString) throws UnsupportedEncodingException {
        String decoded = URLDecoder.decode(eventString, "UTF-8").trim();
        System.out.println(" Event Received : " + decoded);
        if (decoded != null && decoded.length() > 0) {
            String message = decoded.split(":")[3];
            // System.out.println(" Event Received : " + decoded);
            String[] strArr2 = decoded.split(" ");
            Event event = new Event(strArr2[0].split("T")[0], strArr2[0].split("T")[1], strArr2[1], strArr2[2],
                    message);
            service.insertEvent(event);
        } else {
            return "null data";
        }
        return "inserted";
    }
}
