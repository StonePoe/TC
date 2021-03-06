<%--
  Created by IntelliJ IDEA.
  User: stonezhang
  Date: 2017/3/1
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="tc.bean.StudentCourseVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <link rel="stylesheet" href="../../plugin/AdminLTE-2.3.11/dist/css/skins/skin-yellow.css">
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
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-yellow sidebar-mini">

<jsp:useBean id="studentInfoVO"
             type="tc.bean.StudentInfoVO"
             scope="session"></jsp:useBean>

<jsp:useBean id="bankcardVO"
             type="tc.bean.BankcardVO"
             scope="request"></jsp:useBean>

<jsp:useBean id="memberCardVO"
             type="tc.bean.MemberCardVO"
             scope="request"></jsp:useBean>

<header class="main-header skin-yellow" style="background-color:  #f39c12">
    <!-- Logo -->

    <div class="navbar-header skin-yellow">
        <a href="../../index2.html" class="navbar-brand skin-yellow"><b>Coraise</b>   Student</a>
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
                            <%=studentInfoVO.getName()%> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/student/homepage">课程管理</a></li>
                            <li><a href="/student/info">信息修改</a></li>
                            <li><a href="/student/member">会员管理</a></li>
                            <li><a href="/student/log">学习轨迹</a></li>
                            <li class="divider"></li>
                            <li><a href="/student/logout">退出登录</a></li>
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
                    <img src="<%=studentInfoVO.getImg()%>" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p><%=studentInfoVO.getName()%></p>
                    <a href="#"><i class="fa fa-circle text-success"></i> level <%=studentInfoVO.getLevel()%></a>
                </div>
            </div>

            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li><a href="/student/member"><i class="fa fa-circle-o"></i>会员状态</a></li>
                <li class="active"><a href="/student/member/finance"><i class="fa fa-circle-o"></i>金额管理</a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <input style="display: none" id="studentId" value="<%=studentInfoVO.getId()%>">

        <input style="display: none" id="memberId" value="<%=studentInfoVO.getMemberId()%>">

        <input style="display: none" id="bankId" value="<%=studentInfoVO.getBankCard()%>">

        <div class="box box-primary">
            <div class="box-header with-border">
                <h2 class="box-title">会员卡管理</h2>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <div>
                    <p style="display: inline" class="text-muted">会员卡充值：</p>
                    <input style="display: inline" type="text" id="memberMoney">
                    <button type="button" class="btn btn-block btn-warning btn-sm"
                            onclick="charge()">确认充值</button>
                    <!-- /.col -->
                </div>

                <br>

                <div>
                    <p style="display: inline" class="text-muted">会员卡注销（将不会返还剩余金额）</p>
                    <button type="button" class="btn btn-block btn-warning btn-sm"
                            onclick="destroy()">注销</button>
                    <!-- /.col -->
                </div>

            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.3.3.3
        </div>
        <strong>Copyright &copy; 1970-2017 <a href="http://bilibili.com">WE ARE SERIOUS</a>.</strong> All rights
        reserved.
    </footer>

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../../plugin/AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../plugin/AdminLTE-2.3.11/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../../plugin/AdminLTE-2.3.11/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../plugin/AdminLTE-2.3.11/dist/js/demo.js"></script>

<script src="../../js/memberFinance.js"></script>

</body>
</html>

