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
				<li class="active">My Order</li>
			</ul>
			<div class="row">
				<div class="span9">
					<div class="well">
						<p
							style="border-bottom: 0.0625rem solid #efefef; padding: 1.125rem 0; font-size: 25px;">MY
							ORDER</p>
						<div style="color: red">${msg}</div>
						<br>
						<div>
							<table id="example1"
								class="table table-bordered table-striped dataTable" role="grid"
								aria-describedby="example1_info">
								<thead class="thead">
									<tr>
										<th>Invoice ID</th>
										<th>User Name</th>
										<th>Phone</th>
										<th>Display Name</th>
										<th>Address</th>
										<th>Total</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${!empty billPaginate}">
										<c:forEach var="bill" items="${billPaginate}" varStatus="loop">
											<tr>
												<td>${bill.id}</td>
												<td>${bill.user_name}</td>
												<td>${bill.phone}</td>
												<td>${bill.display_name}</td>
												<td>${bill.address}</td>
												<td><fmt:formatNumber value="${bill.total}"
														type="currency" currencySymbol="$" /></td>
												<td><a class="btn btn-primary btn-xs purple editView"
													title="Edit"
													href="<c:url value="/customer/myOrder/view/${bill.id}" />"><i
														class="fa fa-edit"></i> View</a> 
												</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${empty billPaginate}">
										<tr>
											<td colspan="7">No data</td>
										</tr>
									</c:if>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>