<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>チケット購入画面</title>
<style type="text/css">
#title {
	font-size: 5em;
	font-family: Impact;
	margin: 5px
}

table {
	width: 800;
	height: 571;
}

thead {
	background-color: pink
}

tbody {
	background-color: #fff2b2;
	height: 30px
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
	margin-bottom: 100px
}

button.button2 {
	font-size: 1.4em;
	font-weight: bold;
	padding: 10px 40px;
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

button.button8:hover {
	opacity: 0.8;
}
</style>
</head>
<body background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>

	<h2>ダンガントラベルチケットサイト</h2>
	<div align="right">
		<s:if test="%{#session.userName.isEmpty()==false}">
			<p>
				<b><font size="4"><s:property value="#session.userName" />さんようこそ</font></b>
			</p>
			<s:form action="LogOutAction2">
				<s:token />
				<s:submit value="ログアウト"></s:submit>
			</s:form>
		</s:if>
	</div>
	<hr size="10" color="pink" noshade>

	<div class="all">

		<div align="center">
			<p>
				<b><font color="red" size="4"><s:property
							value="addItemName" /></font></b> <b><font color="red" size="5"><s:property
							value="csrfMsg" /></font></b>
			</p>
		</div>

		<table border="1" align="center">
			<caption>チケット一覧</caption>

			<thead>
				<tr>
					<th width="10%" height="50px">商品番号</th>
					<th>ツアー名</th>
					<th width="20%">金額</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="itemList">
					<tr>
						<th height="50px"><s:property value="ticket_id" /></th>
						<th><s:property value="ticket_name" /></th>
						<td><s:property value="price" /></td>
					</tr>
				</s:iterator>
		</table>
		<br>
		<hr class="border">
		<br>
		<div align="center">
			<p>
				<font color="red"><s:property value="stockCheckMsg" /></font> <font
					color="red"><s:property value="errorMessage" />
					<s:property value="errorMsg" /></font>
				<s:fielderror>
					<s:param value="%{'ticket_idStr'}" />
				</s:fielderror>
			</p>
			<p>番号と購入枚数を入力したのち、「カートに入れる」を押してください</p>
			<p>
				<font color="red">※数字は半角数字のみ入力可能です</font>
			</p>
			<s:form action="CartAddAction">
				<s:token />
				<p>
					・商品番号<br> <input type="text" name="ticket_idStr" maxlength="2"
						size="2">
				</p>

				<p>
					・購入希望枚数<br>
				<div align="center">
					<input type="text" name="ticket_countStr" maxlength="2" size="2">
				</div>


				<br>
				<br>
				<button class="button1" type="submit">カートに入れる</button>
			</s:form>
			<br> <br>

			<s:form action="GoToCartAction">
				<button class="button2" type="submit">カートに進む</button>
			</s:form>
			<br>
			<p>
				<font color="red">※本サイトはブラウザバックによる画面遷移はセキュリティ上不正遷移として処理します。</font>
			</p>
		</div>
	</div>


	<hr size="10" color="pink" noshade>
	<div align="center">
		<p>Copyright(c) 2015 INTERNOUS Travel Ticket All Rights Reserved</p>
	</div>

</body>
</html>