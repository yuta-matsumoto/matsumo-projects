<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.errorMessage {
	color: red;
	font-size: small;
}

.all {
	margin-top: 50px;
	margin-bottom: 100px
}

#title {
	font-size: 3em;
	font-family: Impact;
	margin: 10px
}

h1 {
	font-size: 3em;
	margin: 20px
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

table {
	border-spacing: 0px 20px
}

th {
	font-size: 1.5em
}

#logbtn {
	float: left;
	padding-top: 50px;
	padding-left: 113px;
	padding-top: 80px;
	margin-right: 200px
}

#sinki {
	margin-top: 27px;

}

#table {
	margin-left: 400px
}

#sinki2 {
	margin-top: 30px;
	margin-left: 20px
}

button.button2 {
	font-size: 1.4em;
	font-weight: bold;
	padding: 10px 50px;
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

.mongon  {font-size:1.5em;
          text-align:left}
</style>
<title>ログイン画面</title>
</head>

<body background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>
	<div align="center">
		<h1>ログイン</h1>
	</div>
	<hr size="10" color="pink" noshade>
	<div class="all">
		<br> <br> <br> <br>
		<div id="table">
			<s:form action="LoginAction">
			<s:token />
				<p>
					<font color="red"><s:property value="errorMsg" /></font>
				</p>
				<table border="0">
					<TBODY>

						<tr>
							<th class="mongon">ユーザID</th>
							<td><s:textfield name="user_id"  maxlength="8" /></td>
						</tr>
						<tr>
							<th class="mongon">パスワード</th>
							<td><s:textfield name="user_pass" type="password" maxlength="16" /></td>
						</tr>

					</TBODY>
				</table>
				<p id="logbtn">
					<button class="button2" type="submit">ログイン</button>
				</p>
			</s:form>
		</div>


		<div id="sinki">
			<table>
				<tr>
					<td><B><font size="4" color=red>※会員登録がお済でない方はこちら</font></B>
						<div id="sinki2">
							<s:form action="GoToCreateAction">
								<s:token />
								<button class="button1" type="submit">新規会員登録</button>
							</s:form>
						</div>
						</td>
				</tr>
			</table>
		</div>
	</div>
	<hr size="10" color="pink" noshade>
	<div align="center">
		<p>Copyright(c) 2015 INTERNOUS Travel Ticket All Rights Reserved</p>
	</div>
</body>
</html>
