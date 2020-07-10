<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>






<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath%>" />
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="杰普电子商务门户">
<title>杰普电子商务门户</title>
<LINK href="css/main.css" rel=stylesheet>
<script language="JavaScript" src="js/main.js"></script>
</head>
<body
	onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','images/top/topxmas/jp_on.gif','images/top/topxmas/download_on.gif','images/top/topxmas/bbs_on.gif','images/top/topxmas/designwz_on.gif')"
	topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<jsp:include page="../header.jsp"></jsp:include>



	<!--文件体开始-->

	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="middle"> <a href=index.html>杰普电子商务门户</a> → <a
				href="user/order.jsp">定单列表</a> → 定单明细</td>
		</tr>
	</table>
	<br>

	<form name="order" method="post" action="saveOrder.action" >
	<table cellpadding="3" cellspacing="1" align="center"
		class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25"
				background="images/bg2.gif"><font color="#ffffff"><b>用户信息</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${requestScope.order.user.userid }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${requestScope.order.user.street1 }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${requestScope.order.user.zip }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>家庭电话</b>：</td>
			<td class="tablebody1">${requestScope.order.user.homephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>办公室电话</b>：</td>
			<td class="tablebody1">${requestScope.order.user.officephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${requestScope.order.user.cellphone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${requestScope.order.user.email }</td>
		</tr>
	</table>
	<br>
	<!--文件尾开始-->
	<table cellpadding="3" cellspacing="1" align="center"
		class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25"
				background="images/bg2.gif"><font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"></td>
			<td width="60%" class="tablebody1">${requestScope.order.payway.paystyle }</td>
		</tr>
	</table>
	<br>
	<table cellpadding=3 cellspacing=1 align=center class=tableborder1
		id="table3">
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif"
				colspan="5"><font color="#ffffff"><b>商品购物清单</b></font></td>
		</tr>
	<c:forEach var="i" items="${requestScope.orderlines }">
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${i.product.productid }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a
				href="productDetail.jsp?productid=2" target="_blank">${i.product.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">价格：${i.product.baseprice }</td>
			<td class=tablebody1 valign=middle align=center width="">数量：${i.amount }</td>
			<td class=tablebody2 valign=middle align=left width="">小计：${i.amount*i.product.baseprice }</td>
		</tr>
	</c:forEach>
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4"></td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font
				color="#ff0000"><b>￥${requestScope.order.cost }</b></font></td>
		</tr>
	</table>
	</form>
	<br>
	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
