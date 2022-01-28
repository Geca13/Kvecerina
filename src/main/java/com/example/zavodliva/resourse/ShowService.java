package com.example.zavodliva.resourse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.zavodliva.entity.Show;
import com.example.zavodliva.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	AudioFileService audioService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	ImageService imageService;
	

	public List<Show> findAllShows() {
		List<Show> shows = showRepository.findAllByOrderByPublishedDesc();
    return shows;
	}

	public Show findById(Integer id) {
		Show show = showRepository.findById(id).get();
		return show;
	}

	public Show addNewShow(Show show, MultipartFile multiPartFile) throws IOException {
		
		    Show newShow = new Show();
		    newShow.setTitle(show.getTitle());
			String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
			newShow.setAudioUrl("/audios/" + fileName);
			newShow.setImageUrl("/img/galeb.jpg");
			newShow.setPublished(LocalDate.now());
			newShow.setSongs(new ArrayList<>());
			audioService.uploadAudio(multiPartFile);
			return showRepository.save(newShow);
		
	}
	
	public Show updateShow(Show show) {
		return showRepository.save(show);
	}

	public Show lastShow() {
		Show show =showRepository.findTopByOrderByPublishedDesc();
		return show;
	}

	public void deleteShow(Integer id) {
		Show show = findById(id);
		songService.deleteListOfSongs(show.getId());
		imageService.deleteImage(show);
		audioService.deleteAudio(show);
		showRepository.delete(show);
	}

	
}
