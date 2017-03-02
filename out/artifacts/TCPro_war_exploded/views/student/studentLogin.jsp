<%--
  Created by IntelliJ IDEA.
  User: stonezhang
  Date: 2017/2/27
  Time: 下午9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><html>
<head>
    <meta charset="utf-8">
    <title>Login-Student</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
    <link rel="stylesheet" type="text/css" href="../../css/navbar.css">
    <link rel="stylesheet" type="text/css" href="../../WEB-INF/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
</head>

<body background="/img/R&L/LoginBackgroud.jpg">
<%--<body background="../../img/R&L/LoginBackgroud.jpg">--%>
<div>
    <section>
        <nav>
            <!--<div>header</div>-->
            <ul>
                <li data-xcoord="0px" class="active" onclick="toStudentPage()">学生用户</li>
                <li data-xcoord="160px" onclick="toInstitutionPage()">机构用户</li>
            </ul>
        </nav>
    </section>
</div>
<div class="container">
    <div class="cont_principal student" name="student">

        <div class="cont_centrar">
            <div class="cont_login">
                <form action="">
                    <div class="cont_tabs_login">
                        <ul class='ul_tabs'>
                            <li class="active"><a href="#" onclick="sign_in()">学生登录</a>
                                <span class="linea_bajo_nom"></span>
                            </li>
                            <li><a href="#up" onclick="sign_up()">学生注册</a>
                                <span class="linea_bajo_nom"></span>
                            </li>
                        </ul>
                    </div>

                    <div class="cont_text_inputs">
                        <input type="text" class="input_form_sign d_block active_inp"
                               placeholder="用户名" name="name" />

                        <input type="text" class="input_form_sign"
                               placeholder="银行卡号" name="bankid" />

                        <input type="password" class="input_form_sign d_block active_inp"
                               placeholder="密码" name="pass" />

                        <input type="password" class="input_form_sign"
                               placeholder="重复密码" name="conf_pass" />

                        <a href="#" class="link_forgot_pass d_block" >Forgot Password ?</a>
                        <div class="terms_and_cons d_none">
                            <p><input type="checkbox" name="terms_and_cons" /> <label>阅读并接受用户协议</label></p>
                        </div>
                    </div>

                    <div class="cont_btn">
                        <button class="btn_sign_in btn_sign" onclick="inputCheck()">登录</button>
                    </div>
                    <div class="cont_btn">
                        <button class="btn_sign_up btn_sign" style="display: none" onclick="inputCheck()">注册</button>
                    </div>

                </form>
            </div>

        </div>


    </div>

    <div class="cont_principal institution" style="display: none" name="institution">

        <div class="cont_centrar">
            <div class="cont_login">
                <form action="">
                    <div class="cont_tabs_login">
                        <ul class='ul_tabs'>
                            <li class="active"><a onclick="sign_in()">机构登录</a>
                                <span class="linea_bajo_nom"></span>
                            </li>
                            <li><a onclick="sign_up()">机构注册</a>
                                <span class="linea_bajo_nom"></span>
                            </li>
                        </ul>
                    </div>

                    <div class="cont_text_inputs">
                        <input type="text" class="input_form_sign d_block active_inp"
                               placeholder="机构名" name="name" />

                        <!--<input type="text" class="input_form_sign"-->
                        <!--placeholder="银行卡号" name="bankid" />-->

                        <input type="password" class="input_form_sign d_block active_inp"
                               placeholder="密码" name="pass" />

                        <input type="password" class="input_form_sign"
                               placeholder="重复密码" name="conf_pass" />

                        <a href="#" class="link_forgot_pass d_block" >Forgot Password ?</a>
                        <div class="terms_and_cons d_none">
                            <p><input type="checkbox" name="terms_and_cons" /> <label>阅读并接受用户协议</label></p>
                        </div>
                    </div>

                    <div class="cont_btn">
                        <button class="btn_sign_in btn_sign" onclick="inputCheck()">登录</button>
                    </div>
                    <div class="cont_btn">
                        <button class="btn_sign_up btn_sign" style="display: none" onclick="inputCheck()">注册</button>
                    </div>

                </form>
            </div>

        </div>


    </div>

</div>


</div>

<!-- jQuery 2.2.3 -->
<script src="../../WEB-INF/lib/AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../../WEB-INF/lib/AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
<script src="../../js/login.js"></script>
<script src="../../js/navbar.js"></script>
</body>
</html>
