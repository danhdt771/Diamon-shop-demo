<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<body>
	<section class="content-header">
		<h1>
			Menu List <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Dashboard</li>
		</ol>
	</section>
	<section class="content">
		<div>
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Menu List</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="box-footer center">
								<a href="<c:url value="/admin/menu/add" />">
									<button type="button" class="btn btn-primary pull-right">
										<i class="fa fa-plus"></i> Add new
									</button>
								</a>
								<!--<form th:action="@{/product/list}" method="get">
                            <input type="search" th:value="${param.search}" name='search' placeholder="search">
                            <button type="submit">Search</button>
                        </form>-->
							</div>
							<c:if test="${param.success ne null}">
							<div>
								<div class="alert alert-success alert-dismissible">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">×</button>
									<h4>
										<i class="icon fa fa-check"></i> Success!
									</h4>
									Information saved successfully.
								</div>
							</div>
							</c:if>
							<c:if test="${param.deleted ne null}">
							<div >
								<div class="alert alert-info alert-dismissible">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">×</button>
									<h4>
										<i class="icon fa fa-check"></i> Deleted!
									</h4>
									Information deleted successfully.
								</div>
							</div>
							</c:if>
							<!--<div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">-->
							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead class="thead">
											<tr>
												<th>Cateogry ID</th>
												<th>Name</th>
												<th>Url</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${!empty menuPaginate}">
												<c:forEach var="menus" items="${menuPaginate}" varStatus="loop">
													<tr>
														<td>${menus.id}</td>
														<td>${menus.name}</td>
														<td>${menus.url}</td>
														<td><a class="btn btn-primary btn-xs purple editView" title="Edit"
															href="<c:url value="/admin/menu/edit/${menus.id}" />" ><i
																class="fa fa-edit"></i> Edit</a> 
															<a class="btn btn-danger btn-xs purple deleteView" title="Delete"
															href="<c:url value="/admin/menu/delete/${menus.id}" />" ><i
																class="fa fa-trash-o"></i> Delete</a></td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${empty menuPaginate}">
												<tr>
													<td colspan="7">No data</td>
												</tr>
											</c:if>
										</tbody>
									</table>
								</div>
							</div>
							<!--</div>-->

						<div class="dataTables_paginate paging_bootstrap">
							<ul class="pagination">
								<c:forEach var="item" begin="1" end="${paginateInfo.totalPage}" varStatus="loop">
									<c:if test="${(loop.index) == paginateInfo.currentPage}">
										<li class="active">
			                                <a href="<c:url value="/admin/menu/list/${loop.index}"/>">${loop.index}</a>
			                            </li>
									</c:if>
									<c:if test="${(loop.index) != paginateInfo.currentPage}">
										<li>
			                               <a href="<c:url value="/admin/menu/list/${loop.index}"/>">${loop.index}</a> 
			                            </li>
									</c:if>
								</c:forEach>
	                        </ul>
	                    </div>

						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->
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
</body>