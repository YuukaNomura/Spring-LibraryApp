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
<title>蔵書管理システム</title>

	<style>
html {
    width: 100%;
    min-height: 100%;
}
body {
    background-color: #F8DAD2; /*一斤染*/
    font-family: 'メイリオ', 'Meiryo', 'ヒラギノ角ゴ Pro W3', 'Hiragino Kaku Gothic Pro', 'Osaka', 'ＭＳ Ｐゴシック', 'MS PGothic', 'sans-serif';
}
.header{
	background-color:#D9759C; /*槿毛色*/
	color: #FFFFFF;
	font-size:25px;
}
.headerTable{
	background-color:#D9759C; /*槿毛色*/
	color: #FFFFFF;
}
.headButton{
background-color:#D9759C; /*槿毛色*/
	font-size:5px;
}
.warning{
	color: red;
}
.sub{
	font-size:20px;
}
.Button-style {
font-size: 15px;
display: inline-block;
padding: 0.4em 1em 0.2em;
color: #ffffff;
border: #ffffff dashed 1px;
box-shadow: 0 0 0 0.2em #D9759C;/*元の色:#ff99cc*/
border-radius: 2.5px;
background-color: #D9759C;
cursor: pointer;
}
.Button-style-logout {
font-size: 12px;
display: inline-block;
padding: 0.4em 1em 0.2em;
color: #ffffff;
border: #ffffff dashed 1px;
box-shadow: 0 0 0 0.2em #D9759C;
border-radius: 2.5px;
background-color: #D9759C;
cursor: pointer;
}
table.searchResult{
  /*margin:0 auto;*/
  border-radius:10px;
  -webkit-border-radius:10px;
  -moz-border-radius:10px;
  border:1px solid #D9759C;
  border-spacing: 0;
  font-size: 11pt;
  overflow:hidden;
}
td.searchResult,th.searchResult{
  border-bottom:1px solid #D9759C;
}
td.searchResult,th.searchResult{
  padding:10px;
}
th.searchResult{
  background:#FFF4F6;
  text-align:left;
  font-weight: normal;
}
td.searchResult{
  background:#E8B2B7;
  text-align:left;
  font-weight: bold;
}
table tbody tr:last-child th.searchResult,
table tbody tr:last-child td.searchResult{
  border-bottom: none;
}
th.searchResult,td.searchResult{
  border-left:1px solid #D9759C;
}
th.searchResult:first-child, td.searchResult:first-child{
  border-left:none;
}
	
	
	</style>

      
</head>
<body>

<div class="headButton" align="right">
<br/>

<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">
<input type="submit" class="Button-style-logout" value="ログアウト">
</form:form>&nbsp;</div>
<div class="header">操作選択</div>

<p>ログイン： <%=session.getAttribute("LoginUserName")%>さん</p>
	
<table border="0">
<tbody>
   <tr>
     <td><div class="sub">蔵書管理</div></td>
   <tr>
   <tr>
     <td></td>
     <td>
<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">	     
        <input type="submit" class="Button-style" value="　　検索　　">
        </form:form>
     </td>
   </tr>
   <tr>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td></td>
     <td>
<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">	     
        <input type="submit" class="Button-style" value="　　登録　　">
        </form:form>
   </tr>
   <tr>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td><div class="sub">ユーザ管理</div></td>
   </tr>
   <tr>
     <td></td>
     <td>
<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">	     
        <input type="submit" class="Button-style" value="　　登録　　">
        </form:form>
   </tr>
   <tr>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td></td>
     <td>
<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">	     
        <input type="submit" class="Button-style" value="  更新・削除  ">
        </form:form>
   </tr>
</tbody>
</table>

	
	
<!--
<spring:url value="/logout" var="url" htmlEscape="true" />
<form:form action="${url}" method="GET">
	<input type="submit" name="logout" value="ログアウト">
</form:form><br>

		<a href ="/kakeibo/input">実績額入力</a><br>
		<a href ="/kakeibo/search">実績額検索</a><br>
		<a href ="/kakeibo/inputBudget">目標額入力</a><br>
		<a href ="/kakeibo/searchBudget">目標額と実績額の比較</a><br>


		<h2>実績額の入力</h2><br>

		<spring:url value="/input" var="url" htmlEscape="true" />
		<form:form action="${url}" method="POST">
		
		<select name="categoryID">
			<c:forEach var="category" items="${categoryList}">
				<option id="categoryID" name="categoryID" value="${category.categoryID}">${category.categoryName}</option>
			</c:forEach>
		</select>

			<br><br>
			　　金額　(半角数字)　<input type="text" id="amount" name="amount"><br><br>
			　　日付　(半角数字)　<input type="text" id="date" name="date"><br>

			<h4 style="color: red">${msg}<br></h4>

			<input type="reset" value="クリア">
			<input type="submit" value="確認">
		</form:form>
-->
</body>
</html>
