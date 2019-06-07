$(document).ready(function() {	
	$('.btn').click(function(){
		$.ajax({
	        url: "http://localhost:8080/task/"+$("#search").val()
	    }).then(function(data) {
	    	$("#title_h").empty();
	    	$("#content").empty();
	    	$("#title_h").append("<h3>"+"主题"+data.id+"</h3>")
	    	$("#content").append(data.description)    	
	    });
	});    
});