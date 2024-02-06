package com.icia.movieinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.icia.movieinfo.dao.MovieDao;
import com.icia.movieinfo.dto.MovieDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieService {
	//DAO
	@Autowired
	private MovieDao mDao;
	
	//영화 목록을 가져와서 컨트롤러에 넘기는 메소드
	public String getMovieList(Model model) {
		log.info("getMovieList()");
		
		List<MovieDto> mList = mDao.getMovieList();
		
		model.addAttribute("mList", mList);
		
		return "home";
	}

}








