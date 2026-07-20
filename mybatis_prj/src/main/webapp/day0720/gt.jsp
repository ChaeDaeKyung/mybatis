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
<h2>크다의 조회</h2>
<h3>입력한 연봉보다 많이 받는 사원의 사원정보 검색</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>연봉</label><input type="text" name="sal"/>
		<input type="text" name="sal" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	<c:if test="${ not empty param.sal }">
		<%
		SelectService3 ss = SelectService3.getInstance();
		int sal = Integer.parseInt(request.getParameter("sal"));
		pageContext.setAttribute("list",ss.greaterThan(sal));
		%>
		연봉 : <strong><c:out value="${ param.sal }"/></strong><br>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>사원번호</th>
					<th>사원명</th>
					<th>연봉</th>
					<th>입사일</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${ empty list }">
				<tr>
					<td colspan="5" style="text-align: center;">해당 사원은 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="empDomain" items="${ list }" varStatus="i">
			<tr>
				<td><c:out value="${ i.count }"/></td>
				<td><c:out value="${ empDomain.empno }"/></td>
				<td><c:out value="${ empDomain.ename }"/></td>
				<td><fmt:formatNumber value="${ empDomain.sal }" pattern="###,###,###,###"/></td>
				<td><fmt:formatDate value="${ empDomain.hiredate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>