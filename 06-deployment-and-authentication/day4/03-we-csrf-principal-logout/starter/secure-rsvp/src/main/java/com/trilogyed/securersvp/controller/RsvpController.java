package com.trilogyed.securersvp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RsvpController {
    @RequestMapping(value="/publicEvent", method = RequestMethod.GET)
    public String viewPublicEvents() {
        return "Here are the public events.";
    }

    @RequestMapping(value="/registerPublicEvent", method= RequestMethod.GET)
    public String registerPublicEvent() {
        return "You are registering for a public event.";
    }

    @RequestMapping(value="/privateEvent", method = RequestMethod.GET)
    public String viewPrivateEvents(Principal principal) {
        System.out.println(principal);
        return "Here are the private events, exclusively for you: " + principal.getName();
    }

    @RequestMapping(value="/registerPrivateEvent", method= RequestMethod.GET)
    public String registerPrivateEvent(Principal principal) {
        return "You are registering for a private event: " + principal.getName();
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String doEndOfSession() {
        return "You're logged out";
    }
}
