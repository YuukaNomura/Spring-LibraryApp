<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kakeibo.controller.KakeiboController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="common.css" type="text/css">

	<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common.css"> -->
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
