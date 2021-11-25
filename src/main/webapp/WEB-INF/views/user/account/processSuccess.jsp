<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../taglib.jsp"%>
<body class="hold-transition login-page">
	<div class="container">
		<div class="well well-small">
			<div class="row-fluid">
				<div class="col-md-5 col-md-offset-3">
					<div class="span-12">
						<div class="panel-body" style="text-align: center">
							<h1>${title}</h1>
							<p>
								<a href="<c:url value="${targetUrl}"/>"
									class="btn btn-default">OK</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>