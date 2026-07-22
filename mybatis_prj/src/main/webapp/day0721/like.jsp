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
<h2>like 조회</h2>
<h3>입력된 문자열을 포함한 제목 검색</h3>
	<form action="index.jsp" id="frm">
		<input type="hidden" name="page" value="${ param.page }"/>
		<label>제목</label><input type="text" name="title"/>
		<input type="text" style="display: none"/>
		<input type="button" value="전송" id="btn"/>
	</form>
	<c:if test="${ not empty param.title }">
		<%
		SelectService4 ss = SelectService4.getInstance();
		String title = request.getParameter("title");
		pageContext.setAttribute("list",ss.like(title));
		%>
		검색어 : <strong><c:out value="${ param.title }"/></strong><br>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>
					<th>IP</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${ empty list }">
				<tr>
					<td colspan="6" style="text-align: center;">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="boardDomain" items="${ list }" varStatus="i">
			<tr>
				<td><c:out value="${ i.count }"/></td>
				<td><c:out value="${ boardDomain.title }"/></td>
				<td><fmt:formatDate value="${ boardDomain.inputDate }" pattern="yyyy-mm-dd"/></td>
				<td><c:out value="${ boardDomain.id }" /></td>
				<td><c:out value="${ boardDomain.ip }"/></td>
				<td><c:out value="${ boardDomain.cnt }"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>