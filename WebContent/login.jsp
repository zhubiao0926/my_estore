<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="杰普电子商务门户">
<title>杰普电子商务门户</title>
<LINK href="css/main.css" rel=stylesheet>
<script language="JavaScript" src="js/main.js"></script>
<script type="text/javascript">
var s = "${requestScope.msg}";
if (s.trim().length!=0) {
	alert(s);
}
</script>
</head>
<body
	onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')"
	topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<jsp:include page="header.jsp"></jsp:include>



	<!--文件体开始-->

	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="absmiddle"> <a href=index.jsp>杰普电子商务门户</a> → 用户登录</td>
		</tr>
	</table>
	<br>

	<form action="LoginSer" method=post name="login">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
			<tr>
				<td valign=middle colspan=2 align=center height=25
					background="images/bg2.gif"><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
			</tr>
			<tr>
				<td valign=middle class=tablebody1>请输入您的用户名</td>
				<td valign=middle class=tablebody1><INPUT name=userid type=text>
					&nbsp; <a href="register.jsp">没有注册？</a></td>
			</tr>
			<tr>
				<td valign=middle class=tablebody1>请输入您的密码</td>
				<td valign=middle class=tablebody1><INPUT name=password
					type=password> &nbsp;</td>
			</tr>
			<tr>
				<td valign=middle class=tablebody1></td>
				<td valign=middle class=tablebody1><INPUT name=auto
					type=checkbox value=0> 自动登录</td>
			</tr>
			<tr>
				<td class=tablebody2 valign=middle colspan=2 align=center><input
					type=button value="登 录" onclick="javascript:checkMe()"></td>
			</tr>
		</table>
	</form>
	<!--文件尾开始-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
