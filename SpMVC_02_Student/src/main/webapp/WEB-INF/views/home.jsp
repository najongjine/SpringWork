<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<title>□□□ My JSP Page □□□</title>
<style>
header{
background-color: green;
margin: :0;
padding: 1rem;
color: white;
}
header h3{
font-size: 2rem;
}
ol{
list-style: none;
margin: 0
padding: 0;
display: flex;
background-color: #33ddff;
}
ol a{
display: block;
text-decoration: none;
padding: 14px 16px;

}
ol a:hover{
	background-color: #ddd;
	color: blue;
	border-bottom: 3px solid blue;
}
</style>
</head>
<body>
<header>
<h3>학생정보 관리</h3>
</header>
<ol> <!-- ul==unordered list -->
<li><a href="${rootPath}/student/list">학생리스트</a></li>
<li><a href="${rootPath}/student/search">학생검색</a></li>
<li><a href="">로그인</a></li>
<li><a href="">회원가입</a></li>
</ol>
</body>
</html>