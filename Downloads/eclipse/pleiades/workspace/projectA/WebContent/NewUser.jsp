<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<HTML>
<HEAD>
<link rel="shortcut icon" type="favicon.ico" href="favicon.ico">
<!--
<script charset="UTF-8” src="http://ajaxzip3.googlecode.com/svn/trunk/ajaxzip3/ajaxzip3.js" ></script>
-->
<script charset="UTF-8" src="ajaxzip3.js"></script>

<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<style type="text/css">
li span {
	color: red;
}

li {
	list-style-type: none;
}

.list {
	list-style-type: disc
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
	text-align: center
}

button.button2 {
	font-size: 1.4em;
	font-weight: bold;
	padding: 10px 63px;
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
	text-align: center
}

.all {
	margin-top: 50px;
	margin-bottom: 100px
}

.koumoku {
	float: left;
	margin-left: 20%;
	text-align: left;
	width: 280px;
	height: 30px;
	font-weight: bold
}

.form {
	text-align: left;
}
</style>
<META name="GENERATOR"
	content="IBM HomePage Builder 2001 V5.0.2 for Windows">
<TITLE>新規会員登録</TITLE>
<script type="text/javascript">
	function generateDay(f) {
		var y = document.getElementById(f + '_year').options[document
				.getElementById(f + '_year').selectedIndex].text;
		var m = document.getElementById(f + '_month').options[document
				.getElementById(f + '_month').selectedIndex].text;

		if (2 == m && (0 == y % 400 || (0 == y % 4 && 0 != y % 100))) {
			var last = 29;
		} else {
			var last = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)[m - 1];
		}

		obj = document.getElementById(f + '_day');
		obj.length = 0;

		for (var i = 0; i < last; i++) {
			obj.options[obj.length++] = new Option(i + 1, i + 1);
		}
	}
