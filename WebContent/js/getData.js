var rootURL = "http://localhost:8080/IoTApplication/rest/read";

function allMetrics() {
	$('#all').val("");
	console.log('allMetrics')
	$.ajax({
		type : 'GET',
		url : rootURL + "/allMetrics",
		dataType : "json",
		success : function(data) {
			var val = JSON.stringify(data);
			$('#all').val(val);
		},
		error : function(er) {
			alert(er);
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

function allAlerts() {
	$('#all').val("");
	console.log('allAlerts')
	$.ajax({
		type : 'GET',
		url : rootURL + "/allAlerts",
		dataType : "json",
		success : function(data) {
			var val = JSON.stringify(data);
			$('#all').val(val);
		},
		error : function(er) {
			alert(er);
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

var rootURL = "http://localhost:8080/IoTApplication/rest/read";

function specificMetrics() {
	console.log('specificMetrics')
	start = $("#start").val();
	end = $("#end").val();
	$.ajax({
		type : 'GET',
		url : rootURL + "/metrics/" + start + "/" + end,
		dataType : "json",
		success : function(data) {
			var val = JSON.stringify(data);
//			alert(val);
			$('#specific').val(val);
		},
		error : function(er) {
			alert(er);
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

function specificAlert() {
	$('#specific').val("");
	console.log('specificAlert')
	start = $("#start").val();
	end = $("#end").val();
	$.ajax({
		type : 'GET',
		url : rootURL + "/alert/" + start + "/" + end,
		dataType : "json",
		success : function(data) {
			var val = JSON.stringify(data);
//			alert(val);
			$('#specific').val(val);
		},
		error : function(er) {
			alert(er);
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

function allClear() {
	$('#all').val("");
}

function specificClear() {
	$('#specific').val("");
}