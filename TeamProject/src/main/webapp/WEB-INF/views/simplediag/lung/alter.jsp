<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> var rootPath="${pageContext.request.contextPath }"</script>
<script src="${rootPath }/js/simplediag/lung/alter.js"></script>
<link rel="stylesheet" type="text/css" href="${rootPath }/css/simplediag/lung/alter.css?ver=3">
</head>
<body>
<%@ include file="/WEB-INF/views/simplediag/lung/alter-body.jspf" %>
</body>
</html>