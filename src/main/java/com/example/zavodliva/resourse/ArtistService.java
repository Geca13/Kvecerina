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
	
	

	public void createNewArtist(Artist newArtist, MultipartFile multiPartFile) throws IOException {
		Artist artist = new Artist();
		artist.setFullName(newArtist.getFullName());
		uploadImageAndSetPath(multiPartFile, artist);
		artistRepository.save(artist);
	}

	private void uploadImageAndSetPath(MultipartFile multiPartFile, Artist artist) throws IOException {
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		artist.setImageUrl("/img/" + fileName);
		imageService.uploadImage(multiPartFile);
	}

	public void updateImage(Integer id, MultipartFile multiPartFile) throws IOException {
		Artist artist = findArtistById(id);
		uploadImageAndSetPath(multiPartFile, artist);
		artistRepository.save(artist);
		
	}
	
	public List<Artist> artists(String search){
		if(search != null) {
		List<Artist> filtered = artistRepository.findBySearch(search);
		return filtered;
		}
		return artistRepository.findByOrderByFullNameAsc();
	}
	
	public List<Artist> artists(){
		return artistRepository.findByOrderByFullNameAsc();
	}

	public void updateArtistName(Integer id, String fullName) {
		Artist artist = findArtistById(id);
		artist.setFullName(fullName);
		artistRepository.save(artist);
	}

	private Artist findArtistById(Integer id) {
		Artist artist = artistRepository.findById(id).get();
		return artist;
	}

	public void addArtistToSong(Integer sid, Integer aid) {
		Song song = songService.findSongById(sid);
		song.getArtists().add(findArtistById(aid));
		songService.updateSong(song);
	}
	
	public void removeArtistFromSong(Integer sid, Integer aid) {
		Song song = songService.findSongById(sid);
		Artist artist = findArtistById(aid);
		song.getArtists().remove(artist);
		songService.updateSong(song);
	}
	

}
