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
				<li class="active">My Order Detail</li>
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
							<div class="col-sm-12">
								<div class="entry-edit">
									<div
										style="background: #3c8dbc; padding: 2px 10px; color: white"
										class="entry-edit-head">
										<span>Order #${Bill.id}</span>
									</div>
									<div class="fieldset"
										style="padding: 10px 15px; margin-bottom: 15px;">
										<table cellspacing="0" class="form-list">
											<tbody>
												<tr>
													<td style="padding: 5px; width: 200px;"><span>User
															Name</span> <span style="float: right;">:</span></td>
													<td
														style="padding-top: 5px; padding-bottom: 5px; padding-left: 5px"
														class="value"><strong>${Bill.user_name}</strong></td>
												</tr>
												<tr>
													<td style="padding: 5px; width: 200px;"><span>Phone</span>
														<span style="float: right;">:</span></td>
													<td
														style="padding-top: 5px; padding-bottom: 5px; padding-left: 5px"
														class="value"><strong>${Bill.phone}</strong></td>
												</tr>
												<tr>
													<td style="padding: 5px; width: 200px;"><span>Display
															Name</span> <span style="float: right;">:</span></td>
													<td
														style="padding-top: 5px; padding-bottom: 5px; padding-left: 5px"
														class="value"><strong>${Bill.display_name}</strong></td>
												</tr>
												<tr>
													<td style="padding: 5px; width: 200px;"><span>Address</span>
														<span style="float: right;">:</span></td>
													<td
														style="padding-top: 5px; padding-bottom: 5px; padding-left: 5px"
														class="value"><strong>${Bill.address}</strong></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<table id="example1"
									class="table table-bordered table-striped dataTable"
									role="grid" aria-describedby="example1_info">
									<thead class="thead">
										<tr>
											<th>Product Name</th>
											<th>Price</th>
											<th>Qty</th>
											<th>Row Total</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${!empty BillDetail}">
											<c:forEach var="billDeatail" items="${BillDetail}">
												<tr>
													<td>${billDeatail.productName}</td>
													<td><fmt:formatNumber value="${billDeatail.price}"
															type="currency" currencySymbol="$" /></td>
													<td>${billDeatail.qty}</td>
													<td><fmt:formatNumber value="${billDeatail.total}"
															type="currency" currencySymbol="$" /></td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty BillDetail}">
											<tr>
												<td colspan="6">No data</td>
											</tr>
										</c:if>
										<tr>
											<td colspan="3">Grand Total</td>
											<td colspan="1"><fmt:formatNumber value="${Bill.total}"
													type="currency" currencySymbol="$" /></td>
										</tr>
									</tbody>
								</table>
								<a href="<c:url value="/customer/myOrder"/>"
									class="btn btn-default">Back</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>