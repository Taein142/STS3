<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>DTO를 활용한 전송</h2>
	<form action="dtoSend" method="post">
		<input type="number" name="code" placeholder="번호"> <br>
		<input type="text" name="strData" placeholder="이름"> <br>
		<input type="number" name="numData" placeholder="나이"> <br>
		<input type="date" name="dateData" placeholder="생일"> <br> 
		<input type="submit" value="전송">
	</form>



	<hr>
	<h1>${sec_data}</h1>
	<hr>
	<h2>번호: ${person2.code}</h2>
	<h2>이름: ${person2.strData}</h2>
	<h2>나이: ${person2.numData}</h2>
	<h2>생일: ${person2.dateData}</h2>
	<hr>
	<a href="send?id=user&num1=1234&num2=74">[전송]</a>
	<hr>
	<form action="login" method=get> <!-- method는 디폴트가 get이다.(생략가능) -->
		<input type="text" name="id" placeholder="아이디를 입력해주세요" required> <br>
		<input type="password" name="pw" placeholder="비밀번호를 입력해주세요" required> <br>
		<input type="submit" value="로그인"> 
	</form>
	<hr>
	<input type="text" id="id_in">
	<input type="text" id="pw_in">
	<!-- <input type="button" value="login"> -->
	<button id="lbtn">login</button>
	
</body>
<script type="text/javascript">
	// location.href = "url"; // a태그와 유사한 역할. 그냥냅두면 맘대로 url을 불러오기에 함수에 넣어둠.
	const idinput = document.querySelector("#id_in");
	const qwinput = document.querySelector("#pw_in");
	const logbtn = document.querySelector("#lbtn");
	
	logbtn.onclick = function() {
		let idv = idinput.value;
		let pwv = qwinput.value;
		location.href=`login?id=\${idv}&pw=\${pwv}`;
		/* let str = "login?id=" + idv + "&pw=" + pwv; */
		/* location.href = str; */
		/* location.href = `login?id=${idinput.value}&pw=${qwinput.value}`; */	
	}
</script>
</html>