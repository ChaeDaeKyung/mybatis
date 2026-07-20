<%@page import="kr.co.sist.emp.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day0720.SelectService3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
SelectService3 ss = SelectService3.getInstance();
List<EmpDomain> list = ss.mcmr();
pageContext.setAttribute("list", list);
%>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직무</th>
			<th>매니저번호</th>
			<th>Date 입사일</th>
			<th>문자열 입사일</th>
			<th>연봉</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${ empty list }">
			<tr>
				<td colspan="10">사원 정보가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="empDomain" items="${ list }" varStatus="i">
			<tr>
				<td><c:out value="${ i.count }"/></td>
				<td><c:out value="${ empDomain.empno }"/></td>
				<td><c:out value="${ empDomain.ename }"/></td>
				<td><c:out value="${ empDomain.job }"/></td>
				<td><c:out value="${ empDomain.mgr }"/></td>
				<td>
					<fmt:formatDate value="${ empDomain.hiredate }" pattern="MM-dd-yyyy"/><br>
					<fmt:formatDate value="${ empDomain.hiredate }" pattern="yyyy-MM-dd EEEE"/>
				</td>
				<td><c:out value="${ empDomain.hiredateStr }"/></td>
				<td><c:out value="${ empDomain.sal }"/></td>
				<td><c:out value="${ empDomain.comm }"/></td>
				<td><c:out value="${ empDomain.deptno }"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>