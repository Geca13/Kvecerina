package com.example.zavodliva.resourse;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.zavodliva.entity.Artist;

@Controller
public class ArtistController {
	
	@Autowired
	ArtistService artistService;
	
	@GetMapping("/artists")
	public String getArtistsPage(Model model) {
		model.addAttribute("artists", artistService.artists());
		return "artists";
	}
	
	
	@PostMapping("/newArtist/{id}/{sid}")
	public String createArtist(@ModelAttribute("artist") Artist artist, @PathVariable("id")Integer id, @PathVariable("sid")Integer sid) {
		artistService.createNewArtist(artist, sid);
		return "redirect:/single/" + id; 
		
	}
	
	@PostMapping("/updateArtistImage/{id}")
	public String updateArtistImage(@PathVariable("id")Integer id,  @RequestParam("fileImage") MultipartFile multiPartFile) throws IOException {
		artistService.updateImage(id,multiPartFile);
		return "redirect:/artists"; 
	}
	@PostMapping("/updateArtistName/{id}")
	public String updateArtistName(@PathVariable("id")Integer id,  @RequestParam("fullName") String fullName){
		artistService.updateArtistName(id,fullName);
		return "redirect:/artists"; 
	}
	
	
}
