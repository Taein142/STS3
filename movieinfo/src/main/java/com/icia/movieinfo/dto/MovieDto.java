package com.icia.movieinfo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("movie")
public class MovieDto {
	private int m_code;
    private String m_name;//제목
    private String m_director;//감독
    private String m_nation;//국가
    private String m_genre;//장르
    private String m_actor;//주연배우
    private String m_open;//개봉일
    private String m_synopsis;//영화 개요
    private String p_sysname;//포스터 저장이름
}




