<%--
  Created by IntelliJ IDEA.
  User: stonezhang
  Date: 2017/3/13
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: stonezhang
  Date: 2017/3/1
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="tc.bean.InstitutionCourseVO" %>
<%@ page import="tc.dao.TeacherDAO" %>
<%@ page import="tc.bean.TeacherInfoVO" %>
<%@ page import="tc.bean.CourseFieldVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<TeacherInfoVO> teacherInfoVOList =
        (List<TeacherInfoVO>)request.getAttribute("teacherInfoVOList");
List<CourseFieldVO> courseFieldVOList = (List<CourseFieldVO>) request.getAttribute("courseFieldVOList");
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!--<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">-->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/dist/css/AdminLTE.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <!--<link rel="stylesheet" href="../WEB-INF/lib/AdminLTE-2.3.11/dist/css/skins/_all-skins.css">-->

    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/dist/css/skins/skin-purple.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

    <link rel="stylesheet" href="../../css/studentHomePage.css">

    <link rel="stylesheet" href="../../css/courseRelease.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-purple sidebar-mini">

<jsp:useBean id="institutionInfoVO"
             type="tc.bean.InstitutionInfoVO"
             scope="session"></jsp:useBean>

<header class="main-header skin-purple" style="background-color: #605ca8">
    <!-- Logo -->

    <div class="navbar-header skin-purple">
        <a href="../../index2.html" class="navbar-brand sk"><b>Coraise</b>   Institution</a>
    </div>
    <nav class="navbar navbar-static-top">

        <div class="container-fluid">

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../WEB-INF/lib/AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Sender Name
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>Message Excerpt</p>
                                        </a>
                                    </li><!-- end message -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-labelledby="dLabel">
                            <%=institutionInfoVO.getName()%> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/institution/homepage">课程管理</a></li>
                            <li><a href="/institution/info">信息管理</a></li>
                            <li><a href="/institution/log">机构轨迹</a></li>
                            <li class="divider"></li>
                            <li><a href="/institution/logout">退出登录</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

</header>

<div class="wrapper">


    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="<%=institutionInfoVO.getImgUrl()%>" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p><%=institutionInfoVO.getName()%></p>
                    <%--<a href="#"><i class="fa fa-circle text-success"></i> level <%=studentInfoVO.getLevel()%></a>--%>
                </div>
            </div>

            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">课程管理</li>
                <li><a href="/institution/homepage"><i class="fa fa-circle-o"></i>课程管理</a></li>
                <li class="active"><a href="/institution/release"><i class="fa fa-circle-o"></i>发布课程</a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <div class="box box-solid">
            <div class="box-header with-border">
                <h2 class="box-title">发布课程</h2>
            </div>
            <!-- /.box-header -->
            <div class="box-body">

                <div class="row margin-bottom">
                    <div class="col-sm-6">
                        <p class="lead">发布须知</p>
                        <br>
                        <p class="text-muted">发布的课程需要通过管理员审批</p>
                        <p class="text-muted">实际开课时间可能会和课程提交时间有一定延迟</p>
                    </div>
                    <div class="col-sm-6">
                        <div>
                            <label class="releaseLabel">课程名称</label>
                            <input type="text" class="releaseInput" id="coursename">
                        </div>

                        <div class="select2-search select2-search--inline">
                            <label class="releaseLabel">开课老师</label>
                            <select class="form-control releaseInput" id="teacherName">
                                <c:forEach var="teacherInfoVO" items="<%= teacherInfoVOList %>">
                                    <option value="<c:out value="${teacherInfoVO.getId()}"/>"><c:out value="${teacherInfoVO.getName()}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label class="releaseLabel">课程定价</label>
                            <input type="text" class="releaseInput" id="price">
                        </div>
                        <div class="form-group">
                            <label class="releaseLabel">开课时间</label>

                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right" id="reservation">
                            </div>
                            <!-- /.input group -->
                        </div>
                        <%--<div>--%>
                            <%--<label class="releaseLabel">课程类别</label>--%>
                            <%--<input type="text" class="releaseInput" id="fieldId">--%>
                        <%--</div>--%>
                        <div class="select2-search select2-search--inline">
                            <label class="releaseLabel">课程类别</label>
                            <select class="form-control releaseInput" id="courseField">
                                <c:forEach var="courseFieldVO" items="<%= courseFieldVOList %>">
                                <option value="<c:out value="${courseFieldVO.getId()}"/>"><c:out value="${courseFieldVO.getType()}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label class="releaseLabel">课程简介</label>
                            <input type="text" class="releaseInput" id="description">
                        </div>
                        <div>
                            <label class="releaseLabel">课程图片</label>
                            <input type="text" style="display: none" class="releaseInput" id="imgUrl" value="/img/course/default.png">
                        </div>
                        <input style="display: none;" id="institutionId" value="<%=institutionInfoVO.getId()%>">
                        <button type="button" class="btn btn-block btn-warning btn-sm" onclick="release()">
                            发布课程
                        </button>
                    </div>
                    <!-- /.col -->
                </div>
            </div>
        </div>
    <!-- /.content-wrapper -->
</div>
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.3.3.3
        </div>
        <strong>Copyright &copy; 1970-2017 <a href="http://bilibili.com">WE ARE SERIOUS</a>.</strong> All rights
        reserved.
    </footer>
<!-- ./wrapper -->
</div>

<!-- jQuery 2.2.3 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- jQuery 2.2.3 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../plugin/AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/input-mask/jquery.inputmask.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- bootstrap color picker -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../plugin/AdminLTE-2.3.11/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../plugin/AdminLTE-2.3.11/dist/js/demo.js"></script>

<script src="../../js/courseRelease.js"></script>
<%--<script>--%>
    <%--$(function () {--%>
        <%--//Initialize Select2 Elements--%>
        <%--$(".select2").select2();--%>

        <%--$('#reservation').daterangepicker();--%>

    <%--});--%>
<%--</script>--%>

</body>
</html>

