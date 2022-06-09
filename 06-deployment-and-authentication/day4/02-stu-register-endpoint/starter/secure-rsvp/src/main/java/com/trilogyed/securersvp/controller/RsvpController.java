package com.trilogyed.securersvp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RsvpController {
    @RequestMapping(value="/publicEvent", method = RequestMethod.GET)
    public String viewPublicEvents() {
        return "Here are the public events.";
    }

    @RequestMapping(value="/privateEvent", method = RequestMethod.GET)
    public String viewPrivateEvents() {
        return "Here are the private events.";
    }

    @RequestMapping(value = "/registerPublicEvent", method = RequestMethod.GET)
    public String registerPublicEvent() { return "You are registering for a public event"; }

    @RequestMapping(value = "/registerPrivateEvent", method = RequestMethod.GET)
    public String registerPrivateEvent() { return "You are registering for a private event"; }
}
