<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar" xmlns:th="http://www.w3.org/1999/xhtml" xmlns:sec="http://www.w3.org/1999/xhtml">
    <!-- Sidebar user panel -->
    <div class="user-panel">
        <div class="pull-left image" style="
        color: white;
	    border-radius: 50%;
	    font-size: 31px;
	    width: 45px;
	    height: 45px;
	    background: white;
	    text-align: center;">
            <i style="font-family: FontAwesome; font-style: unset; color:black" class="fas fa-user"></i>
        </div>
        <div class="pull-left info" style="color: white">
            <p><c:if test="${not empty customerName_ }">${customerName_ }</c:if></p>
            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
    </div>
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview">
            <a href="#">
                <i class="fa fa-th"></i> <span>Options</span>
                <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
            </a>
            <ul class="treeview-menu">
<!--
                <li class="active"><a href="/"><i class="fa fa-dashboard"></i> Dashboard v1</a></li>
-->

                <li><a href="<c:url value="/admin/list-product" />"><i class="fa fa-circle-o"></i> Product</a></li>
                <li><a href="<c:url value="/admin/product-color/list" />"><i class="fa fa-circle-o"></i> Product Color</a></li>
                <li><a href="<c:url value="/admin/bill/list" />"><i class="fa fa-circle-o"></i> Invoice</a></li>
                <li><a href="<c:url value="/admin/category/list" />"><i class="fa fa-circle-o"></i> Category</a></li>
                <li><a href="<c:url value="/admin/menu/list" />"><i class="fa fa-circle-o"></i> Menu</a></li>
                <li><a href="<c:url value="/admin/user/list" />"><i class="fa fa-circle-o"></i> User</a></li>
                <li sec:authorize="isAuthenticated()"><a th:href="@{/logout}"><i class="fa fa-circle-o"></i> Logout</a></li>
            </ul>
        </li>
    </ul>
</section>
<!-- /.sidebar -->