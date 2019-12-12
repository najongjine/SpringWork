<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>allList blood test</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	var rootPath = "${pageContext.request.contextPath }"
</script>
<script src="${rootPath }/js/bld-allList-1.0.js?ver=4"></script>
<link rel="stylesheet" type="text/css" href="${rootPath }/css/bloodtest/allList.css?ver=2">
</head>
<body>
<%@ include file="/WEB-INF/views/bloodtest/allList-body.jspf" %>

</body>
</html>