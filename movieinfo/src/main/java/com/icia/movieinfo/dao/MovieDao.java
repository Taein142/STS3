package com.icia.movieinfo.dao;

import java.util.List;

import com.icia.movieinfo.dto.MovieDto;

public interface MovieDao {
	List<MovieDto> getMovieList();
}

//java <-> Mybatis(xml)