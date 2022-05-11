package com.company.reccoll.service;

import com.company.reccoll.repository.*;
import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.LabelView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    LabelRepository labelRepository;
    TrackRepository trackRepository;

    @Before
    public void setUp() throws Exception {
        setUpAlbumRepositoryMock();
        setUpArtistRepositoryMock();
        setUpLabelRepositoryMock();
        setUpTrackRepositoryMock();

        service = new ServiceLayer(albumRepository, artistRepository, labelRepository, trackRepository);

    }

    @Test
    public void shouldReturnAListOfAlbumViewModelsWhenFindingAllAlbums() {
        List<AlbumViewModel> actualResult = service.findAllAlbums();

//        assertEquals(actualResult);
    }

    @Test void shouldFindArtistById() {
        Artist expectedArtist = new Artist();
        expectedArtist.setId(45);
        expectedArtist.setInstagram("@Rachel");
        expectedArtist.setName("The Rach!");
        expectedArtist.setTwitter("@dontAtMe");

        Artist actualResult = service.findArtist(45);

        assertEquals(expectedArtist, actualResult);
    }


    @Test
    public void shouldReturnNullWhenFindArtistWithIdThatDoesNotExist() {
        Artist expectedArtist = null;

        Artist actualResult = service.findArtist(10000);

        assertEquals(expectedArtist, actualResult);
    }


    // Helper methods
    private void setUpAlbumRepositoryMock() {
        albumRepository = mock(AlbumRepository.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumRepository).save(album2);
        doReturn(Optional.of(album)).when(albumRepository).findById(1);
        doReturn(aList).when(albumRepository).findAll();
    }

    private void setUpArtistRepositoryMock() {
        artistRepository = mock(ArtistRepository.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@Rachel");
        artist.setName("The Rach!");
        artist.setTwitter("@dontAtMe");

        Artist artist2 = new Artist();
        artist2.setInstagram("@Rachel");
        artist2.setName("The Rach!");
        artist2.setTwitter("@dontAtMe");

        List<Artist> artistList = new ArrayList<>();
        artistList.add(artist);
        artistList.add(artist2);

        doReturn(artist).when(artistRepository).save(artist2);
        doReturn(Optional.of(artist)).when(artistRepository).findById(45);
        doReturn(artistList).when(artistRepository).findAll();
    }

    private void setUpLabelRepositoryMock() {
        this.labelRepository = mock(LabelRepository.class);
        Label label = new Label();
        label.setId(10);
        label.setName("ABC");
        label.setWebsite("www.whatever.com");

        Label label2 = new Label();
        label2.setName("ABC");
        label2.setWebsite("www.whatever.com");

        List<Label> labelList = new ArrayList<>();
        labelList.add(label);
        labelList.add(label2);

        doReturn(label).when(labelRepository).save(label );
        doReturn(Optional.of(label)).when(labelRepository).findById(10);
        doReturn(labelList).when(labelRepository).findAll();

    }

    private void setUpTrackRepositoryMock() {
        this.trackRepository = mock(TrackRepository.class);
        Track track = new Track();
        track.setId(999);
        track.setAlbumId(1);
        track.setRunTime(240);
        track.setTitle("Never Gonna");

        Track track2 = new Track();
        track2.setAlbumId(1);
        track2.setRunTime(240);
        track2.setTitle("Never Gonna");

        List<Track> tList = new ArrayList<>();  // OR you can do List<Track> tList = Arrays.asList(track)
        tList.add(track);
        tList.add(track2);

        doReturn(track).when(trackRepository).save(track2);
        doReturn(Optional.of(track)).when(trackRepository).findById(999);
        doReturn(tList).when(trackRepository).findAll();
        doReturn(tList).when(trackRepository).findAllTracksByAlbumId(1);

    }


}
