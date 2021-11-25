<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<head>
<title>My Account</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<li><a href="<c:url value="/customer/account" />"><span
							class="icon-chevron-right"></span>My account</a></li>
					<li><a href="<c:url value="/customer/changePassword" />"><span
							class="icon-chevron-right"></span>Reset password</a></li>
					<li><a href="<c:url value="/customer/myOrder" />"><span
							class="icon-chevron-right"></span>My order</a></li>
				</ul>
			</div>
		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">My account</a> <span class="divider">/</span></li>
				<li class="active">My profile</li>
			</ul>
			<div class="row">
				<div class="span9">
					<div class="well">
						<p
							style="border-bottom: 0.0625rem solid #efefef; padding: 1.125rem 0; font-size: 25px;">MY
							PROFILE</p>
						<div id="error" style="color: red">${msg}</div>
						<br>
						<form:form class="form-horizontal" action="changeProfile"
							modelAttribute="user" method="POST">
							<div class="control-group">
								<label style="width: auto" class="control-label"
									for="inputEmail">E-mail <sup>*</sup>
								</label>
								<div class="controls">
									<form:input readonly="true" required="required" id="inputEmail"
										class="span3" placeholder="Enter your email" type="email"
										path="userName" />
								</div>
							</div>
							<div class="control-group">
								<label style="width: auto" class="control-label" for="inputName">Name
									<sup>*</sup>
								</label>
								<div class="controls">
									<form:input required="required" id="inputName" class="span3"
										placeholder="Enter you name" type="text" path="displayName" />
								</div>
							</div>
							<div class="control-group">
								<label style="width: auto" class="control-label"
									for="inputAddress">Address </label>
								<div class="controls">
									<form:textarea id="inputAddress" row="5" cols="30"
										placeholder="Enter your address" path="address" />
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Submit</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>