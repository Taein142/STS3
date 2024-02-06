<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%!public int amount(int a, int b) {
		return a * b;
	}%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<hr>
	<!-- Scriptlet / JAVA를 사용하는 부분 / 화면에 출력되지 않음 / JSP 활용방법-->
	<%
	String name = "홍길동";
	int age = 25;
	Date now = new Date();
	%>
	<p>현재 : <%=now%></p>
	<p>
		이름 :
		<%=name%></p>
	<!-- 표현식 -->
	<p>
		나이 :
		<%=age%></p>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>개수</th>
		</tr>
		<%
		for (int i = 0; i < 5; i++) {
		%>
		<tr>
			<td><%=i%></td>
			<td>TV<%=i%></td>
			<td><%=amount(i, 10)%></td>
		</tr>
		<%
		}
		%>

		<%
		for (int j = 0; j < 5; j++) {
			out.println("<tr>");
			out.println("<td>" + j + "</td>");
			out.println("<td>냉장고" + j + "</td>");
			out.println("<td>" + amount(j, 10) + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<hr>
	<a href="jstl_1">[이동]</a>
	
	<hr>
	<jsp:include page="today.jsp"/>
</body>
</html>