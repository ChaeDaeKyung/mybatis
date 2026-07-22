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
<h2>dynamicIf의 사용</h2>
<h3>부서번호에 따라 전체 사원 조회 또는 부서별 사원 조회</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>부서번호</label>
		<select name="deptno">
			<option value="0">모든 부서</option>
			<option value="10"${ param.deptno eq "10" ? " selected='selected'":"" }>10번 부서</option>
			<option value="20"${ param.deptno eq "20" ? " selected='selected'":"" }>20번 부서</option>
			<option value="30"${ param.deptno eq "30" ? " selected='selected'":"" }>30번 부서</option>
		</select>
		<input type="text" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	
	<jsp:useBean id="cdDTO" class="day0714.CpDept" scope="page"/>
	<jsp:setProperty property="*" name="cdDTO"/>
	
	<c:if test="${ not empty param.deptno }">
		<%
		SelectService5 ss = SelectService5.getInstance();
		pageContext.setAttribute("list",ss.dynamicIf(cdDTO));
		%>
		검색어 : <strong><c:out value="${ param.deptno }"/></strong><br>
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