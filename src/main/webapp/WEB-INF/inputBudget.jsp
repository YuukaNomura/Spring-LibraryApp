<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kakeibo.controller.KakeiboController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目標額入力画面</title>
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
		
		
	<h2>目標額の入力</h2><br>
		
	<spring:url value="/inputBudget" var="url" htmlEscape="true" />
	<form:form action="${url}" method="POST">
		
		日付　(半角数字)　<input type="text" id="date" name="date"><br><br>
		
		【支出】<br>
		食費　　　　<input type="text" id="amount" name="amount"><br>
		日用品　　　<input type="text" id="amount" name="amount"><br>
		住宅費　　　<input type="text" id="amount" name="amount"><br>
		水道光熱費　<input type="text" id="amount" name="amount"><br>
		被服費　　　<input type="text" id="amount" name="amount"><br>
		交通費　　　<input type="text" id="amount" name="amount"><br>
		交際費　　　<input type="text" id="amount" name="amount"><br>
		医療費　　　<input type="text" id="amount" name="amount"><br>
		その他　　　<input type="text" id="amount" name="amount"><br><br>

		【収入】<br>
		給与　　　　<input type="text" id="amount" name="amount"><br>
		その他　　　<input type="text" id="amount" name="amount"><br><br>

		<span class="submit"><input type="reset" value="クリア"></span>　　
		<span class="submit"><input type="submit" value="確認"></span>
	</form:form>
		
</body>
</html>