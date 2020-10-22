/**
 * 
 */
 
 	$("#btn").click(function() {
		var t = $("#title").val();
		var w = $("#writer").val();
		var c = $("#contents").val();
		
		if(t && w && c) {
			console.log("OK");
			$("#frm").submit();
		} else {
			alert("필수 항목 입력");
		}
	});