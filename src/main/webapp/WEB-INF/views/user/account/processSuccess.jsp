<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-5 col-md-offset-3">
				<div class="span-12">
					<div class="well well-small">
						<div class="panel-body" style="text-align: center">
							<h1>${title}</h1>
							<p>
								<a href="<c:url value="/customer/account"/>"
									class="btn btn-default">OK</a>
							</p>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
</body>
</html>