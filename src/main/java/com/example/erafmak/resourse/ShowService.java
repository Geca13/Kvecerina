package com.example.erafmak.resourse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.erafmak.entity.Show;
import com.example.erafmak.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	AudioFileService audioService;

	public List<Show> findAllShows() {
		List<Show> shows = showRepository.findAll();
    return shows;
	}

	public Show findById(Integer id) {
		Show show = showRepository.findById(id).get();
		return show;
	}

	public Show addNewShow(Show show, MultipartFile multiPartFile) throws IOException {
		Show newShow = new Show();
		newShow.setName(show.getName());
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		newShow.setFilename(fileName);
		newShow.setUrl("/audios/" + fileName);
		newShow.setImageUrl("/img/galeb.jpg");
		newShow.setSongs(new ArrayList<>());
		audioService.uploadAudio(multiPartFile);
		return showRepository.save(newShow);
	}
	
	public Show updateShow(Show show) {
		return showRepository.save(show);
		
	}
	
	
	
	
	
	

}
