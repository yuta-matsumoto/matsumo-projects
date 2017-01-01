<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<TITLE>登録完了画面</TITLE>
<STYLE type="text/css">
h1 {
	font-size: 3em;
	margin: 10px
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

.all {
	margin-top: 50px;
	margin-bottom: 80px
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
</STYLE>
</HEAD>
<BODY background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>
	<div align="center">
		<h1>登録完了</h1>
	</div>
	<br>
	<hr size="10" color="pink" noshade>
	<div class="all">
		<P align="center">
			<BR> <FONT size="+2">登録ありがとうございました。</FONT>
		</P>
		<br>
		<div align="center">
			<table border="0">
				<tr>
					<td><s:form action="GoToPayOffAction">
							<s:token />
							<button class="button1" type="submit">購入手続きへ進む</button>
						</s:form></td>
				</tr>
			</table>
		</div>
	</div>
	<hr size="10" color="pink" noshade>
	<div align="center">
		<p>Copyright(c) 2015 INTERNOUS Travel Ticket All Rights Reserved</p>
	</div>
</BODY>
</HTML>