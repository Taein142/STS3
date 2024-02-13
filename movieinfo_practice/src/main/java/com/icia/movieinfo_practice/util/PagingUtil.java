package com.icia.movieinfo_practice.util;

import java.util.Iterator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
	private int maxNum;
	private int pageNum;
	private int listCnt;
	private int pageCnt;

	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();
		
		// 1. 전체 페이지 개수 구하기
		int totalPage = (maxNum%listCnt) > 0?
				maxNum / listCnt +1 :
				maxNum / listCnt;
		
		// 2. 현재 페이지가 속해 있는 번호 그룹 구하기
		int curGroup = (pageNum % pageCnt) >0?
				pageNum / pageCnt+1:
				pageNum / pageCnt;
		
		// 3. 번호 그룹의 시작 번호
		int start = (curGroup * pageCnt) - (pageCnt - 1);		
		
		// 4. 번호 그룹으 ㅣ마지막 번호
		int end = (curGroup * pageCnt) >= totalPage ?
				totalPage : curGroup * pageCnt;
		
		// 5. 이전 버튼 처리
		if (start !=1) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((start - 1) + "'>");
			sb.append("◀</a>");
		}
		
		// 6. 중가 번호 버튼 처리
		for(int i = start; i <= end; i++) {
			if(pageNum != i){
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append(i + "'>" + i + "</a>");
			}else {
			sb.append("<font class='pno'>" + i + "</font>");
			}
		}
		
		// 7. 다음 버튼 처리
		if(end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((end + 1) + "'>");
			sb.append("▶</a>");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return pageStr;
	}

}
