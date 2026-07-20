<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
var param ="serviceKey=ceff4a7504433bce8e4c7813de6dd3c739dfbdaa267c70afc132a0c7e0fff968&numOf&Rows=10&pageNo=1&MobileOS=ETC&MobileApp=TestApp&_type=json";

$.ajax({
	url: "http://apis.data.go.kr/B551011/KorService2/areaCode2",
	type: "get",
	data: param,
	dataType: "json",
	error: function(xhr) {
		console.log(xhr.status + "/" + xhr.statusText);
	},
	success: function(jsonObj) {
		var output = "<ul>";
		$.each(jsonObj.data, function(i, jsonTemp) {
			// JSONArray 안에 JSONObject을 얻어와서 parsing
			output += "<li>" + jsonTemp.subject + "</li>";
		});
		output = "</ul>";
	}
});
</script>
</body>
</html>