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
<title>変更入力画面</title>
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
	
	
	
	<h2>変更内容の入力</h2><br>
	
	<spring:url value="/change2" var="url" htmlEscape="true" />
	<form:form action="${url}" method="POST">

		<select name="categoryID">
			<c:forEach var="category" items="${categoryList}">
				<option id="categoryID" name="categoryID" value="${category.categoryID}" <c:if test="${category.categoryID == performance.categoryID}"> selected </c:if>>${category.categoryName}</option>
			</c:forEach>
		</select><br><br>

		金額　<input type="text" id="amount" name="amount" value="${performance.amount}" >
		日付　<input type="text" id="date" name="date" value="${performance.date}" >
		<input type="hidden" id="performanceID" name="performanceID" value="${performance.performanceID}">
		
		<h4 style="color: red">${msg}<br></h4>

		<input type="reset" value="クリア">
		<input type="submit" value="確認">
	
	</form:form>

</body>
</html>