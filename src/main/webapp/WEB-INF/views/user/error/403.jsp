<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Access Denied</title>
</head>
<body class="hold-transition login-page">
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<div class="span-12">
					<div class="well well-small">
						<div class="panel-body" style="text-align: center">
							<h1>You do not have permission to access this page!</h1>
							<p>
								<a href="<c:url value="/"/>" class="btn btn-default">Back</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>