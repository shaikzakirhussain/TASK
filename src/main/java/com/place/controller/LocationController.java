package com.place.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.place.entity.Location;
import com.place.repo.LocationRepo;

@Controller
public class LocationController {

	@Autowired
	private LocationRepo locRepo;
	
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Location> unlist = locRepo.findByplaceDesc("");
		List<Location> list = locRepo.findAll();
		list.removeIf(item -> item.getPlaceDesc().equals(""));
		
		model.addAttribute("list_places", list);
		model.addAttribute("unlist_places", unlist);
		
			
		return "index";
	}
	
	
	
	@GetMapping("/add_location")
	public String goTolocation() {
		return "addlocation";
		
	}
	@PostMapping("/save_locations")
	public String saveLocation(@ModelAttribute Location loc, RedirectAttributes rdr) {
		
		locRepo.save(loc);
		rdr.addFlashAttribute("success", "location added successfully");
		return"redirect:/add_location";
	}
}
