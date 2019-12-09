<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>view a data</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	var rootPath = "${pageContext.request.contextPath }"
</script>
<script src="${rootPath }/js/bld-view-1.0.js?ver=2"></script>
<link rel="stylesheet" type="text/css" href="${rootPath }/css/bloodtest/view.css?ver=1">
</head>
<body>
<%@ include file="/WEB-INF/views/bloodtest/view-body.jspf" %>
	
</body>
</html>