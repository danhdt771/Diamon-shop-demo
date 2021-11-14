<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/" />"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png" />"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Twitter Bootstrap shopping cart HTML
					template is available @ $14
				</h1>
			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Support (24/7) : 0800 1234 678 </strong><br>
				<br>
			</p>
			<a href="<c:url value="/shopping-cart" />" class="btn btn-mini">[ 
			<c:if test="${TotalQtyCart > 0}">
				 ${TotalQtyCart}
			</c:if>
			<c:if test="${TotalQtyCart == 0 || TotalQtyCart == null}">
				0
			</c:if> 
			] 
			<span
				class="icon-shopping-cart"></span></a> <span
				class="btn btn-warning btn-mini">$</span> <span class="btn btn-mini">&pound;</span>
			<span class="btn btn-mini">&euro;</span>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="menu" items="${menus}" varStatus="index">
						<c:if test="${index.first}">
							<li class="active">
						</c:if>
						<c:if test="${not index.first}">
							<li class="">
						</c:if>
						<a href="/Diamond/${menu.url}">${menu.name} </a></li>
					</c:forEach> 
				</ul>
				<ul class="nav pull-right">
					<c:if test="${not empty userName }">
						<li class="dropdown"><a href="#"><span class="icon-user"></span>
								${userName} <b class="caret"></b></a>
						</li>
					</c:if>
					<c:if test="${empty userName }">
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"><span class="icon-lock"></span>
								Login <b class="caret"></b></a>
							<div class="dropdown-menu">
								<form:form class="form-horizontal loginFrm" action="perform_login" modelAttribute="user" method="POST"> 
									<div class="control-group">
										<form:input required="required"  id="inputEmail" class="span2" placeholder="Email" type="email" path="userName" />
									</div>
									<div class="control-group">
										<form:input required="required" id="inputPassword" class="span2" placeholder="Password" type="password" path="password" />
									</div>
									<div class="control-group">
										<label class="checkbox"> <input type="checkbox">
											Remember me
										</label>
										<button type="submit" class="shopBtn btn-block">Sign
											in</button>
									</div>
								</form:form>
							</div>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>