package com.example.erafmak.resourse;

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

import com.example.erafmak.entity.Artist;
import com.example.erafmak.entity.Show;
import com.example.erafmak.entity.Song;
import com.example.erafmak.repository.ShowRepository;

@Controller
public class ShowController {
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	ArtistService artistService;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("show", showService.lastShow());
		return "index";
	}
	
	@GetMapping("/all")
	public String getAll(Model model) {
		
		model.addAttribute("shows", showService.findAllShows());
		return "all";
	}
	
	@GetMapping("/single/{id}")
	public String getSingle(Model model ,@PathVariable("id")Integer id) {
		model.addAttribute("artist", new Artist());
		model.addAttribute("song", new Song());
		model.addAttribute("show", showService.findById(id));
		model.addAttribute("artists", artistService.artists());
		return "single";
	}
	
	@GetMapping("/new")
	public String newShow(Model model) {
		
		model.addAttribute("show", new Show());
		return "new";
	}
	
	@PostMapping("/new")
	public String create(@ModelAttribute("show") Show show,  @RequestParam("fileImage") MultipartFile multiPartFile) throws IOException {
		
		Show newShow = showService.addNewShow(show, multiPartFile);
		return "redirect:/single/" + newShow.getId();
	}
	
	@PostMapping("/updateImage/{id}")
	public String updateShowImage(@PathVariable("id")Integer id,@RequestParam("fileImage") MultipartFile multiPartFile) throws IOException {
		imageService.updateShowImage(id, multiPartFile);
		return "redirect:/single/" + id;
		
	}
	
	
	
	
	
	

}
