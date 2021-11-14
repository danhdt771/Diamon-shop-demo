<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<head>
<meta charset="ISO-8859-1">
<title>List Cart</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li class="active">Shopping Cart</li>
			</ul>
			<div class="well well-small">
				<h1>
					Shopping Cart <small class="pull-right"> ${TotalQtyCart} Items are in the
						cart </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Product</th>
							<th>Description</th>
							<th>Color</th>
							<th>Unit price</th>
							<th>Qty</th>
							<th>Edit</th>
							<th>Delete</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${Cart}" varStatus="loop">
							<tr>
								<td><img width="100" src="<c:url value="/assets/user/img/${item.value.product.img}"/>" alt=""></td>
								<td>${item.value.product.product_name}
								</td>
								<td><span style="background:${item.value.product.code_color}" class="shopBtn"><span class="icon-ok"></span></span>
								</td>
								<td>$${item.value.product.price}</td>
								<td>
									<input type="number" min="0" max="100" class="span1" style="max-width: 34px"
									placeholder="1" id="qty-item-${item.key}" value="${item.value.qty}">
								</td>
								<td>
									<div class="input-append">
										<button data-id="${item.key}" class="btn btn-mini btn-danger edit-cart">
											<span class="icon-edit"></span>
										</button>
									</div>
								</td>
								<td>
									<div class="input-append">
										<a href="<c:url value="/deleteCart/${item.key}"/>" class="btn btn-mini btn-danger" type="button">
											<span class="icon-remove"></span>
										</a>
									</div>
								</td>
								<td>$${item.value.totalPrice}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="7" class="alignR">Total products:</td>
							<td >$${TotalPriceCart}</td>
						</tr>
					</tbody>
				</table>
				<br />
				<a href="<c:url value="/" />" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Continue Shopping </a> <a
					href="<c:url value="/checkout" />" class="shopBtn btn-large pull-right">Next <span
					class="icon-arrow-right"></span></a>

			</div>
		</div>
	</div>
	
<content tag="script">
<script>
	$(".edit-cart").on("click", function(){
		var id = $(this).data("id");
		var qty = $("#qty-item-"+id).val();
		window.location = "editCart/"+id+"/"+qty;
	})
</script>
</content>
</body>