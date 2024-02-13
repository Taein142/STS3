package com.service;

import java.util.List;

import com.dao.DataDao;
import com.dao.DataDao;
import com.dto.DataDto;

public class DataService {
	DataDao dDao = new DataDao();
	
	//데이터 삽입 서비스 메소드
	public String insertData(DataDto data) {
		String message = null;
		
		int result = dDao.insertData(data);
		
		if(result > 0) {
			message = "입력 성공";
		}
		else {
			message = "입력 실패";
		}
		
		return message;
	}
	
	//데이터 전체 목록 가져오기 메소드
	//이 서비스 메소드의 목적 : controller에게 테이블의 목록을 전달하는 것.
	public List<DataDto> getList() {
		List<DataDto> dList = dDao.selectList();
		
		return dList;
	}
	
	//검색 데이터 가져오기 메소드
	public DataDto getData(int code) {
		 DataDto data = dDao.selectData(code);
		 
		 return data;
	}
	
	//수정 서비스 메소드
	public String updateData(DataDto data) {
		String message = null;
		
		int result = dDao.updateData(data);
		
		if(result > 0) {
			message = "수정 성공";
		}
		else {
			message = "수정 실패";
		}
		
		return message;
	}
	
	public String deleteData(int code) {
		String message = null;
		
		int result = dDao.deleteData(code);
		
		if(result > 0) {
			message = "삭제 성공";
		}
		else {
			message = "삭제 실패";
		}
		
		return message;
	}
}//class end





