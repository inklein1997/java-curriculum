package com.cinder.controller;

import com.cinder.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DatingController {

    private static int personId = 1;

    private static List<Person> people = new ArrayList<>(Arrays.asList(
            new Person(personId++, "Sam", 25, "I am Sam."),
            new Person(personId++, "Sue", 27, "I like Reiki and beach yoga. I love my cat and all " +
                    "energies on all ephemeral planes."),
            new Person(personId++, "Tony", 24, "I fix cars, weld, and do jazzercise."),
            new Person(personId++, "Simone", 33, "I am a jazz singer and travel extensively to " +
                    "perform. Looking for someone who can keep up with my schedule."),
            new Person(personId++, "Tara", 25, "I am super energetic. Always hiking, biking, skating, " +
                    "running, and on adventures. Come join me!"),
            new Person(personId++, "Selena", 25, "I am from Ecuador and am new to town. I would love a " +
                    "friend to explore the city with.")
    ));

    @RequestMapping(value="/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person) {
        
        person.setId(personId++);
        people.add(person);
        return person;
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPeople() {

        return people;
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable int id) {

        Person found = null;

        for(Person person : people) {
            if(person.getId() == id) {
                found = person;
                break;
            }
        }

        return found;
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePersonById(@PathVariable int id, @RequestBody Person person) {

        int personIndex = -1;

        for(int i = 0; i < people.size(); i++) {
            if(people.get(i).getId() == id) {
                personIndex = i;

                // This prevents a multitude of erroneous situations in the event that the id in the request body is
                // null or invalid. This also protects us from assigning duplicate ids. We will have better ways to
                // handle these situations later in the course via input validation, database constraints, and
                // controller advice.
                person.setId(id);

                break;
            }
        }

        if (personIndex >= 0) {
            person.setId(id);
            people.set(personIndex, person);
        }
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable int id) {

        int personIndex = -1;

        for(int i = 0; i < people.size(); i++) {
            if(people.get(i).getId() == id) {
                personIndex = i;
                break;
            }
        }

        if (personIndex >= 0) {
            people.remove(personIndex);
        }
    }
}
