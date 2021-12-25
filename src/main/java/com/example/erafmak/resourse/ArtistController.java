package com.example.erafmak.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.erafmak.entity.Artist;

@Controller
public class ArtistController {
	
	@Autowired
	ArtistService artistService;
	
	@PostMapping("/newArtist/{id}/{sid}")
	public String createArtist(@ModelAttribute("artist") Artist artist, @PathVariable("id")Integer id, @PathVariable("sid")Integer sid) {
		artistService.createNewArtist(artist, sid);
		return "redirect:/single/" + id; 
		
	}

}
