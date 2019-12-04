$(function() {
	$("#btn-update").click(function(e) {
		let id = $(this).attr("data-id")
		document.location.href = rootPath+"/bloodtest/update?id=" + id
	})
	$("#btn-delete").click(function(e) {
		let id = $(this).attr("data-id")
		document.location.href = rootPath+"/bloodtest/delete?id=" + id
	})
})