<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kakeibo.controller.KakeiboController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="styles.css" type="text/css">
</head>
<body>
	<br>
	<h2>家計簿アプリ</h2><br>
	
	
	<spring:url value="/login" var="url" htmlEscape="true" />
	<form:form action="${url}" method="POST">
		<p>
		　ID　　<input type="text" id="userID" name="userID"><br><br>
		PASS　　<input type="password" id="userPassword" name="userPassword">
		</p><br>
		
		<h4 style="color: red">${msg}</h4>
		
		<input type="reset" value="クリア">
		<input type="submit" value="ログイン" />
	</form:form>
	
</body>
</html>