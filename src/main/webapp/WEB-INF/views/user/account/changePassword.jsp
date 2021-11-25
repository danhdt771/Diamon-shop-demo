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
				<li class="active">Change passowrd</li>
			</ul>
			<div class="row">
				<div class="span9">
					<div class="well">
						<p
							style="border-bottom: 0.0625rem solid #efefef; padding: 1.125rem 0; font-size: 25px;">RESET PASSWORD</p>
						<div style="color: red">${msg}</div>
						<br>
						<form:form class="form-horizontal" action="changePassword"
							modelAttribute="user" method="POST">
							<form:hidden path="displayName" id="displayName"
								class="form-Control" value="${userInfo.displayName}" />
							<form:hidden path="userName" id="userName" class="form-Control"
								value="${userInfo.userName}" />
							<div class="control-group">
								<label style="text-align: left;" class="control-label" for="password">New Password<sup>*</sup></label>
								<div class="controls">
									<form:input placeholder="Enter new passowrd"
										required="required" path="password" id="password"
										type="password" class="form-Control" />
								</div>
							</div>
							<div class="control-group">
								<label style="text-align: left;" class="control-label" for="passwordConfirm">Confirm
									new Password<sup>*</sup>
								</label>
								<div class="controls">
									<input required="required" placeholder="Confirm new passowrd"
										type="password" id="passwordConfirm" class="form-Control">
									<div id="error" style="color: red; margin-top: 5px; padding-left: 6px;"></div>
								</div>
							</div>
							<div class="controls">
								<button id="resetPassword-submit" type="submit" class="btn block">Submit</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
<content tag="script">
	<script type="text/javascript">
		$("#passwordConfirm").on("change paste keyup",function() {
			var password = $("#password").val();
			var confirmPassword = $("#passwordConfirm").val();
			if (password != confirmPassword) {
				$("#resetPassword-submit").prop('disabled',true);
				$("#error").html("Passwords do not match!");
			} else {
				$("#resetPassword-submit").prop('disabled',false);
				$("#error").html("");
			}
		});
	</script>
</content>
</body>