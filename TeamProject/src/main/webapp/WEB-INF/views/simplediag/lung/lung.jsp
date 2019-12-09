<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ lung page □□□</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${rootPath}/js/simplediag/lung/simplediag-lung-list.js"></script>
<script>
var rootPath="${pageContext.request.contextPath}"
</script>
<link rel="stylesheet" type="text/css" href="${rootPath }/css/simplediag/lung/lunglist.css">
</head>
<body>
<%@ include file="/WEB-INF/views/simplediag/lung/lung-body.jspf" %>
</body>
</html>