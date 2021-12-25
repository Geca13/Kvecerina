package com.example.erafmak.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.entity.Artist;
import com.example.erafmak.entity.Song;
import com.example.erafmak.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	SongService songService;

	public void createNewArtist(Artist artist, Integer sid) {
		Song song = songService.findSongById(sid);
		Artist newArtist = new Artist();
		newArtist.setFullName(artist.getFullName());
		newArtist.setImageUrl("/img/artist.jpg");
		artistRepository.save(newArtist);
		song.getArtists().add(newArtist);
		songService.updateSong(song);
	}
	
	

}
