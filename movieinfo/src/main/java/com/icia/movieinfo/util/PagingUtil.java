package com.icia.movieinfo.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
	private int maxNum;//전체 콘텐츠 개수 저장 변수
	private int pageNum;//현재 보이는 페이지의 번호 저장 변수
	private int listCnt;//한 페이지 당 보일 콘텐츠 개수 저장 변수
	private int pageCnt;//보여질 페이지 번호 개수 저장 변수
	
	//페이징용 html 코드를 만드는 메소드
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();
		
		//1. 전체 페이지 개수 구하기
		// 전체 콘텐츠 개수 5, 페이지 5개씩 출력
		int totalPage = (maxNum % listCnt) > 0 ?
				maxNum / listCnt + 1 :
				maxNum / listCnt;
		
		//2. 현재 페이지가 속해 있는 번호 그룹 구하기
		int curGroup = (pageNum % pageCnt) > 0 ?
				pageNum / pageCnt + 1 :
				pageNum / pageCnt;
		
		//3. 번호 그룹의 시작 번호
		int start = (curGroup * pageCnt) - (pageCnt - 1);
		//두번째 그룹 시작번호 : 2 * pageCnt(5) - (5 - 1) = 6  
		
		//4. 번호 그룹의 마지막 번호
		int end = (curGroup * pageCnt) >= totalPage ?
				totalPage : curGroup * pageCnt;
		//두번째 그룹 마지막번호 : 2 * pageCnt(5) = 10 
		
		//5. 이전 버튼 처리
		if(start != 1) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((start - 1) + "'>");
			sb.append("◀</a>");
		}//<a class='pno' href='./?pageNum=5'>◀</a>
		
		//6. 중간 번호 버튼 처리
		for(int i = start; i <= end; i++) {
			if(pageNum != i){//현재 보이는 페이지가 아닌 경우
				sb.append("<a class='pno' href='./?pageNum=");
				sb.append(i + "'>" + i + "</a>");
			}//<a class='pno' href='./?pageNum=2'>2</a>
			else {//현재 보이는 페이지인 경우
				sb.append("<font class='pno'>" + i + "</font>");
			}//<font class='pno'>3</font>
		}
		
		//7. 다음 버튼 처리
		if(end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((end + 1) + "'>");
			sb.append("▶</a>");
		}//<a class='pno' href='./?pageNum=6'>▶</a>
		
		//StringBuffer에 저장된 내용을 문자열로 변환
		pageStr = sb.toString();
		
		return pageStr;
	}
}






