<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sec_data}</h1>
	<hr>
	<h2>번호: ${person2.code}</h2>
	<h2>이름: ${person2.strData}</h2>
	<h2>나이: ${person2.numData}</h2>
	<h2>생일: ${person2.dataData}</h2>
	<hr>
	<a href="send?id=user&num1=1234&num2=74">[전송]</a>
	<hr>
	<form action="login" method="post"> <!-- method는 디폴트가 get이다.(생략가능) -->
		<input type="text" name="id" placeholder="아이디를 입력해주세요"> <br>
		<input type="password" name="pw" placeholder="비밀번호를 입력해주세요"> <br>
		<input type="submit" value="로그인"> 
	</form>
	
	
</body>
</html>