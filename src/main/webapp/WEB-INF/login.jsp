<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kakeibo.controller.KakeiboController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common.css">
<title>蔵書管理システム</title>
</head>
<body>
<!--	<br>
	<h2>家計簿アプリ★</h2><br>
	
	
	<spring:url value="/login" var="url" htmlEscape="true" />
	<form:form action="${url}" method="POST">
		<p>
		　ID　　<input type="text" id="userID" name="userID"><br><br>
		PASS　　<input type="password" id="userPassword" name="userPassword">
		</p><br>
		
		<h4 style="color: red">${msg}</h4>
		
		<input type="reset" value="クリア">
		<input type="submit" value="ログイン" />
	</form:form> -->
	
<div class="header"><br/>蔵書管理システム</div>
	<spring:url value="/login" var="url" htmlEscape="true" />
	<form:form action="${url}" method="POST">
		<input type="hidden" name="viewId" value="login">
<!--
<div class="warning" style="display:<%=flagMsg %>"><%=request.getAttribute("Msg") %></div> -->
<table border="0">
<tbody>
   <tr>
     <td><label for="id">ID</label></td>
     <td><input required type="text" name="id"></td>
   </tr>
   <tr>
     <td><label for="pass">パスワード</label></td>
     <td><input required type="password" name="pass"></td>
   </tr>
   <tr>
     <td></td>
     <td></td>
   </tr>
   <tr>
     <td></td>
     <td><input type="submit" name="next" class="Button-style" value="ログイン"></td>
   </tr>
</tbody>
</table>

</form:form>
	
</body>
</html>
