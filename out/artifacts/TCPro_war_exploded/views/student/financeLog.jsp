<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stonezhang
  Date: 2017/3/5
  Time: 下午8:20
  To change this template use File | Settings | File Templates.
  state = -1:未注册
  state = 0：未开始；
  state = 1：正在进行
  state = 2：已完成
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Course</title>
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

    <link rel="stylesheet" href="../../css/courseDetail.css">

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
                                                <img src="../plugin/AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
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
                <li class="header">学生动态</li>
                <li class="active"><a href="/student/log"><i class="fa fa-circle-o"></i>选课记录</a></li>
                <li><a href="/student/studentLog"><i class="fa fa-circle-o"></i>学生动态</a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">资金日志</h3>
            </div>
            <div class="box-body">
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
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                        aria-label="机构: activate to sort column ascending">
                                        机构
                                    </th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                        aria-label="课程: activate to sort column ascending">
                                        课程
                                    </th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                        aria-label="教师: activate to sort column ascending">
                                        金额
                                    </th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                        aria-label="类别: activate to sort column ascending">
                                        类别
                                    </th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                        aria-label="描述: activate to sort column ascending">
                                        描述
                                    </th>
                                    <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                        aria-label="类别: activate to sort column ascending">
                                        时间
                                    </th>

                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach var="courseLog" items="${courseLogList}">
                                <tr onclick="">
                                    <td>
                                            ${courseLog.instiName}
                                    </td>
                                    <td>
                                            ${courseLog.cname}
                                    </td>
                                    <td>
                                            ${courseLog.money}
                                    </td>
                                    <td>
                                            ${courseLog.behaviour}
                                    </td>
                                    <td>
                                            ${courseLog.description}
                                    </td>
                                    <td>
                                            ${courseLog.modifyTime}
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

        <%--<div class="box box-info">--%>
            <%--<div class="box-header with-border">--%>
                <%--<h3 class="box-title">Line Chart</h3>--%>

                <%--<div class="box-tools pull-right">--%>
                    <%--<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>--%>
                    <%--</button>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="box-body">--%>
                <%--<div class="chart">--%>
                    <%--<canvas id="lineChart" style="height: 287px; width: 639px;" height="574" width="1278"></canvas>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!-- /.box-body -->--%>
        <%--</div>--%>
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

<script>

    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */

    //--------------
    //- AREA CHART -
    //--------------

    // Get context with jQuery - using jQuery's .get() method.
    // var areaChartCanvas = $("#areaChart").get(0).getContext("2d");
    // // This will get the first returned node in the jQuery collection.
    // var areaChart = new Chart(areaChartCanvas);
    var time = ${time};
    var statistics = ${statisticsData};

    console.log(time);
    console.log(statistics);

    var areaChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                label: "Electronics",
                fillColor: "rgba(210, 214, 222, 1)",
                strokeColor: "rgba(210, 214, 222, 1)",
                pointColor: "rgba(210, 214, 222, 1)",
                pointStrokeColor: "#c1c7d1",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: time
            },
            {
                label: "Digital Goods",
                fillColor: "rgba(60,141,188,0.9)",
                strokeColor: "rgba(60,141,188,0.8)",
                pointColor: "#3b8bba",
                pointStrokeColor: "rgba(60,141,188,1)",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(60,141,188,1)",
                data: statistics
            }
        ]
    };


    //Create the line chart
    // areaChart.Line(areaChartData, areaChartOptions);
    //-------------
    //- LINE CHART -
    //--------------
    var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas);
    var lineChartOptions = areaChartOptions;
    lineChartOptions.datasetFill = false;
    lineChart.Line(areaChartData, lineChartOptions);


    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    // pieChart.Doughnut(PieData, pieOptions);
</script>

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

<!-- DataTables -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugin/AdminLTE-2.3.11/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/fastclick/fastclick.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="../../plugin/AdminLTE-2.3.11/plugins/chartjs/Chart.min.js"></script>

<script src="../../js/studentCourse.js"></script>
<script src="../../js/studentGraph.js"></script>

</body>
</html>

