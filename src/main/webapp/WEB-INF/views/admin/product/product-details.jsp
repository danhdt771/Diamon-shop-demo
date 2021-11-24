<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<body>
	<section class="content-header">
		<h1>
			Product Detail <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Product Details</li>
		</ol>
	</section>
	<section class="content">
		<div>
			<div class="row">
				<div class="col-md-12">
					<!-- Horizontal Form -->
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Product Detail</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<c:url var="saveUrl" value="/admin/save"/>
						<form:form action="${saveUrl}" modelAttribute="Product" method="POST" class="form-horizontal">
							<div class="box-body">
								<div style="display:none" class="form-group">
									<label class="col-sm-2 control-label">Product Id</label>

									<div class="col-sm-10">
										<form:input type="text" class="form-control" readonly="true" path="ID" placeholder="Product ID" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Category<span>*</span></label>
									<div class="col-sm-10">
										<form:select class="form-control" path="ID_CATEGORIES">
											<option value="">Select...</option>
											<c:forEach var="category" items="${listCategories}">
												<form:option value="${category.id}">${category.name}</form:option>
											</c:forEach>
										</form:select>
										<p class="text-red"></p>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Size</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="SIZES" />
										<p class="text-red"></p>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Name</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="PRODUCT_NAME" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Price</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="PRICE" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Description</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="DETAIL" />
										<p class="text-red"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">Sale</label>
									<div class="col-sm-10">
										<form:select style="width:auto" class="form-control" path="SALE">
											<form:option value="0">No</form:option>
											<form:option value="1">Yes</form:option>
										</form:select>
										<p class="text-red"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">Featured product</label>
									<div class="col-sm-10">
										<form:select style="width:auto" class="form-control" path="FEATURED_PRODUCT">
											<form:option value="0">No</form:option>
											<form:option value="1">Yes</form:option>
										</form:select>
										<p class="text-red"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">New product</label>
									<div class="col-sm-10">
										<form:select style="width:auto" class="form-control" path="NEW_PRODUCT">
											<form:option value="0">No</form:option>
											<form:option value="1">Yes</form:option>
										</form:select>
										<p class="text-red"></p>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer center">
								<a href="<c:url value="/admin/list"/>">
									<button type="button" class="btn btn-default">
										<i class="fa fa-right"></i> Cancel
									</button>
								</a>
								<button type="submit" class="btn btn-info pull-right">
									<i class="fa fa-save"></i> Save
								</button>
							</div>
							<!-- /.box-footer -->
						</form:form>
					</div>
					<!-- /.box -->
				</div>
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