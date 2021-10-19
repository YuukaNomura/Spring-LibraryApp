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
	${date}</p>
	
	
	<table>
		<tr><th>カテゴリー</th><th>目標額</th><th>実績額</th></tr>
			<c:forEach var="bf" items="${bf}">
				<tr><td>${bf.categoryName}</td><td>${bf.budgetAmount}円</td><td>${bf.performanceAmount}円</td></tr>
			</c:forEach>
	</table>
	<br><br>
	
	
	<table>
		<tr><th>目標額　合計</th><th>実績額　合計</th></tr>
		<tr><td>支出　${cf.budgetExpensesTotalAmount}円</td><td>支出　${cf.performanceExpensesTotalAmount}円</td></tr>
		<tr><td>収入　${cf.budgetIncomesTotalAmount}円</td><td>収入　${cf.performanceIncomesTotalAmount}円</td></tr>
		<tr><td>貯金額　${cf.budgetSavings}円</td><td>貯金額　${cf.performanceSavings}円</td></tr>
	</table>

</body>
</html>