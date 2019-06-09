$(document).ready(function() {	
		$.ajax({
	        url: "http://localhost:8080/task"
	    }).then(function(data) {
	    	$("#userName").empty();
	    	$("#userName").append(data.name)    	
	    });   
});