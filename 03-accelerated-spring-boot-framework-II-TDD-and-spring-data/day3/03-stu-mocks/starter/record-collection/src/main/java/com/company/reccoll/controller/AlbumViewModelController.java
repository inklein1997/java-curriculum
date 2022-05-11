package com.company.reccoll.controller;

import com.company.reccoll.model.Album;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;
import com.company.reccoll.service.ServiceLayer;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumViewModelController {

//    AlbumRepository albumRepository;
//    ArtistRepository artistRepository;
//    LabelRepository labelRepository;
//    TrackRepository trackRepository;

    @Autowired
    public ServiceLayer serviceLayer;

    @GetMapping("/albums")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumViewModel> getAllAlbums() {
        return serviceLayer.findAllAlbums();
    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumViewModel createAlbum(@RequestBody AlbumViewModel input) {
//        AlbumViewModel albumViewModel = new AlbumViewModel();
//
//        albumViewModel.setListPrice(input.getListPrice());
//        albumViewModel.setLabel(input.getLabel());
//        albumViewModel.setArtist(input.getArtist());
//        albumViewModel.setTitle(input.getTitle());
//        albumViewModel.setReleaseDate(input.getReleaseDate());

        return serviceLayer.saveAlbum(input);
    }

    @PutMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@PathVariable int id, @RequestBody AlbumViewModel input) {
        if (id != input.getId()) {
            throw new DataIntegrityViolationException("You dont have matching ids");
        }
        serviceLayer.updateAlbum(input);
    }

    @DeleteMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) {
        serviceLayer.removeAlbum(id);
    }

}
