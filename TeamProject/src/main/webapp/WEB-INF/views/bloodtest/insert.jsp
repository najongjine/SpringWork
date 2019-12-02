<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
</head>
<body>
<form method="post">
<input name="bld_seq" type="hidden" value="<c:out value='${IO_DTO.io_total }' default='0'/>" >
<label>이름: </label><input name="bld_name" value="${bldDTO.bld_name}">
<label>최소수치: </label><input name="bld_normalmin" value="${bldDTO.bld_normalmin}">
<label>최대수치: </label><input name="bld_normalmax" value="${bldDTO.bld_normalmax}">
<label>미만: </label><input name="bld_overnormal" value="${bldDTO.bld_overnormal}">
<label>초과: </label><input name="bld_belownormal" value="${bldDTO.bld_belownormal}">
<button></button>
</form>
</body>
</html>