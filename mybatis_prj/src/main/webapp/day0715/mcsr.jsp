<%@page import="day0715.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});// btn click
});//ready1
</script>
<h2>컬럼여러개의 한행 조회</h2>
<h3>사원번호에 해당하는 사원정보 검색</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>사원번호</label><input type="text" name="empno"/>
		<input type="text" name="empno" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	<c:if test="${ not empty param.empno }">
		<%
		SelectService ss = SelectService.getInstance();
		int empno = Integer.parseInt(request.getParameter("empno"));
		pageContext.setAttribute("ed",ss.mcsr(empno));
		%>
		사원번호 : <strong><c:out value="${ param.empno }"/></strong><br>
		<c:choose>
			<c:when test="${ not empty ed }">
				검색된 정보
				<ul>
				<li> 사원명 : <strong><c:out value="${ ed.ename }"/></strong></li>
				<li> 매니저번호 : <strong><c:out value="${ ed.mgr }"/></strong></li>
				<li> 직무 : <strong><c:out value="${ ed.job }"/></strong></li>
				<li> 연봉 : <strong><c:out value="${ ed.sal }"/></strong></li>
				<li> 보너스 : <strong><c:out value="${ ed.comm }"/></strong></li>
				<li> 입사일 : <strong><fmt:formatDate value="${ ed.hiredate }" pattern="yyyy-MM-dd"/></strong></li>
				<li> 부서번호 : <strong><c:out value="${ ed.deptno }"/></strong></li>
				</ul>
				
			</c:when>
			<c:otherwise>해당 사원은 존재하지 않습니다.</c:otherwise>
		</c:choose>
	</c:if>
</div>