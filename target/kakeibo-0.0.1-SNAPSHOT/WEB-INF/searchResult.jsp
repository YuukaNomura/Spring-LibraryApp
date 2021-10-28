<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kakeibo.controller.KakeiboController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link rel="stylesheet" href="styles.css" type="text/css">
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


	<h2>検索結果</h2>
	
	<p>日付<br>
	${performance.date}</p>
	
	<table>
		<tr><th>カテゴリー</th><th>金額</th><th>変更・削除</th></tr>
	
	<c:forEach var="pf" items="${performanceForm}">
		<tr><td>${pf.categoryName}</td><td>${pf.amount}</td>
		<td>
		<spring:url value="/change1" var="url" htmlEscape="true" />
		<form:form action="${url}" method="POST">
			<input type="hidden" id="performanceID" name="performanceID" value="${pf.performanceID}">
			<input type="submit" value="変更">
		</form:form>
		
		<spring:url value="/delete" var="url" htmlEscape="true" />
		<form:form action="${url}" method="POST">
			<input type="hidden" id="performanceID" name="performanceID" value="${pf.performanceID}">
			<input type="submit" value="削除">
		</form:form>
		
		</td></tr>
	</c:forEach>
	</table>

</body>
</html>