<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<body>
	<section class="content-header">
		<h1>
			Bill Detail <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Bill Details</li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<!-- Horizontal Form -->
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">Bill Detail</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<div class="row">
						<div class="col-sm-12">
							<div class="entry-edit">
								<div style="background: #3c8dbc; padding: 2px 10px; color:white" class="entry-edit-head"> 
									<span>Order #${Bill.id}</span>
								</div>
								<div class="fieldset" style="padding: 10px 15px; margin-bottom: 15px;">
									<table cellspacing="0" class="form-list">
										<tbody>
											<tr>
												<td style="padding: 5px; width: 200px;">
													<span>User Name</span>
													<span style="float: right;">:</span>
												</td>
												<td style="padding-top: 5px; padding-bottom:5px; padding-left:5px" class="value">
													<strong>${Bill.user_name}</strong>
												</td>
											</tr>
											<tr>
												<td style="padding: 5px; width: 200px;">
													<span>Phone</span>
													<span style="float: right;">:</span>
												</td>
												<td style="padding-top: 5px; padding-bottom:5px; padding-left:5px" class="value">
													<strong>${Bill.phone}</strong>
												</td>
											</tr>
											<tr>
												<td style="padding: 5px; width: 200px;">
													<span>Display Name</span>
													<span style="float: right;">:</span>
												</td>
												<td style="padding-top: 5px; padding-bottom:5px; padding-left:5px" class="value">
													<strong>${Bill.display_name}</strong>
												</td>
											</tr>
											<tr>
												<td style="padding: 5px; width: 200px;">
													<span>Address</span>
													<span style="float: right;">:</span>
												</td>
												<td style="padding-top: 5px; padding-bottom:5px; padding-left:5px" class="value">
													<strong>${Bill.address}</strong>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<table id="example1"
								class="table table-bordered table-striped dataTable" role="grid"
								aria-describedby="example1_info">
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
												<td><fmt:formatNumber value="${billDeatail.price}" type="currency" currencySymbol="$" /></td>
												<td>${billDeatail.qty}</td>
												<td><fmt:formatNumber value="${billDeatail.total}" type="currency" currencySymbol="$" /></td>
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
										<td colspan="1"><fmt:formatNumber value="${Bill.total}" type="currency" currencySymbol="$" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<script>
		$(function() {

			$('#example1').DataTable({
				'paging' : true,
				'lengthChange' : false,
				'searching' : true,
				'ordering' : true,
				'info' : true,
				'autoWidth' : false
			})

			jQuery('#example1_wrapper input').addClass("form-control input-sm"); // modify table search input
		})
	</script>