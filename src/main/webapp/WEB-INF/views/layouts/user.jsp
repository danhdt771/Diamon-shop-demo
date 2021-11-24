<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="../user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="Master Page" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css" />" rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link href="<c:url value="/assets/user/font-awesome/css/font-awesome.css" />" rel="stylesheet">
<link rel="shortcut icon" href="<c:url value="/assets/user/ico/favicon.ico" />">
<decorator:head/>
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="<c:url value="/index" />"> <span class="icon-home"></span>
						Home
					</a> 
					<c:if test="${empty customerName_}">
						<a href="<c:url value="/register" />">
						<span class="icon-edit"></span> Free
						Register 
					</a> 
					</c:if>
					<c:if test="${not empty customerName_}">
						<a href="<c:url value="/customer/account" />"><span class="icon-user"></span> ${customerName_}</a> 
						<a href="<c:url value="/logout" />">
							<span class="icon-edit"></span> Logout
						</a> 
					</c:if>
					
					<a href="contact.html">
						<span class="icon-envelope"></span>
						Contact us
					</a> 
					<a href="<c:url value="/shopping-cart"/>">
						<span class="icon-shopping-cart">
						</span>
						<c:if test="${TotalQtyCart > 0}">
							 ${TotalQtyCart} Item(s) - 
							<span class="badge badge-warning"> $${TotalPriceCart}</span></a>
						</c:if>
						<c:if test="${TotalQtyCart == 0 || TotalQtyCart == null}">
							 0 Item(s) - 
							<span class="badge badge-warning"> $0</span></a>
						</c:if>
				</div> 
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
					<!-- 
Header Section 
-->		
		<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
			<!-- 
Body Section 
-->
		<decorator:body/>
		
				<!-- 
Footer Section 
-->	
		<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img src="<c:url value="/assets/user/img/maestro.png" />" alt="payment"></a>
				<a href="#"><img src="<c:url value="/assets/user/img/mc.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/pp.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/visa.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/disc.png" />" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2013<br> bootstrap ecommerce
				shopping template
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/assets/user/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js" />"></script>
	<script src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value="/assets/user/js/shop.js" />"></script>
	
	<decorator:getProperty property="page.script"></decorator:getProperty>
</body>
</html>