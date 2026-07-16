<%@page import="day0716.SelectService2"%>
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
<h2>컬럼하나에 여러행 조회</h2>
<h3>부서번호에 해당하는 사원번호 검색</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>부서번호</label><input type="text" name="deptno"/>
		<input type="text" name="deptno" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	<c:if test="${ not empty param.deptno }">
		<%
		SelectService2 ss = SelectService2.getInstance();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		pageContext.setAttribute("listEmpno",ss.scmr(deptno));
		%>
		<c:out value="${ param.deptno }"/> 번 부서 사원 정보.
		<select name="empno">
		<c:choose>
			<c:when test="${ not empty listEmpno }">
				<c:forEach var="empno" items="${ listEmpno }" varStatus="i">
					<option value="${ empno }"><c:out value="${ i.count }. ${ empno }"/></option>
				</c:forEach>
			</c:when>
			<c:otherwise><option value="none">사원이 존재하지 않습니다.</option></c:otherwise>
		</c:choose>
		</select>
	</c:if>
</div>