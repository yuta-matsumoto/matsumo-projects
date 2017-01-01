<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<title>購入完了画面</title>
<head>
<style type="text/css">
.msg {
	font-size: 3em
}
button.button1 {
	font-size: 1.4em;
	font-weight: bold;
	padding: 10px 30px;
	color: #fff;
	border-style: none;
	box-shadow: 2px 2px 3px 1px #666;
	-moz-box-shadow: 2px 2px 3px 1px #666;
	-webkit-box-shadow: 2px 2px 3px 1px #666;
	text-shadow: 1px 1px 2px #000;
	background: -moz-linear-gradient(bottom, #36d, #248 50%, #36d);
	background: -webkit-gradient(linear, left bottom, left top, from(#36d),
		color-stop(0.5, #248), to(#36d));
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}
h1 {
	font-size: 3em;
	margin: 10px
}
thead {
	background-color: pink
}
tbody {
	background-color: #fff9e5
}
#title {
	font-size: 3em;
	font-family: Impact;
	margin: 10px
}
.all {
	margin-top: 50px;
	margin-bottom: 100px
}
</style>
</head>
<body background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>
	<br>
	<br>
	<br>
	<div align="center">
		<h1>購入完了画面</h1>
		<hr size="10" color="pink" noshade>
		<br> <br> <br> <br>
		<div class="all">
			<s:if test="%{#session.userId!=null}">
			<p class="msg">ご購入ありがとうございます。</p>
			<br>
			<p class="msg">またのご利用お待ちしております。</p>
			<br>
			<table border="0" cellspacing="50">
				<tr>

					<td>
						<s:form action="ReturnTopAction">
							<s:token />
							<button class="button1" type="submit">商品一覧画面へ</button>
						</s:form>
					</td>
					<td>
						<s:form action="LogOutAction">
							<s:token />
							<button class="button1" type="submit">ログアウト</button>
						</s:form></td>
				</s:if>

				<s:else>
				<td><font size="5"  color="red"><b>ログアウトしました。</b></font></td>
				<br><br><br>
					<td>
						<s:form action="ReturnTopAction">
							<s:token />
							<button class="button1" type="submit">商品一覧画面へ</button>
						</s:form>
					</td>
				</s:else>
				</tr>
			</table>
		</div>
	</div>
	<hr size="10" color="pink" noshade>
	<br>
	<br>
	<div align="center">
Copyright(c) 2015 INTERNOUS Travel Ticket All　Rights Reserved
</div>
	<br>
</body>
</html>
