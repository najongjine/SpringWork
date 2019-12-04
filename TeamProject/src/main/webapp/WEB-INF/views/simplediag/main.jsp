<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ Simple Diagnosis Main □□□</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var rootPath="${pageContext.request.contextPath }"
</script>
<script src="${rootPath }/js/simplediag-main.js?ver=1"></script>
<!--
 <link rel="stylesheet" type="text/css" href="${rootPath }/css/simplediagMain.css">
 --> 
</head>
<body>
<%@ include file="/WEB-INF/views/simplediag/main-body.jspf" %>

</body>
</html>