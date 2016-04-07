var rootURL = "http://localhost:8080/IoTApplication/rest/weightEntry";

function addWeight() {
	console.log('addWeight')
	var weight = randomNumber(120, 200);
	$('#weight').val(weight);
	var personData = {
		"name" : $("#name").val(),
		"baseWeight" : $("#baseWeight").val(),
		"weight" : weight
	};
	// alert(JSON.stringify(personData));

	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootURL,
		dataType : "json",
		data : JSON.stringify(personData),
		success : function(data) {
//			alert("data sent successfully");

		},
		error : function(er) {
			alert(er);
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

function randomNumber(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}