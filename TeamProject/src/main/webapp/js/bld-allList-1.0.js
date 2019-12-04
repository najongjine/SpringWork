$(function() {
	$(".content-body").click(function(e) {
		let id = $(this).attr("data-id")
		
		/*
		주소창에 /dept/view를 입력하여 서버에 전송하라
		id변수에 값을실어서 보내라
		 */
		document.location.href = rootPath+"/bloodtest/view?id=" + id
	})
})