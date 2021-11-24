<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<head>
<title>Register</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="category" items="${categories}">
						<li><a href="<c:url value='/products/${category.id}'/>"><span
							class="icon-chevron-right"></span>${category.name}</a></li>
					</c:forEach>
					<li><a class="totalInCart" href="<c:url value="/shopping-cart"/>"><strong>Total
								Amount <c:if test="${TotalQtyCart > 0}">
											<span class="badge badge-warning pull-right"
													style="line-height: 18px;">$${TotalPriceCart}</span>
											</strong></a>
										</c:if>
										<c:if test="${TotalQtyCart == 0 || TotalQtyCart == null}">
											<span class="badge badge-warning pull-right"
													style="line-height: 18px;">$0</span>
											</strong></a>
										</c:if>
					</li>
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

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="<c:url value='/product-details/10'/>"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="<c:url value="assets/user/img/bootstrap-ecommerce-templates.PNG" />"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="<c:url value='/product-details/10'/>">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li class="active">Login</li>
			</ul>
			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>CREATE YOUR ACCOUNT</h5>
						<div id="error" style="color: red">${email_exists}</div><br>
						<h4 style="color:red">${statusRegister}</h4>
						<br />
						<form:form action="register" modelAttribute="user" method="POST">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail <sup>*</sup>
								</label>
								<div class="controls">
									<form:input required="required" id="inputEmail" class="span3" placeholder="Enter your email" type="email" path="userName" />  
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password <sup>*</sup>
								</label>
								<div class="controls">
									<form:input required="required" id="inputPassword" class="span3" placeholder="Enter your password" type="password" path="password" />  
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputName">Name <sup>*</sup>
								</label>
								<div class="controls">
									<form:input required="required" id="inputName" class="span3" placeholder="Enter your name" type="text" path="displayName" />  
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputAddress">Address </label>
								<div class="controls">
									<form:textarea id="inputAddress" row="5" cols="30"
								placeholder="Enter your address" path="address" />
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Create Your
									Account</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>ALREADY REGISTERED ?</h5>
						<c:if test="${not empty error}">
                        	<p id="error" style="color: red"> ${error} </p>
                        </c:if>
						<form:form action="login" modelAttribute="user" method="POST">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<form:input required="required" id="inputEmail" class="span3" placeholder="Enter your email" type="email" path="userName" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password</label>
								<div class="controls">
									<form:input required="required" id="inputPassword" class="span3" placeholder="Enter your password" type="password" path="password" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Sign in</button>
									<a href="#">Forget password?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>