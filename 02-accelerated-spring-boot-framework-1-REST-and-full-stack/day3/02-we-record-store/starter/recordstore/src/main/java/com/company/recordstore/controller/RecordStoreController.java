package com.company.recordstore.controller;


import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RecordStoreController {

    private static int idCounter = 1;

    private static List<Record> recordList = new ArrayList<>(Arrays.asList(
            new Record("The Beach Boys", "Pet Sounds", "2022", idCounter++),
            new Record("Billy Joel", "The Stranger", "2022", idCounter++),
            new Record("The Beatles", "Revolver", "2022", idCounter++),
            new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", "2022", idCounter++),
            new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", "2022", idCounter++)
    ));

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Record createRecord(@Valid @RequestBody Record record) {

        record.setId(idCounter++);
        recordList.add(record);

        return record;
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Record> getAllRecords() {

        return recordList;
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Record getRecordById(@PathVariable int id) {
        Record foundRecord = null;

        for(Record record : recordList) {
            if(record.getId() == id) {
                foundRecord = record;
                break;
            }
        }

        return foundRecord;
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateRecordById(@PathVariable int id, @Valid @RequestBody Record record) {

        if (record.getId() == 0) {
            record.setId(id);
        }

        if (record.getId() != id) {
            throw new IllegalArgumentException("Id in paramter must match the Id in the request body");
        }

        int index = -1;

        for(int i = 0; i < recordList.size(); i++) {
            if(recordList.get(i).getId() == id) {
                index = i;

                record.setId(id);

                break;
            }
        }

        if (index >= 0) {
            recordList.set(index, record);
        }
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRecordById(@PathVariable int id) {
        int index = -1;

        for(int i = 0; i < recordList.size(); i++) {
            if(recordList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            recordList.remove(index);
        }
    }
}
