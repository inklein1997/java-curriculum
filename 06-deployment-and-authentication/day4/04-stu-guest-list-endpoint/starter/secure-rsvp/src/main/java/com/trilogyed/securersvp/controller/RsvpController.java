package com.trilogyed.securersvp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.file.attribute.UserPrincipalLookupService;
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

    @RequestMapping(value="/privateEvent", method= RequestMethod.GET)
    public String viewPrivateEvents(Principal principal) {
        return "Here are the private events, exclusively for you, " + principal.getName();
    }

    public String registerPrivateEvent(Principal principal) {
        return "You are registering for a private event, " + principal.getName();
    }

    @RequestMapping(value="/allDone", method=RequestMethod.GET)
    public String calledByLogout() {
        return "You are logged out.";
    }

    @RequestMapping(value = "/guestList", method = RequestMethod.GET)
    public String viewGuestList(Principal principal) { return "Hello "+ principal.getName() + " . Because you are an even publisher, you can see this guest list."; }

//    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
//    public String logoutDo(HttpServletRequest request, HttpServletResponse response){
//        HttpSession session= request.getSession(false);
//        SecurityContextHolder.clearContext();
//        session= request.getSession(false);
//        if(session != null) {
//            session.invalidate();
//        }
//        for(Cookie cookie : request.getCookies()) {
//            cookie.setMaxAge(0);
//        }
//
//        return "logout";
//    }
}
