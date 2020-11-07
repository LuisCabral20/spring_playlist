package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Playlist;
import dmacc.repository.PlaylistRepository;

@Controller
public class WebController {
	@Autowired
	PlaylistRepository repo;
	
	@GetMapping({"/", "/viewAll"})
	public String viewAllSongs(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewSong(model);
		}
		model.addAttribute("playlist", repo.findAll());
		
		return "results";
	}
	
	@GetMapping("/addSong")
	public String addNewSong(Model model) {
		Playlist s = new Playlist();
		model.addAttribute("newSong", s);
		return "input";
	}
	
	@PostMapping("/addSong")
	public String addNewSong(@ModelAttribute Playlist s, Model model) {
		repo.save(s);
		return viewAllSongs(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatedSong(@PathVariable("id") long id, Model model) {
		Playlist s = repo.findById(id).orElse(null);
		model.addAttribute("newSong", s);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String editSong(Playlist s, Model model) {
		repo.save(s);
		return viewAllSongs(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") long id, Model model) {
		Playlist s = repo.findById(id).orElse(null);
		repo.delete(s);
		return viewAllSongs(model);
	}
}
