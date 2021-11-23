<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
<c:if test="${memberview != null || ''}">
<table>
	<tr>
	<th>아이디</th> 
	<th>비밀번호</th>
	<th>이름</th>
	<th>가입일</th>
	</tr>
<c:forEach items="${memberview}" var = "list">
	<tr>
	<td>${list.memberId}</td>
	<td>${list.memberPwd}</td>
	<td>${list.memberNm}</td>
	<td>${list.memberEnrollDt}</td>
	</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>