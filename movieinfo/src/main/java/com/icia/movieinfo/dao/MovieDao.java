package com.icia.movieinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.icia.movieinfo.dto.MovieDto;

public interface MovieDao {
	// 영화 목록 가져오기
	List<MovieDto> getMovieList(Map<String, Integer> pMao);
	
	// 전체 영화 개수 구하기
	@Select("SELECT count(*) FROM movietbl")
	int cntMovie();
	
	// 영화 정보 입력
	void insertMovie(MovieDto movie);
	
	// 영화 정보 상세 보기
	MovieDto selectMovie(Integer m_code);
	
	// 영화 정보 수정
	void updateMovie(MovieDto movie);
	
	// 영화 정보 삭제
	void deleteMovie(Integer m_code);
	
}

//java <-> Mybatis(xml)