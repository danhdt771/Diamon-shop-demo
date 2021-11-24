<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<body>
	<section class="content-header">
		<h1>
			User Detail <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">User Details</li>
		</ol>
	</section>
	<section class="content">
		<div>
			<div class="row">
				<div class="col-md-12">
					<!-- Horizontal Form -->
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">User Detail</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<c:url var="saveUrl" value="/admin/user/save"/>
						<form:form action="${saveUrl}" modelAttribute="Account" method="POST" class="form-horizontal">
							<div class="box-body">
								<div style="display:none" class="form-group">
									<div class="col-sm-10">
										<form:input type="text" class="form-control" readonly="true" path="Id" placeholder="User ID" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">User Name</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="userName" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="password" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">Display Name</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="displayName" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">User Role</label>
									<div class="col-sm-10">
										<form:select class="form-control" path="userRole">
											<option value="">Select...</option>
											<form:option value="ROLE_USER">ROLE_USER</form:option>
											<form:option value="ROLE_EMPLOYEE">ROLE_EMPLOYEE</form:option>
											<form:option value="ROLE_ADMIN">ROLE_ADMIN</form:option>
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Address</label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="address" />
										<p class="text-red"></p>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer center">
								<a href="<c:url value="/admin/user/list"/>">
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