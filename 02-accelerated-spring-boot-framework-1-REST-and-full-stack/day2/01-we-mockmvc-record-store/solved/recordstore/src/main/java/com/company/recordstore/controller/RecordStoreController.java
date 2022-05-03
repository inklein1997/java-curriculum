package com.company.recordstore.controller;


import com.company.recordstore.models.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordStoreController {

    private static int idCounter = 1;

    private static List<Record> recordList = new ArrayList<>(Arrays.asList(
            new Record("The Beach Boys", "Pet Sounds", idCounter++),
            new Record("Billy Joel", "The Stranger", idCounter++),
            new Record("The Beatles", "Revolver", idCounter++),
            new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", idCounter++),
            new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", idCounter++)
    ));

    // TO DO
}
