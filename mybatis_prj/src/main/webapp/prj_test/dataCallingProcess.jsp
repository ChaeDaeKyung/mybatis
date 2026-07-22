<%@page import="dataCalling.DataCallingService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

DataCallingService dcs = DataCallingService.getInstance();
pageContext.setAttribute("getParam", dcs.getKey());



%>