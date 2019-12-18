<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btn-search").click(function() {
		//$("form").serialize() := form에 입력된 데이터를 json type으로 바꾸어서 서버에 전송할수 있도록
		//문자열화 하여라.
		var queryString=$("form").serialize();
		
		/*
		Async Javascript XML:= 비동기 방식으로 서버에 request를 보낼때 사용하는 js의 내장 프로토콜.
		1. web에서 ajax에게 req를 요청하면
		2. ajax는 즉시 ok를 보내서 web이 다른 작업을 수행할수 있도록 하고
		3. ajax는 매개변수로 설정된 항목에 의해서 서버에 request를 보낸다.
		4. 서버에서 정상적으로 response를 보내면
		5. success에 설정된 함수를 실행한다.
		6. success에 설정된 함수에 여러가지 코드를 작성하여 결과를 처리한다.
		*/
		$.ajax({
			url:"${rootPath}/searchAPI", //서버로 req할 주소
			data:queryString, //서버로 보낼 데이터
			type:"post", //req method
			//dataType:"json", //response로 받을 data type
			success:function(result){ //결과가 성공했을때
				//resFunc(result)
				$("#bok-list").html(result)
			},
			error:function(xhr,status,error){ //오류보낼때
				alert(error)
			}
		})
		/*
		var resFunc= function(result){
			let temp=$("#bok-temp")
			
			result.forEach(function(vo) {
				temp.append($('<p/>',{text:vo.servDgst,
					dataId:vo.servDgst
					}))
			})
		}*/
	})
})
</script>
<style type="text/css">
fieldset{
	width: 80%;
	border: 1px solid green;
	border-radius: 10px;
	margin: 10px auto; 
}
fieldset div{
	display: flex;
}
fieldset div label{
	display: inline-block;
	width: 20%;
	padding: 8px 10px;
	margin: 2px;
	margin-right:5px;
	text-align: right;;
	vertical-align: center;
	white-space: nowrap;
	color:blue;
}
fieldset div input, fieldset div select{
	display: inline-block;
	width: 70%;
	padding: 8px;
	margin: 10px;
	border: 1px solid #ddd;

}
</style>
</head>
<body>

<fieldset>
<form:form modelAttribute="bokSearchDTO">
<div>
<label for="srchKeyCode">검색분류</label>
<form:select path="srchKeyCode"	label="검색분류">
	<!--  value, label 형태로 됨 -->
	<form:options items="${SeMap.srchKeyCode}" />
</form:select>
</div>

<div>
<label for="searchWrd">검색어</label>
<form:input path="searchWrd"	label="검색어"/>
</div>

<div>
<label for="lifeArray">검색분류</label>
<form:select path="lifeArray"	label="생애주기">
	<form:options items="${SeMap.lifeArray}" />
</form:select>
</div>

<div>
<label for="charTrgterArray">대상특성</label>
<form:select path="charTrgterArray"	label="대상특성">
	<form:options items="${SeMap.charTrgterArray}" />
</form:select>
</div>

<div>
<label for="obstKiArray">장애유형</label>
<form:select path="obstKiArray"	label="장애유형">
	<form:options items="${SeMap.obstKiArray}" />
</form:select>
</div>

<div>
<label for="obstAbtArray">장애정도</label>
<form:select path="obstAbtArray"	label="장애정도">
	<form:options items="${SeMap.obstAbtArray}" />
</form:select>
</div>

<div>
<label for="trgterIndvdlArray">가구유형</label>
<form:select path="trgterIndvdlArray"	label="가구유형">
	<form:options items="${SeMap.trgterIndvdlArray}" />
</form:select>
</div>

<div>
<label for="desireArray">욕구</label>
<form:select path="desireArray"	label="욕구">
	<form:options items="${SeMap.desireArray}" />
</form:select>
</div>
<div>
	<label></label>
	<button id="btn-search" type="button">조회</button>
</div>
</form:form>

</fieldset>

</body>
</html>