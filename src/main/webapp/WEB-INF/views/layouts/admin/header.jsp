<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../user/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Logo -->
<a href="/" class="logo">
    <!-- mini logo for sidebar mini 50x50 pixels -->
    <span class="logo-mini"><b>A</b>LT</span>
    <!-- logo for regular state and mobile devices -->
    <span class="logo-lg"><b>Admin</b>LTE</span>
</a>
<!-- Header Navbar: style can be found in header.less -->
<nav class="navbar navbar-static-top">
    <!-- Sidebar toggle button-->
    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
    </a>

    <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
            <!-- User Account: style can be found in dropdown.less -->
            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i style="font-family: FontAwesome; font-style: unset;" class="fas fa-user"></i>
                    <span class="hidden-xs" sec:authentication="principal.username"></span>
                </a>
                <ul class="dropdown-menu">
                    <!-- User image -->
                    <li class="user-header">
				        <div style="
					        color: white; 
						    border-radius: 50%;
						    font-size: 31px;
						    width: 45px;
						    height: 45px;
						    background: white;
						    text-align: center;
						    display: inline-block;">
                        	<i style="font-family: FontAwesome; font-style: unset; color:black" class="fas fa-user"></i>
                        </div>
                        <p>
                            Welcome <span><c:if test="${not empty customerName_ }">${customerName_ }</c:if></span> !
                            <small>Member since Nov. 2021</small>
                        </p>
                    </li>
                    <!-- Menu Footer-->
                    <li class="user-footer">
                        <div class="pull-left">
                            <!--<a href="#" class="btn btn-default btn-flat">Profile</a>-->
                        </div>
                        <c:if test="${not empty customerName_ }">
	                        <div class="pull-right">
	                            <a href="<c:url value="/logout" />" class="btn btn-default btn-flat">Sign out</a>
	                        </div>
                        </c:if>
                    </li>
                </ul>
            </li>
            <!-- Control Sidebar Toggle Button -->
            <!--<li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
            </li>-->
        </ul>
    </div>
</nav>