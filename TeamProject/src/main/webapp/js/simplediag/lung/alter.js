$(function() {
	
	var cursorArray = [
			'url("http://localhost:8080/iolist/css/doubleParrot(1).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(2).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(3).png"), auto',
			,
			'url("http://localhost:8080/iolist/css/doubleParrot(4).png"), auto',
			,
			'url("http://localhost:8080/iolist/css/doubleParrot(5).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(6).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(7).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(8).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(9).png"), auto',
			'url("http://localhost:8080/iolist/css/doubleParrot(10).png"), auto' ];
	var i = 0
	setInterval(function() {
		i++
		$('html').css('cursor', cursorArray[i])
		if (i >= cursorArray.length || i < 0) {
			i = 0;
		}
	}, 50);
})

$(document).ready(function() {
	var max_fields      = 10; //maximum input boxes allowed
	var wrapper   		= $(".input_fields_wrap"); //Fields wrapper
	var add_button      = $(".add_field_button"); //Add button ID
	
	var x = 1; //initlal text box count
	$(add_button).click(function(e){ //on add input button click
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			$(wrapper).append('<div><input type="text" name="strExpl"/><a href="#" class="remove_field">Remove</a></div>'); //add input box
		}
	});
	
	$(wrapper).on("click",".remove_field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x--;
	})
});