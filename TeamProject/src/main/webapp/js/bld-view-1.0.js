$(function() {
	$("#btn-update").click(function(e) {
		let id = $(this).attr("data-id")
		document.location.href = rootPath+"/bloodtest/update?id=" + id
	})
	$("#btn-delete").click(function(e) {
		let id = $(this).attr("data-id")
		document.location.href = rootPath+"/bloodtest/delete?id=" + id
	})
	
	var cursorArray = ['url("http://localhost:8080/iolist/css/doubleParrot(1).png"), auto',
	                   'url("http://localhost:8080/iolist/css/doubleParrot(2).png"), auto',
	                  'url("http://localhost:8080/iolist/css/doubleParrot(3).png"), auto',,
	                  'url("http://localhost:8080/iolist/css/doubleParrot(4).png"), auto',,
	                  'url("http://localhost:8080/iolist/css/doubleParrot(5).png"), auto',
	                  'url("http://localhost:8080/iolist/css/doubleParrot(6).png"), auto',
	                  'url("http://localhost:8080/iolist/css/doubleParrot(7).png"), auto',
	                  'url("http://localhost:8080/iolist/css/doubleParrot(8).png"), auto',
	                  'url("http://localhost:8080/iolist/css/doubleParrot(9).png"), auto',
	                  'url("http://localhost:8080/iolist/css/doubleParrot(10).png"), auto'
	                  ];
	var i=0
	setInterval(function() {
		i++
		$('html').css('cursor', cursorArray[i])
		if(i >= cursorArray.length || i<0){
		    i = 0; 
		  }
	  }, 50);
})