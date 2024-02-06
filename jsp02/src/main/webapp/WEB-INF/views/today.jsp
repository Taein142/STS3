<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="date" value="<%=new Date()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력 형식</title>
</head>
<body>
	[오늘의 날짜] <fmt:formatDate value="${date}"/> <br>
	[오늘의 시간] <fmt:formatDate value="${date}" type="time"/> <br>
	[오늘의 날짜&시간] <fmt:formatDate value="${date}" type="both"/> <br>
<hr>

<h1>날짜의 출력 형식</h1>
<h2>지정된 출력 형식</h2>
[f] <fmt:formatDate value="${date}" type="both"
		dateStyle="full" timeStyle="full"/> <br>
[l] <fmt:formatDate value="${date}" type="both"
		dateStyle="long" timeStyle="long"/> <br>
[m] <fmt:formatDate value="${date}" type="both"
		dateStyle="medium" timeStyle="medium"/> <br>
[s] <fmt:formatDate value="${date}" type="both"
		dateStyle="short" timeStyle="short"/> <br>
<hr>
<h2>임의의 출력 형식 지정</h2>
[패턴1] <fmt:formatDate value="${date}" type="both"
		pattern="yyyy-MM-dd hh:MM:ss"/> <br>
[패턴2] <fmt:formatDate value="${date}"
		pattern="yy-MM-dd(E)"/> <br>
[패턴3] <fmt:formatDate value="${date}" type="time"
		pattern="(a) hh:MM:ss"/>

<hr>
<h1>숫자의 출력 형식</h1>
<p>
	예 1-1 : <fmt:formatNumber value="123456789"/> <br>
	예 1-2 : <fmt:formatNumber value="123456789" groupingUsed="false"/>
</p>
<p>
	예 2-1 : <fmt:formatNumber value="3.141592"/> <br>
	예 2-2 : <fmt:formatNumber value="3.141592" pattern="#.######"/>
</p>
<p>
	예 3 : <fmt:formatNumber value="10.5" pattern="#.000"/>
</p>
<p>
	예 4-1 : <fmt:formatNumber value="1000000" type="currency"/> <br>
	예 4-2 : <fmt:formatNumber value="1000000" type="currency" currencySymbol="$"/>
</p>
<p>
	예 5 : <fmt:formatNumber value="0.98" type="percent"/>
</p>





</body>
</html>