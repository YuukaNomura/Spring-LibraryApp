<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kakeibo.controller.KakeiboController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>

<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">
	<input type="submit" name="logout" value="ログアウト">
</form:form><br>

		<a href ="/kakeibo/input">実績額入力</a><br>
		<a href ="/kakeibo/search">実績額検索</a><br>
		<a href ="/kakeibo/inputBudget">目標額入力</a><br>
		<a href ="/kakeibo/searchBudget">目標額と実績額の比較</a><br>
		
		<h2>目標額と実績額の比較</h2><br>
		
		
		<spring:url value="/searchBudget" var="url" htmlEscape="true" />
		<form:form action="${url}" method="POST">
		
		　　日付　(半角数字)　<input type="text" id="date" name="date"><br><br>
		
		<h4 style="color: red">${msg}</h4>

			<input type="reset" value="クリア">
			<input type="submit" value="検索">

		</form:form>
		
		
</body>
</html>