package com.company.reccoll.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ServiceLayer {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;
    private TrackRepository trackRepository;

    @Autowired
    public ServiceLayer(AlbumRepository albumRepository, ArtistRepository artistRepository, LabelRepository labelRepository, TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
        this.trackRepository = trackRepository;
    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {
        // Save the album info
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());

        a = albumRepository.save(a);
        viewModel.setId(a.getId());

        // Associate each track with the album (albumId foreign key on track)
        // Add each track to the database
        Set<Track> trackSet = viewModel.getTracks();

        trackSet.stream()
                .forEach(song ->
                {
                    song.setAlbumId(viewModel.getId());
                    trackRepository.save(song);
                });

        trackSet = new HashSet<Track>(trackRepository.findAllTracksByAlbumId(viewModel.getId()));
        viewModel.setTracks(trackSet);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id) {
        Optional<Album> album = albumRepository.findById(id);

        // return album.isPresent() ? buildAlbumViewModel(album.get()) : null;
        if (album.isPresent()) {
            return buildAlbumViewModel(album.get());
        } else {
            return null;
        }
    }

    public List<AlbumViewModel> findAllAlbums() {
        List<Album> albumList = albumRepository.findAll();

        List<AlbumViewModel> avmList = new ArrayList<>();

        for (Album album: albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }

        return avmList;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel viewModel) {
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());
        a.setId(viewModel.getId());

        albumRepository.save(a);

        // Delete all of the old tracks associated with this album, because
        // we have a potentially updated/corrected set on the new view model
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(a.getId());

        trackList.stream()
                .forEach(t -> trackRepository.deleteById(t.getId()));

        // then add all the tracks on this view model into the database
        Set<Track> avmTrackSet = viewModel.getTracks();
        avmTrackSet.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    trackRepository.save(t);
                });

    }

    @Transactional
    public void removeAlbum(int id) {
        // delete the individual tracks of the album before we delete the album
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(id);

        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        // remove album
        albumRepository.deleteById(id);
    }


    private AlbumViewModel buildAlbumViewModel(Album album) {
        // get the artist
        Optional<Artist> artist = artistRepository.findById(album.getArtistId());

        if (artist.isPresent() == false) {
            throw new DataIntegrityViolationException("Label contains non-existent artistId foreign key " + album);
        }
        // get the label
        Optional<Label> label = labelRepository.findById(album.getLabelId());
        if (label.isPresent() == false) {
            throw new DataIntegrityViolationException("Label contains non-existent labelId foreign key " + album);
        }

        // get the tracks (as a set)
        Set<Track> tracks = new HashSet<>(trackRepository.findAllTracksByAlbumId(album.getId()));
        if (tracks.size() == 0) {
            throw new RuntimeException("Album with id " + album.getId() + " contains no tracks." + album);
        }

        // put all of the objects and properties on the view model
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist.get());
        avm.setLabel(label.get());
        avm.setTracks(tracks);

        // return
        return avm;
    }
}









