package com.icia.movieinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.movieinfo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private MovieService mServ;
	
	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");
		
		String view = mServ.getMovieList(model);
		
		return view;
	}
	
}//class end



