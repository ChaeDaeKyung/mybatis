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
						new SelectTestDTO("like","like 조회"),
						new SelectTestDTO("subquery","subquery"),
						new SelectTestDTO("union","union"),
						new SelectTestDTO("subqueryJoin","subquery &amp; join"),
						new SelectTestDTO("dynamincTable","테이블명이 동적일때"),
						new SelectTestDTO("dynaminIf","동적 쿼리 if"),
						new SelectTestDTO("dynaminChoose","동적 쿼리 choose"),
						new SelectTestDTO("dynaminSet","동적 쿼리 set"),
						new SelectTestDTO("dynaminEach","동적 쿼리 each")
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
			<c:import url="${ param.page }.jsp"/>
		</c:if>
	</div>
</body>
</html>