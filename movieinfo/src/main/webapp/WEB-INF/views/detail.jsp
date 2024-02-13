<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MOVIE INFO - DETAIL</title>
	<link rel="stylesheet" href="resources/css/style.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	<script>
        $(function () {
            let m = "${msg}";
            if(m != ""){
                alert(m);
            }
        });
    </script>
</head>
<body>
<div class="wrap">
	<jsp:include page="header.jsp" />
	<div class="content">
		<h2 class="form-header">상세 보기</h2>
		<!-- 게시글 상세 내용 출력(div) -->
		<div class="detail">
			<div class="detail-sub">
				<div class="detail-title">포스터</div>
				<div class="detail-content">
					<c:if test="${empty movie.p_sysname}">
						<img class="poster" src="resources/images/no_image.jpg">
					</c:if>
					<c:if test="${!empty movie.p_sysname}">
						<img class="poster" src="resources/upload/${movie.p_sysname}">
					</c:if>
				</div>
			</div>
		</div>
		<div class="detail">
			<div class="detail-sub">
				<div class="detail-title">제목</div>
				<div class="detail-content">${movie.m_name}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">감독</div>
				<div class="detail-content">${movie.m_director}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">주연</div>
				<div class="detail-content">${movie.m_actor}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">국가</div>
				<div class="detail-content">${movie.m_nation}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">장르</div>
				<div class="detail-content">${movie.m_genre}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">개봉일</div>
				<div class="detail-content">${movie.m_open}</div>
			</div>
		</div>
		<div class="detail">
			<div class="detail-sub">
				<div class="synopsis-title">시놉시스</div>
				<div class="synopsis-content">${movie.m_synopsis}</div>
			</div>
		</div>
		<div class="btn-area">
			<button class="btn-write" id="upbtn">U</button>
			<button class="btn-write" id="delbtn">D</button>
			<button class="btn-sub" id="backbtn">B</button>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
<script>
	$("#backbtn").click(function () {
		location.href = `./?pageNum=${pageNum}`;
	});
	
	$("#upbtn").click(function () {
		location.href = `./updateFrm?m_code=${movie.m_code}`;
	});
	
	//게시글 삭제
	$("#delbtn").click(function () {
		let conf = confirm("삭제할까요?");
		if(conf){
		  location.href = `./delete?m_code=${movie.m_code}`;
		}
	});
</script>
</html>