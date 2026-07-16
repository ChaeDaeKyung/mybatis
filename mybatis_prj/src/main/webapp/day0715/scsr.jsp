<%@page import="day0715.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});// btn click
});//ready1
</script>
<h2>컬럼하나에 한행 조회</h2>
<h3>부서번호에 해당하는 부서명 검색</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>부서번호</label><input type="text" name="deptno"/>
		<input type="text" name="deptno" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	<c:if test="${ not empty param.deptno }">
		<%
		SelectService ss = SelectService.getInstance();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		pageContext.setAttribute("dname",ss.scsr(deptno));
		%>
		<c:out value="${ param.deptno }"/> 번
		<c:choose>
			<c:when test="${ not empty dname }">
				<span style="font-weight: bold"><c:out value="${ dname }"/></span> 입니다.
			</c:when>
			<c:otherwise>부서는 존재하지 않습니다.</c:otherwise>
		</c:choose>
	</c:if>
</div>