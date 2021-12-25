package com.example.erafmak.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.erafmak.entity.Song;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	ShowService showService;
	
	@PostMapping("/newSong/{id}")
	public String createSong(@ModelAttribute("song") Song song,@PathVariable("id")Integer id) {
		
		songService.addNewSong(song ,id);
		
		return "redirect:/single/" + id; 
		
	}

}
