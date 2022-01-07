package com.example.zavodliva.resourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zavodliva.entity.Show;
import com.example.zavodliva.entity.Song;
import com.example.zavodliva.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;
	
	@Autowired
	ShowService showService;
	
	public Song findSongById(Integer id) {
		return songRepository.findById(id).get();
	}
	
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}
	
	public void addNewSong(Song song, Integer id) {
		Show show = showService.findById(id);
		Song newSong = new Song();
		newSong.setName(song.getName());
		newSong.setReleaseYear(song.getReleaseYear());
		newSong.setArtists(song.getArtists());
		songRepository.save(newSong);
		show.getSongs().add(newSong);
		showService.updateShow(show);
		
	}

	public void updateSongTitle(String title, Integer id) {
		Song song = findSongById(id);
		song.setName(title);
		updateSong(song);
	}

	public void updateSongYear(String year, Integer id) {
		Song song = findSongById(id);
		song.setReleaseYear(year);
		updateSong(song);
	}

}
