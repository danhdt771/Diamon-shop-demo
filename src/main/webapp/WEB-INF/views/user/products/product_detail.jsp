<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<head>
	<style>
		.product-content {
			overflow-x: hidden;
		}
	</style>
	<title>Product Page</title>
</head>

<body>
	<!-- 
Body Section 
-->
	<div class="row product-content">
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
					src="<c:url value="/assets/user/img/paypal.jpg" />"
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
							src="<c:url value="/assets/user/img/bootstrap-ecommerce-templates.PNG" />"
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
				<li><a href="products.html">Items</a> <span class="divider">/</span></li>
				<li class="active">Preview</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img src="<c:url value="/assets/user/img/${product.img}"/>" alt=""
										style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${product.product_name}</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="GET" action="<c:url value="/addCartWithQty/${product.id}"/>">
							<div class="control-group">
								<label class="control-label">
									<span>
										<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="$" />
									</span>
								</label>
								<div class="controls">
									<input min=0 type="number" name="qty" class="span6" value=1 >
								</div>
							</div>

							<div class="control-group">
								<label class="control-label"><span>Color</span></label>
								<div class="controls">
									<select class="span11">
										<option>Red</option>
										<option>Purple</option>
										<option>Pink</option>
										<option>Red</option>
									</select>
								</div>
							</div>
							<p>
								${product.title}
							</p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Add to cart
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Product
							Details</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Related
							Products </a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						${product.detail}
					</div>
					<div class="tab-pane fade" id="profile">
					<c:if test="${relatedProducts.size() > 0 }" >
						<c:forEach var="relatedProduct" items="${relatedProducts}" varStatus="loop">
							<c:if test="${(relatedProduct.id) != (product.id)}">
								<div class="row-fluid">
									<div class="span2">
										<img src="<c:url value="/assets/user/img/${relatedProduct.img}"/>" alt="">
									</div>
									<div class="span6">
										<h5>${relatedProduct.product_name}</h5>
										<p>${relatedProduct.title}</p>
									</div>
									<div class="span4 alignR">
										<form class="form-horizontal qtyFrm">
											<h3>
												<fmt:formatNumber value="${relatedProduct.price}" type="currency" currencySymbol="$" />
											</h3>
											<div class="btn-group">
												<a href="#" class="defaultBtn"><span
													class=" icon-shopping-cart"></span> Add to cart</a> <a
													href="<c:url value="/product-details/${relatedProduct.id}"/>" class="shopBtn">VIEW</a>
											</div>
										</form>
									</div>
								</div>
								<c:if test="${not loop.last}">
									<hr class="soft">
								</c:if>
							</c:if>
						</c:forEach>
					</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- Body wrapper -->
</body>