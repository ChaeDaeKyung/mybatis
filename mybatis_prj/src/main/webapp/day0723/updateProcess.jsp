<%@page import="day0723.SelectService6"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
    
<jsp:useBean id="wmDTO" class="day0723.WebMemberDTO" scope="page"/>
<jsp:setProperty name="wmDTO" property="*"/>
<%
String id = "test3";//세션에서 꺼내온 id
wmDTO.setId(id);
SelectService6 ss = SelectService6.getInstance();
pageContext.setAttribute("flag", ss.modifyMember(wmDTO));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var msg ="회원 정보 수정 실패";
	<c:if test="${ flag }">
		msg = "회원의 정보를 수정하였습니다.";
	</c:if>
	alert(msg);
	history.back();
</script>
</head>
<body>

</body>
</html>