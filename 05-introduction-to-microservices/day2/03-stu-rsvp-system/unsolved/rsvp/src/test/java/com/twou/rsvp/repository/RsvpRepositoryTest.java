package com.twou.rsvp.repository;

import com.twou.rsvp.model.Rsvp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RsvpRepositoryTest {

    @Autowired
    public RsvpRepository repository;

    @Test
    public void addGetDeleteRsvp() {
        Rsvp rsvp = new Rsvp("John Doe", 2);
        rsvp = repository.save(rsvp);
        Optional<Rsvp> fromDao = repository.findById(rsvp.getId());
        assertEquals(fromDao.get(), rsvp);
        repository.deleteById(rsvp.getId());
        fromDao = repository.findById(rsvp.getId());
        assertFalse(fromDao.isPresent());
    }

    @Test
    public void getAllRsvps() {
        Rsvp rsvp = new Rsvp("Sally Smith", 4);
        repository.save(rsvp);

        rsvp = new Rsvp("George Smith", 3);
        repository.save(rsvp);

        List<Rsvp> rsvps = repository.findAll();

        assertEquals(2, rsvps.size());
    }

    @Test
    public void updateRsvp() {
        Rsvp rsvp = new Rsvp("Joe Jones", 5);
        rsvp = repository.save(rsvp);
        rsvp.setGuestName("NEW NAME");
        repository.save(rsvp);
        Optional<Rsvp> fromDao = repository.findById(rsvp.getId());
        assertEquals(rsvp, fromDao.get());
    }
}