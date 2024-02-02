package com.icia.jsp01_practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.jsp01_practice.dto.DataDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	

	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");
		
		DataDTO dataDTO = new DataDTO();
		dataDTO.setDataName("김취업");
		dataDTO.setDataAge(28);
		dataDTO.setDataNumber("010-5809-5132");
		
		model.addAttribute("person1", dataDTO);
		
		return "home";
	}
	
}
