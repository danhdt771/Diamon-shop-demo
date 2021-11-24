<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="../user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title layout:title-pattern="$DECORATOR_TITLE - $CONTENT_TITLE">SpringBoot AdminLTE</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/bootstrap/css/bootstrap.min.css"/>" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/extra/css/font-awesome.min.css"/>" />
    <!-- Ionicons -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/extra/css/ionicons.min.css"/>" />
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/dist/css/AdminLTE.min.css"/>" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/dist/css/skins/_all-skins.min.css"/>"/>
    <!-- iCheck -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/iCheck/flat/blue.css"/>" />
    <!-- Morris chart -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/morris/morris.css"/>"/>
    <!-- jvectormap -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/jvectormap/jquery-jvectormap-1.2.2.css"/>"/>
    <!-- Date Picker -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/datepicker/datepicker3.css"/>"/>
    <!-- Daterange picker -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/daterangepicker/daterangepicker-bs3.css"/>"/>
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>"/>

    <link rel="stylesheet" href="<c:url value="/assets/admin/static/plugins/custom-datatable/DT_bootstrap.css"/>"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="<c:url value="/assets/admin/statichttps://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js" />"></script>
    <script src="<c:url value="/assets/admin/statichttps://oss.maxcdn.com/respond/1.4.2/respond.min.js" />"></script>
    <![endif]-->
    <decorator:head/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
	        		<!-- 
	Header Section 
	-->
		<%@include file="/WEB-INF/views/layouts/admin/header.jsp"%>
    </header>
    <!-- Left side column. contains the logo and sidebar -->

    <aside class="main-sidebar">
        <!-- 
	Main Sidebar 
	-->
		<%@include file="/WEB-INF/views/layouts/admin/main-sidebar.jsp"%>
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
		        	<!-- 
		Body Section 
		-->
			<decorator:body />
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.6
        </div>
        <strong>Copyright &copy; 2021.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <!--<aside class="control-sidebar control-sidebar-dark">
        <div th:replace="/fragments/control-sidebar"></div>
    </aside>-->
</div>
<!-- ./wrapper -->
<!-- /container -->
	
<!-- jQuery 2.2.0 -->
<script src="<c:url value="/assets/admin/static/plugins/jQuery/jQuery-2.2.0.min.js" />"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="/assets/admin/static/extra/js/1.11.4_jquery-ui.min.js" />"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="<c:url value="/assets/admin/static/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/extra/js/2.1.0_raphael-min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/morris/morris.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/sparkline/jquery.sparkline.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/knob/jquery.knob.js" />"></script>
<script src="<c:url value="/assets/admin/static/extra/js/2.11.2_moment.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/daterangepicker/daterangepicker.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/datepicker/bootstrap-datepicker.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/validator.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/slimScroll/jquery.slimscroll.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/plugins/fastclick/fastclick.js" />"></script>
<script src="<c:url value="/assets/admin/static/dist/js/app.min.js" />"></script>
<script src="<c:url value="/assets/admin/static/dist/js/demo.js" />"></script>


<script type="text/javascript" src="<c:url value="/assets/admin/static/plugins/custom-datatable/datatable.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/static/plugins/custom-datatable/datatables.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/admin/static/plugins/custom-datatable/DT_bootstrap.js" />"></script>


<script type="text/javascript">
$(document).ready(function() {
	var current = location.pathname;
    $('.treeview-menu li a').each(function(){
    	 var $this = $(this);
        // if the current path is like this link, make it active
        if(current.indexOf($this.attr('href')) !== -1){
        	$this.parent("li").addClass('active');
        }
    })
});
</script>
</body>
</html>