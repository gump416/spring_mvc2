<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>회원 목록</h2>
<table border="1">
	<tr><th>이름</th><th>나이</th></tr>
	<c:forEach items="${members}" var="member">
		<tr><td>${member.name }</td><td>${member.age }</td></tr>
	</c:forEach>
	
</table>
</body>
</html>