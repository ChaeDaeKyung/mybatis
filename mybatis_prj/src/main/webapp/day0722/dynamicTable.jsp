<%@page import="day0722.SelectService5"%>
<%@page import="day0720.SelectService3"%>
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
<h2>테이블 명이나 컬럼명이 동적일때</h2>
<h3>본사와 지사의 사원 정보 검색</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>본사</label><input type="radio" name="deptName" value="dept"/>
		<label>지사</label><input type="radio" name="deptName" value="cp_dept"/>
		<input type="text" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	<c:if test="${ not empty param.deptName }">
		<%
		SelectService5 ss = SelectService5.getInstance();
		String deptName = request.getParameter("deptName");
		pageContext.setAttribute("listDept",ss.dollarSign(deptName));
		%>
		<strong><c:out value="${ param.deptName eq 'dept' ? '본사':'지사' }"/></strong><br>
		<table>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>위치</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="deptDomain" items="${ listDept }">
			<tr>
				<td><c:out value="${ deptDomain.deptno }"/></td>
				<td><c:out value="${ deptDomain.dname }"/></td>
				<td><c:out value="${ deptDomain.loc }"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>