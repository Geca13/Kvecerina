package com.example.zavodliva.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
	@PostMapping("/updateSongTitle/{id}/{sid}")
	public String upateSongTitle(@Param("title")String title,@PathVariable("id")Integer id,@PathVariable("sid")Integer sid ) {
		songService.updateSongTitle(title ,sid);
		return "redirect:/single/" + id; 
	}
	
	@PostMapping("/updateSongYear/{id}/{sid}")
	public String upateSongYear(@Param("year")String year,@PathVariable("id")Integer id ,@PathVariable("sid")Integer sid ) {
		songService.updateSongYear(year ,sid);
		return "redirect:/single/" + id; 
	}
	
	@PostMapping("/removeArtistFromSong/{id}/{sid}/{aid}")
	public String removeArtistFromSong(@PathVariable("id")Integer id ,@PathVariable("sid")Integer sid ,@PathVariable("aid")Integer aid) {
		artistService.removeArtistFromSong(sid,aid);
		return "redirect:/single/" + id;
	}
	
	@PostMapping("/deleteSong/{id}/{sid}")
	public String deleteSong(@PathVariable("id")Integer id ,@PathVariable("sid")Integer sid) {
		songService.deleteSong(id,sid);
		return "redirect:/single/" + id;
	}
	
	

}
