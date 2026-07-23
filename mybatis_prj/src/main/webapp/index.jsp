<%@page import="day0715.SelectTestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="http://192.168.10.79/mybatis_prj/common/images/favicon.ico">
<style type="text/css">
table {
	border-spacing: 0px; border: 1px solid #333;
}
td,th {
	border: 1px solid #333;
}
th {
	height: 30px;
}
a {
	color: #333; text-decoration: none;
}
a:hover {
	color: #dfdfdf;
}
</style>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
<%
SelectTestDTO[] stArr ={
						new SelectTestDTO("day0715/scsr","컬럼하나 한행 조회"),
						new SelectTestDTO("day0715/mcsr","컬럼여러개 한행 조회"),
						new SelectTestDTO("day0716/scmr","컬럼하나 여러행 조회"),
						new SelectTestDTO("day0720/mcmr","컬럼여러개 여러행 조회"),
						new SelectTestDTO("day0720/lt","작은 값 조회"),
						new SelectTestDTO("day0720/gt","큰 값 조회"),
						new SelectTestDTO("day0721/like","like 조회"),
						new SelectTestDTO("day0721/subqueryJoin","subquery &amp; join"),
						new SelectTestDTO("day0722/dynamicTable","테이블명이 동적일때"),
						new SelectTestDTO("day0722/dynamicIf","동적 쿼리 if"),
						new SelectTestDTO("day0722/dynamicChoose","동적 쿼리 choose"),
						new SelectTestDTO("day0723/dynamicSet","동적 쿼리 set"),
						new SelectTestDTO("day0723/dynamicEach","동적 쿼리 each")
					   };
pageContext.setAttribute("stArr", stArr);
%>
	<div id="selectHeader">
		<table>
			<tr>
			<c:forEach var="stDTO" items="${ stArr }">
			<th><a href="index.jsp?page=${ stDTO.link }"><c:out value="${ stDTO.title }" escapeXml="false"/></a></th>
			</c:forEach>
			</tr>
		</table>
	</div>
	<div id="selectContent">
		<c:if test="${ not empty param.page }">
			<c:if test="${ param.page eq 'day0721/subqueryJoin' }">
				<c:redirect url="day0721/subqueryJoin.jsp"/>
			</c:if>
			<c:import url="${ param.page }.jsp"/>
		</c:if>
	</div>
</body>
</html>