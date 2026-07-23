<%@page import="java.util.List"%>
<%@page import="day0723.SelectService6"%>
<%@page import="day0714.CpDept"%>
<%@page import="day0722.SelectService5"%>
<%@page import="day0721.SelectService4"%>
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
<h2>dynamicEach의 사용</h2>
<h3>선택한 사원 조회</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<input type="hidden" name="flag" value="${ param.flag }"/>
		<label>사원번호</label>
		<%
		SelectService6 ss = SelectService6.getInstance();
		List<Integer> list = ss.selectAllEmpno();
		pageContext.setAttribute("list", list);
		%>
		<c:forEach var="empno" items="${ list }" varStatus="i">
			<input type="checkbox" name="empno" value="${ empno }"/>
			<c:out value="${ i.count }. ${ empno }"/>
		</c:forEach>
		
		
		<input type="text" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	
	<c:if test="${ not empty param.empno }">
		<%
		pageContext.setAttribute("list", ss.selectEmp(request.getParameterValues("empno")));
		%>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>사원번호</th>
					<th>사원명</th>
					<th>부서번호</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${ empty list }">
				<tr>
					<td colspan="6" style="text-align: center;">사원 정보가 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="empDomain" items="${ list }" varStatus="i">
			<tr>
				<td><c:out value="${ i.count }"/></td>
				<td><c:out value="${ empDomain.empno }"/></td>
				<td><c:out value="${ empDomain.ename }"/></td>
				<td><c:out value="${ empDomain.deptno }"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>