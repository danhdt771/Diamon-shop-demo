<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<head>
<title>Checkout</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Fashion</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Watches</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Fine Jewelry</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Fashion Jewelry</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Engagement & Wedding</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Men's Jewelry</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Vintage & Antique</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Loose Diamonds </a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>Loose Beads</a></li>
					<li><a href="products.html"><span
							class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
					<li style="border: 0">&nbsp;</li>
					<li><a class="totalInCart" href="cart.html"><strong>Total
								Amount <span class="badge badge-warning pull-right"
								style="line-height: 18px;">$448.42</span>
						</strong></a></li>
				</ul>
			</div>
		
			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img
					src="<c:url value="assets/user/img/paypal.jpg" />"
					alt="payment method paypal"></a>
			</div>
		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li class="active">Checkout</li>
			</ul>
			<div class="well">
				<h5>PAYMENT INFORMATION</h5>
				<h4 style="color: red">${statusRegister}</h4>
				<br />
				<form:form class="form-horizontal" action="checkout" modelAttribute="Bill" method="POST">
					<div class="control-group">
						<label class="control-label" for="inputName">Name <sup>*</sup>
						</label>
						<div class="controls">
							<form:input required="required" id="inputName" class="span3"
								placeholder="Enter you name" type="text" path="display_name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">E-mail <sup>*</sup>
						</label>
						<div class="controls">
							<form:input required="required" id="inputEmail" class="span3"
								placeholder="Enter your email" type="email" path="user_name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPhone">Phone <sup>*</sup>
						</label>
						<div class="controls">
							<form:input required="required" id="inputPhone" class="span3"
								placeholder="Enter your phone number" type="text" path="phone" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputAddress">Address </label>
						<div class="controls">
							<form:textarea id="inputAddress" row="5" cols="30"
								placeholder="Enter your address" path="address" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputNote">Note <sup>*</sup></label>
						<div class="controls">
							<form:textarea id="inputNote" row="5" cols="30"
								placeholder="Enter your note" path="note" />
						</div>
					</div>
					<div class="controls">
						<button type="submit" class="btn block">Submit</button>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</body>