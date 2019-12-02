$(function() {

	$("#btn-save").click(function() {
		let bld_name = $("#bld_name").val()
		if (bld_name == "") {
			alert("거래처 코드는 반드시 입력해야 합니다!!")
			$("#bld_name").focus()
			return false
		}
		if (confirm("save?")) {
			$("form").submit()
		}
	})

	/*
	 * 어떤 글자가 입력 되었는가 event의 keycode라는 속성에 문자의 ascii 값이 저장되어 전달됨
	 */
	$("#io_pcode").keypress(function(event) {
		if (event.keyCode == 13) {
			let str = $(this).val()
			let query = rootPath
			query += "/product/search?strText=" + str
			let status = "toolbar=no,"
			status += "scrollbars=yes,"
			status += "resizable=no,"
			status += "top=300,"
			status += "width=700,"
			status += "height=500"
			window.open(query, "_blank", status)
		}
	})
})