</script>
</HEAD>
<body background="image\bk.gif">
	<p id="title">
		<span style="color: blue">T</span>ravel <span style="color: red">T</span>icke<span
			style="color: yellow">t</span>
	</p>
	<H1 align="center">
		新規会員登録 <BR>
	</H1>

	<hr size="10" color="pink" noshade>
	<div class="all">
		<br>

		<div align="center">
			<p>
				<font color="red" size="3"><s:property value="msg" />
				<s:property value="msg2" />
				<s:property value="msg3" />
				</font>
			</p>
		</div>

		<s:form action="NewUserAction">
			<br>

			<div class="koumoku">氏名</div>
			<div class="form">
				<INPUT type="text" name="last_name" size="20" maxlength="16"
					placeholder="例)佐藤" /> <INPUT type="text" name="first_name"
					size="20" maxlength="16" placeholder="裕也" />

				<center>
					<s:fielderror>
						<s:param value="%{'last_name'}" />
					</s:fielderror>
				</center>
				<center>
					<s:fielderror>
						<s:param value="%{'first_name'}" />
					</s:fielderror>
				</center>
			</div>

			<br>
			<div class="koumoku">郵便番号</div>
			<div class="form">
				<input type="text" name="postal1" size="2" maxlength="3"
					placeholder="例)151"> － <input type="text" name="postal2"
					size="3" maxlength="4" placeholder="0051"
					onKeyUp="AjaxZip3.zip2addr('postal1','postal2','addr1','addr2');"><font
					size="2" color=red> ※正しい郵便番号を記入すると住所が自動で出ます</font>

				<center>
					<s:fielderror>
						<s:param value="%{'postal1'}" />
					</s:fielderror>
				</center>

				<center>
					<s:fielderror>
						<s:param value="%{'postal2'}" />
					</s:fielderror>
				</center>
			</div>
			<br>
			<div class="koumoku">住所</div>
			<div class="form">
				<input type="text" id="addr1" name="addr1" size="6"
					readonly="readonly" /> <input type="text" name="addr2" size="30"
					readonly="readonly" /> <input type="text" name="addr3"
					maxlength="27" size="30" placeholder="例)123-4" />

				<center>
					<s:fielderror>
						<s:param value="%{'addr1'}" />
					</s:fielderror>
				</center>

				<center>
					<s:fielderror>
						<s:param value="%{'addr2'}" />
					</s:fielderror>
				</center>

				<center>
					<s:fielderror>
						<s:param value="%{'addr3'}" />
					</s:fielderror>
				</center>
			</div>

			<br>
			<div class="koumoku">アドレス</div>
			<div class="form">
				<input type="text" size="30" name="user_mail"
					placeholder="例)internous@co.jp" />

				<center>
					<s:fielderror>
						<s:param value="%{'user_mail'}" />
					</s:fielderror>
				</center>
			</div>


			<br>
			<div class="koumoku">性別</div>
			<div class="form">
				<input type="radio" name="gender" value="man">男 <input
					type="radio" name="gender" value="woman">女

				<center>
					<s:fielderror>
						<s:param value="%{'gender'}" />
					</s:fielderror>
				</center>
			</div>


			<br>
			<div class="koumoku">生年月日</div>
			<div class="form">
				<select id="start_year" name="start_year"
					onchange="generateDay('start')">
					<option value="">--</option>
					<option value="2015">2015</option>
					<option value="2014">2014</option>
					<option value="2013">2013</option>
					<option value="2012">2012</option>
					<option value="2011">2011</option>
					<option value="2010">2010</option>
					<option value="2009">2009</option>
					<option value="2008">2008</option>
					<option value="2007">2007</option>
					<option value="2006">2006</option>
					<option value="2005">2005</option>
					<option value="2004">2004</option>
					<option value="2003">2003</option>
					<option value="2002">2002</option>
					<option value="2001">2001</option>
					<option value="2000">2000</option>
					<option value="1999">1999</option>
					<option value="1998">1998</option>
					<option value="1997">1997</option>
					<option value="1996">1996</option>
					<option value="1995">1995</option>
					<option value="1994">1994</option>
					<option value="1993">1993</option>
					<option value="1992">1992</option>
					<option value="1991">1991</option>
					<option value="1990">1990</option>
					<option value="1989">1989</option>
					<option value="1988">1988</option>
					<option value="1987">1987</option>
					<option value="1986">1986</option>
					<option value="1985">1985</option>
					<option value="1984">1984</option>
					<option value="1983">1983</option>
					<option value="1982">1982</option>
					<option value="1981">1981</option>
					<option value="1980">1980</option>
					<option value="1979">1979</option>
					<option value="1978">1978</option>
					<option value="1977">1977</option>
					<option value="1976">1976</option>
					<option value="1975">1975</option>
					<option value="1974">1974</option>
					<option value="1973">1973</option>
					<option value="1972">1972</option>
					<option value="1971">1971</option>
					<option value="1970">1970</option>
					<option value="1969">1969</option>
					<option value="1968">1968</option>
					<option value="1967">1967</option>
					<option value="1966">1966</option>
					<option value="1965">1965</option>
					<option value="1964">1964</option>
					<option value="1963">1963</option>
					<option value="1962">1962</option>
					<option value="1961">1961</option>
					<option value="1960">1960</option>
					<option value="1959">1959</option>
					<option value="1958">1958</option>
					<option value="1957">1957</option>
					<option value="1956">1956</option>
					<option value="1955">1955</option>
					<option value="1954">1954</option>
					<option value="1953">1953</option>
					<option value="1952">1952</option>
					<option value="1951">1951</option>
					<option value="1950">1950</option>
					<option value="1949">1949</option>
					<option value="1948">1948</option>
					<option value="1947">1947</option>
					<option value="1946">1946</option>
					<option value="1945">1945</option>
					<option value="1944">1944</option>
					<option value="1943">1943</option>
					<option value="1942">1942</option>
					<option value="1941">1941</option>
					<option value="1940">1940</option>
					<option value="1939">1939</option>
					<option value="1938">1938</option>
					<option value="1937">1937</option>
					<option value="1936">1936</option>
					<option value="1935">1935</option>
					<option value="1934">1934</option>
					<option value="1933">1933</option>
					<option value="1932">1932</option>
					<option value="1931">1931</option>
					<option value="1930">1930</option>
					<option value="1929">1929</option>
					<option value="1928">1928</option>
					<option value="1927">1927</option>
					<option value="1926">1926</option>
					<option value="1925">1925</option>
					<option value="1924">1924</option>
					<option value="1923">1923</option>
					<option value="1922">1922</option>
					<option value="1921">1921</option>
					<option value="1920">1920</option>
					<option value="1919">1919</option>
					<option value="1918">1918</option>
					<option value="1917">1917</option>
					<option value="1916">1916</option>
					<option value="1915">1915</option>
					<option value="1914">1914</option>
					<option value="1913">1913</option>
					<option value="1912">1912</option>
					<option value="1911">1911</option>
					<option value="1910">1910</option>
					<option value="1909">1909</option>
					<option value="1908">1908</option>
					<option value="1907">1907</option>
					<option value="1906">1906</option>
					<option value="1905">1905</option>
					<option value="1904">1904</option>
					<option value="1903">1903</option>
					<option value="1902">1902</option>
					<option value="1901">1901</option>
					<option value="1900">1900</option>

				</select> 年 <select id="start_month" name="start_month"
					onchange="generateDay('start')" style="width: 50px;">
					<option value="">--</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select> 月 <select id="start_day" name="start_day">
					<option value="">--</option>
				</select> 日

				<center>
					<s:fielderror>
						<s:param value="%{'start_year'}" />
					</s:fielderror>
				</center>

				<center>
					<s:fielderror>
						<s:param value="%{'start_month'}" />
					</s:fielderror>
				</center>

				<center>
					<s:fielderror>
						<s:param value="%{'start_day'}" />
					</s:fielderror>
				</center>
			</div>

			<br>
			<div class="koumoku">ログインID</div>
			<div class="form">
				<input type="text" name="user_id" maxlength="8">

				<center>
					<s:fielderror>
						<s:param value="%{'user_id'}" />
					</s:fielderror>
				</center>
			</div>

			<br>
			<div class="koumoku">パスワード</div>
			<div class="form">
				<input type="password" name="user_pass" maxlength="16">

				<center>
					<s:fielderror>
						<s:param value="%{'user_pass'}" />
					</s:fielderror>
				</center>
			</div>
			<br>
			<div class="koumoku">確認用パスワード</div>
			<div class="form">
				<input type="password" name="user_pass2" maxlength="16">

				<center>
					<s:fielderror>
						<s:param value="%{'user_pass2'}" />
					</s:fielderror>
				</center>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>

			<div align="center">
				<button class="button2" type="submit">新規登録</button>
			</div>
		</s:form>
		<br> <br>
		<div align="center">
			<s:form action="ReturnTopDeleteCartAction">
				<s:token />
				<button class="button1" type="submit">商品一覧に戻る</button>
			</s:form>
		</div>

	</div>


	<hr size="10" color="pink" noshade>
	<div align="center">
		<p>Copyright(c) 2015 INTERNOUS Travel Ticket All Rights Reserved</p>
	</div>
</body>
</HTML>