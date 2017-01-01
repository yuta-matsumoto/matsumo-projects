<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート内容</title>
<link rel="stylesheet" type="text/css" href="style.css">
<TITLE>カート画面</TITLE>
<STYLE type="text/css">
.all {
	margin-top: 50px;
	margin-bottom: 100px
}

#title {
	font-size: 3em;
	font-family: Impact;
	margin: 10px
}

TABLE {
	width: 800;
	height: 400;
}

td {
	text-align: right;
	vertical-align: bottom;
	font-size: 20px
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

.btnContainer {
	margin: 0px auto;
	letter-spacing: 50px;
	text-align: center
}

.btn {
	float: left;
	margin-left: 50px
}
</STYLE>

</head>
<BODY background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>
	<H1 align="center">
		カート<BR>
	</H1>
	<hr size="10" color="pink" noshade>
	<div class="all">
		<BR>
		<div align="center">
			<s:if test="%{#session.cartList==null}">
				<p>
					<b><font size="5" color="red"><s:property
								value="errorMsg" /></font></b>
				</p>
				<table border="0" cellspacing="50">
					<tr>
						<td><s:form action="ReturnTopAction">
								<button class="button1" type="submit">商品一覧に戻る</button>
							</s:form></td>
					</tr>
				</table>
			</s:if>
			<s:else>
				<TABLE border="1" align="center">
					<thead>
						<TR>
							<TH width="500px">ツアー名</TH>
							<TH width="50px">枚数</TH>
							<TH width="150">小計(円)</TH>
						</TR>
					</thead>
					<TBODY>
						<s:iterator value="#session.cartList">
							<TR>
								<TH><s:property value="ticket_name" /></TH>
								<TH><s:property value="ticket_count" />枚</TH>
								<td><s:property value="total_amount" />円</td>
							</TR>
						</s:iterator>
						<TR>
							<TH>合計</TH>
							<TH><s:property value="#session.total_ticket" />枚</TH>
							<td><s:property value="#session.total_yen" />円</td>
						</TR>
					</TBODY>
				</TABLE>
				<BR>
				<BR>
				<BR>
				<BR>
				<BR>
				<div align="center">
					<table border="0" cellspacing="50">
						<tr>
							<td><s:form action="ReturnTopAction">
									<button class="button1" type="submit">商品一覧に戻る</button>
								</s:form></td>
							<td><s:form action="DeleteCartAction">
									<button class="button1" type="submit">カートを空にする</button>
								</s:form></td>
							<td><s:form action="GoToLoginAction">
									<s:token />
									<button class="button1" type="submit">商品購入手続きへ</button>
								</s:form></td>
						</tr>
					</table>
				</div>
			</s:else>
		</div>
	</div>
	<hr size="10" color="pink" noshade>
	<div align="center">
		<p>Copyright(c) 2015 INTERNOUS Travel Ticket All Rights Reserved</p>
	</div>
</BODY>
</html>