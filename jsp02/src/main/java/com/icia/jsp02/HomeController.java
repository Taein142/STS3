package com.icia.jsp02;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.jsp02.HomeController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("jstl_1")
	public String jstl_1(Model model){
		log.info("jstl_1()");
		model.addAttribute("user", 1);
		
		List<String> sList = new ArrayList<String>();
		sList.add("아메라카노");
		sList.add("카라멜마끼아또");
		sList.add("카페라떼");
		sList.add("딸기라떼");
		sList.add("자바 초콜릿칩 푸라푸치노");	
		model.addAttribute("menu", sList);
		
		return "jstl01";
	}
	
	@GetMapping("today")
	public String today() {
		log.info("today()");
		return "today";
	}
}
