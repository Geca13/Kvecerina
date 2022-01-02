package com.example.zavodliva.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zavodliva.entity.Song;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	ArtistService artistService;
	
	@GetMapping("/newSong/{id}")
	public String newSongForm(Model model,@PathVariable("id")Integer id) {
		model.addAttribute("song", new Song());
		model.addAttribute("show", showService.findById(id));
		model.addAttribute("artists", artistService.artists());
		return "newSong";
		
	}
	
	@PostMapping("/newSong/{id}")
	public String createSong(@ModelAttribute("song") Song song,@PathVariable("id")Integer id ) {
		
		songService.addNewSong(song ,id);
		
		return "redirect:/single/" + id; 
		
	}

}
