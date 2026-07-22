<%@page import="day0721.SearchCarService"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
String country = request.getParameter("country");
SearchCarService scs = SearchCarService.getInstance();
out.print(scs.searchMaker(country));

%>