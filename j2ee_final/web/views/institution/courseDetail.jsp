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
<%@ page import="tc.dao.TeacherDAO" %>
<%@ page import="tc.bean.TeacherInfoVO" %>
<%@ page import="tc.bean.CourseFieldVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <link rel="stylesheet" href="../../css/courseCheck.css">
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

<jsp:useBean id="institutionCourseVO"
             type="tc.bean.InstitutionCourseVO"
             scope="request"></jsp:useBean>


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
                <li class="active"><a href="/institution/homepage"><i class="fa fa-circle-o"></i>课程管理</a></li>
                <li><a href="/institution/release"><i class="fa fa-circle-o"></i>发布课程</a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <div class="box box-solid">
            <div class="box-header with-border">
                <h2 class="box-title">课程详情</h2>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <div class="row">
                    <div class="col-sm-6">
                        <%--<img class="img-responsive src="${institutionCourseVO.imgUrl}">--%>
                        <img class="img-responsive" src="<%=institutionCourseVO.getImgUrl()%>">
                    </div>

                    <div class="col-sm-6">
                        <p class="lead">课程信息修改</p>
                        <p class="text-muted">请注意我们目前只支持部分信息的修改，并需要等待审核</p>
                        <input style="display: none" id="courseId" value="${institutionCourseVO.id}">
                        <div>
                            <label class="releaseLabel">课程名称</label>
                            <input type="text" class="releaseInput" id="cname"
                                   value="${institutionCourseVO.name}">
                        </div>
                        <%--<div class="select2-search select2-search--inline">--%>
                            <%--<label class="releaseLabel">开课老师</label>--%>
                            <%--<select class="form-control releaseInput" id="teacherName">--%>
                                <%--<c:forEach var="teacherInfoVO" items="${teacherInfoVOList}">--%>
                                    <%--<option value="=${teacherInfoVO.id}">${teacherInfoVO.name}</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                        <div>
                            <label class="releaseLabel">课程定价</label>
                            <input type="text" class="releaseInput" id="price"
                                   value="${institutionCourseVO.price}">
                        </div>
                        <%--<div class="select2-search select2-search--inline">--%>
                            <%--<label class="releaseLabel">课程类别</label>--%>
                            <%--<select class="form-control releaseInput" id="courseField">--%>
                                <%--<c:forEach var="courseFieldVO" items="<%= courseFieldVOList %>">--%>
                                    <%--<option value="<c:out value="${courseFieldVO.getId()}"/>"><c:out value="${courseFieldVO.getType()}"/></option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                        <div>
                            <label class="releaseLabel">课程简介</label>
                            <input type="text" class="releaseInput" id="description"
                                   value="${institutionCourseVO.description}">
                        </div>

                        <div>
                            <label class="releaseLabel">课程教师</label>
                            <p class="text-muted releaseLabel">${institutionCourseVO.teacherName}</p>
                        </div>

                        <div>
                            <label class="releaseLabel">课程类别</label>
                            <p class="text-muted releaseLabel">${institutionCourseVO.fieldName}</p>
                        </div>

                        <div>
                            <label class="releaseLabel">起止时间</label>
                            <p class="text-muted releaseLabel">
                            ${institutionCourseVO.startdate} 到 ${institutionCourseVO.enddate}</p>
                        </div>
                        <button type="button" class="btn btn-primary btn-lg" onclick="updateInfo()">信息更新</button>
                    </div>

                </div>


                <div class="scoreManage">
                    <div id="example2_wrapper" class="classdataTables_wrapper form-inline dt-bootstrap">
                        <div class="row">
                            <div class="col-sm-6"></div>
                            <div class="col-sm-6"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="example2" class="table table-bordered table-hover dataTable"
                                       role="grid" aria-describedby="example2_info">
                                    <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-sort="ascending"
                                            aria-label="课程名称: activate to sort column descending">
                                            学生名称
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                            aria-label="机构: activate to sort column ascending">
                                            注册时间
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                            aria-label="教师: activate to sort column ascending">
                                            学习状态
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                            aria-label="类别: activate to sort column ascending">
                                            最后得分
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                            aria-label="价格: activate to sort column ascending">
                                            成绩登记
                                        </th>

                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="institutionStudentVO" items="${institutionStudentVOList}">
                                        <tr onclick="">
                                            <td>
                                                    ${institutionStudentVO.name}
                                            </td>
                                            <td>
                                                    ${institutionStudentVO.enrollTime}
                                            </td>
                                            <td>
                                                    ${institutionStudentVO.learningState}
                                            </td>
                                            <td>
                                                    ${institutionStudentVO.score}
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal${institutionStudentVO.id}">
                                                    详情
                                                </button>
                                                <div class="modal fade" id="myModal${institutionStudentVO.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                                <h4 class="modal-title" id="myModalLabel">${institutionStudentVO.name}</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div>
                                                                    some sort of score table
                                                                </div>
                                                                <label>最终成绩</label>
                                                                <input type="text", id="finalScore${institutionStudentVO.id}">

                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                                <button type="button" class="btn btn-primary" onclick="scorePublish(${institutionStudentVO.id})">成绩更新</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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

<%--<script src="../../js/courseRelease.js"></script>--%>

<script src="../../js/institutionCourse.js"></script>
<%--<script>--%>
<%--$(function () {--%>
<%--//Initialize Select2 Elements--%>
<%--$(".select2").select2();--%>

<%--$('#reservation').daterangepicker();--%>

<%--});--%>
<%--</script>--%>

</body>
</html>

