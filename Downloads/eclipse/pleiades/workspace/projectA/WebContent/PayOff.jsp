<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<TITLE>購入確定画面</TITLE>
<STYLE type="text/css">
#title {
	font-size: 3em;
	font-family: Impact;
	margin: 10px
}

table {
	width: 800;
	height: 571;
}

thead {
	background-color: pink
}

tbody {
	background-color: #fff9e5
}

td {
	text-align: right;
	vertical-align: bottom;
	font-size: 20px
}

#caption {
	font-size: 30px;
	text-align: center
}

#welcome {
	padding-right: 20px
}

#title {
	font-size: 3em;
	font-family: Impact;
	margin: 10px;
}

.all {
	margin-top: 50px;
	margin-bottom: 100px
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
	margin: 20px
}
</STYLE>
</HEAD>
<BODY background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>

	<div align="center">
		<h1>購入確定画面</h1>
	</div>
	<BR>
	<hr size="10" color="pink" noshade>
	<div class="all">

		<TABLE border="1" align="center">

			<thead>
				<tr>
					<th width="500px">ツアー名</th>
					<th width="50px">枚数</th>
					<th width="150">金額</th>
				</tr>
			</thead>

			<s:iterator value="payOffList">
				<TBODY>
					<TR>
						<TH><s:property value="ticket_name" /></TH>
						<td><s:property value="ticket_count" />枚</td>
						<td><s:property value="total_amount" />円</td>
					</TR>
			</s:iterator>

			<TR>
				<TH>合計</TH>
				<td><s:property value="total_ticket" />枚</td>
				<td><s:property value="total_yen" />円</td>
			</TR>
			</TBODY>
		</TABLE>

		<br> <br>
		<div align="center">
			<table border="0" cellspacing="50">
				<tr>
					<td><s:form action="ReturnTopDeleteCartAction">
							<s:token />
							<button class="button1" type="submit">商品一覧に戻る</button>
						</s:form></td>
					<td><s:form action="PayOffAction">
							<s:token />
							<button class="button1" type="submit">購入確定</button>
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

