<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script >
var rootPath="${pageContext.request.contextPath }"
</script>
<script src="${rootPath }/js/iolist-input-1.0.js?ver=2"></script>
<style>
.inbox {
	display: inline-block;
	width: 70%;
}

.in-box>input {
	padding: 8px;
	margin: 3px;
	display: inline-block;
	width: 70%;
	border: 1px solid #ccc;
}

.in-box>input[type="radio"] {
	padding: 8px;
	margin: 3px;
	display: inline-block;
	width: 70%;
	border: 1px solid #ccc;
}

.in-box>input.io_pcode, input.io_dcode {
	width: 50%;
}

span {
	color: blue;
	font-weight: bold;
	font-style: italic;
}

.in-box>input:hover {
	background-color: #ddd;
	border: 1px solid blue;
}

.in-label {
	display: inline-block;
	width: 20%;
	text-align: left;
	margin-right: 5px;
	padding: 8px;
}

fieldset {
	width: 70%;
	margin: 20px auto;
	border-radius: 5px;
}

legend {
	font-size: 12pt;
	font-weight: bold;
	color: #3d65ff;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-iolist-header.jspf"%>
	<form action="" method="POST">
		<fieldset>
			<legend>매입매출 입력</legend>
			<%
				/*
					io_seq
					io_date
					io_inout
					io_qty
					io_price
					io_total
					io_pcode
					io_dcode
					*/
			%>
			<!-- label의 for 속성: input box와 한 그룹으로 설정
label을 클릭했을때 마치 input box를 클릭한거처럼 input box에 focus를 지정 -->
			<input name="io_seq" id="io_seq" value="${IO_DTO.io_seq}"
				readonly="readonly" type="hidden"
				value="<c:out value='${IO_DTO.io_price }' default='0'/>"> <label
				for="io_dcode" class="in-label">거래처코드</label>
			<div class="in-box">
				<input name="io_dcode" id="io_dcode"> <span id="io_dname">거래처명</span>
			</div>
			<label for="io_inout" class="in-label">거래구분</label>
			<div class="in-box">
				<select name="io_inout" id="io_inout">
					<option value="1">매입</option>
					<option value="2">매출</option>
				</select>
			</div>

			<label for="io_pcode" class="in-label">상품코드</label>
			<div class="in-box">
				<input name="io_pcode" id="io_pcode"> <span id="io_pname">상품이름</span>
			</div>
			<label for="io_date" class="in-label">거래일자</label>
			<div class="in-box">
				<input type="date" name="io_date" id="io_date"
					value="${IO_DTO.io_date}">
			</div>
			<label for="io_qty" class="in-label">수량</label>
			<div class="in-box">
				<input name="io_qty" id="io_qty" type="number"
					value="<c:out value='${IO_DTO.io_qty }' default='0'/>">
			</div>
			<label for="io_price" class="in-label">단가</label>
			<div class="in-box">
				<input name="io_price" id="io_price" type="number"
					value="<c:out value='${IO_DTO.io_price }' default='0'/>">
			</div>
			<label for="io_total" class="in-label">합계</label>
			<div class="in-box">
				<input name="io_total" id="io_total" type="number"
					value="<c:out value='${IO_DTO.io_total }' default='0'/>">
			</div>


			<label class="in-label"></label>
			<div class="in-box">
				<button id="btn-save" type="button">저장</button>
			</div>
		</fieldset>
	</form>
</body>
</html>