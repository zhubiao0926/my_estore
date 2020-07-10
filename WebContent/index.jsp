<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<!-- 引入header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>

	<!--文件体开始-->

	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="middle"> <a href=index.jsp>杰普电子商务门户</a> → <img
				border="0" src="images/dog.gif" width="19" height="18"> 欢迎<font
				color="red"></font>光临！</td>
		</tr>
	</table>
	<br>

	<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>

		
		<c:forEach var="i" items="${applicationScope.products }">
			<tr>
			<td class=tablebody2 valign=middle align=center width="">${i.key }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a
				href="ProductDetailSer?productid=${i.key }">${i.value.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${i.value.baseprice }</td>
			<td class=tablebody1 valign=middle align=center width=""><a
				href="AddProductSer?productid=${i.key }"> <img border="0" src="images/car_new.gif"
					width="97" height="18"></a></td>
			</tr>
		</c:forEach>



	</table>
	<!--文件尾开始-->
	<!-- 引入footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>