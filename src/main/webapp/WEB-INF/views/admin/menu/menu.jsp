<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<body>
	<section class="content-header">
		<h1>
			Menu Detail <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Menu Details</li>
		</ol>
	</section>
	<section class="content">
		<div>
			<div class="row">
				<div class="col-md-12">
					<!-- Horizontal Form -->
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Menu Detail</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<c:url var="saveUrl" value="/admin/menu/save"/>
						<form:form action="${saveUrl}" modelAttribute="Menus" method="POST" class="form-horizontal">
							<div class="box-body">
								<div style="display:none" class="form-group">
									<div class="col-sm-10">
										<form:input type="text" class="form-control" readonly="true" path="Id" placeholder="Category ID" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Name</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="name" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Url</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="url" />
										<p class="text-red"></p>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer center">
								<a href="<c:url value="/admin/menu/list"/>">
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