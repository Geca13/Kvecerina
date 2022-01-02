package com.example.zavodliva.resourse;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.zavodliva.entity.Artist;
import com.example.zavodliva.entity.Song;
import com.example.zavodliva.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	SongService songService;
	
	@Autowired
	ImageService imageService;

	public void createNewArtist(Artist artist, Integer sid) {
		Song song = songService.findSongById(sid);
		Artist newArtist = new Artist();
		newArtist.setFullName(artist.getFullName());
		newArtist.setImageUrl("/img/artist.jpg");
		artistRepository.save(newArtist);
		song.getArtists().add(newArtist);
		songService.updateSong(song);
	}

	public void updateImage(Integer aid, MultipartFile multiPartFile) throws IOException {
		Artist artist = artistRepository.findById(aid).get();
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		artist.setImageUrl("/img/" + fileName);
		imageService.uploadImage(multiPartFile);
		artistRepository.save(artist);
		
	}
	
	public List<Artist> artists(){
		return artistRepository.findByOrderByFullNameAsc();
	}
	
	

}