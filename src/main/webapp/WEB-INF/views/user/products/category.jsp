<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp" %>
<head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<title>Products</title>
</head>

<body>
	<div class="well well-small">
		<div class="row-fluid">
			<span>Our Products</span> <select class="pull-right">
				<option>A - Z</option>
				<option>High - Low</option>
			</select>
		</div>
		<c:if test="${productsPaginate.size() > 0}">
		<div class="row-fluid">
			<div class="span12">
				<div class="well well-small">
					<div class="row-fluid">
						<ul class="thumbnails">
					<c:forEach var="product" items="${productsPaginate}" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="<c:url value="/product-details/${product.id}"/>"
									title="add to cart"><span class="icon-search"></span>
									QUICK VIEW</a> <a href="<c:url value="/product-details/${product.id}"/>"><img
									src="<c:url value="/assets/user/img/${product.img}"/>" alt=""></a>
								<div class="caption cntr">
									<p>${product.product_name}</p>
									<p> 
										<strong>
											<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="$" />
										</strong>
									</p>
									<h4>
										<a class="shopBtn" href="<c:url value="/addCart/${product.id}"/>" title="add to cart"> Add to
											cart </a>
									</h4>
									<div class="actionList">
										<a class="pull-left" href="#">Add to Wish List </a> <a
											class="pull-left" href="#"> Add to Compare </a>
									</div>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if test="${(loop.index+1)%3 == 0 || (loop.index+1) == productsPaginate.size()}">
								</ul>
							</div>
							<c:if test="${(loop.index+1) < productsPaginate.size()}">
								<div class="row-fluid">
									<ul class="thumbnails">
							</c:if>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
		</c:if>
		<div class="row-fluid">
			<div class="pagination"
				style="display: flex; justify-content: center;">
				<c:forEach var="item" begin="1" end="${paginateInfo.totalPage}" varStatus="loop">
					<c:if test="${(loop.index) == paginateInfo.currentPage}">
						<a class="active" href="<c:url value="/products/${idCategory}/${loop.index}"/>">${loop.index}</a> 
					</c:if>
					<c:if test="${(loop.index) != paginateInfo.currentPage}">
						<a href="<c:url value="/products/${idCategory}/${loop.index}"/>">${loop.index}</a> 
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</body>