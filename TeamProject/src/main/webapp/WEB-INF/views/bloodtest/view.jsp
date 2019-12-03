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
</head>
<body>
	<table border="2">
		<tr>
			<th>BLD_SEQ:</th>
			<td>${bldDTO.bld_seq }</td>
		</tr>

		<tr>
			<th>항목명:</th>
			<td>${bldDTO.bld_name }</td>
		</tr>

		<tr>
			<th>최소수치:</th>
			<td>${bldDTO.bld_normalmin }</td>
		</tr>

		<tr>
			<th>최대수치:</th>
			<td>${bldDTO.bld_normalmax }</td>
		</tr>

		<tr>
			<th>최소수치 이하시 증상:</th>
			<td>${bldDTO.bld_overnormal }</td>
		</tr>

		<tr>
			<th>최대수치 이상시 증상:</th>
			<td>${bldDTO.bld_belownormal }</td>
		</tr>

	</table>
	<button id="btn-update">update</button>
	<button id="btn-delete">delete</button>
</body>
</html>