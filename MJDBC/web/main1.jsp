
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通员工</title>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <link rel="stylesheet" type="text/css" href="./css/base.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<body>
<%--<h1>欢迎大家来到学生管理系统页面</h1>--%>
<%--欢迎您：${userName} 先生/女士--%>
<%--<hr>--%>
<%--<a href="/destorystu">注销</a>--%>
<%--<br><br>--%>
<%--<a href="/queryselfdata2">查看个人信息页面</a>--%>
    <div id="login-box" style="left: 600px;bottom: 200px;">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                <span class="login100-form-title p-b-49">个人信息主页面</span>
                <span >欢迎您：${userName} 先生/女士，您可以在这里查看您的员工信息</span>
                <hr>
            <a href="/queryselfdata2"><button>查看个人信息页面</button></a>
                <br><br>
                <a href="/destorystu">注销</a>
        </div>
    </div>
    <div id="vd" style="z-index:1">
        <img src="./images/1.png"  data-speed="-5" class="layer">
        <img src="./images/2.png" data-speed="5" class="layer">
        <img src="./images/3.png" data-speed="2" class="layer">
        <img src="./images/4.png" data-speed="6" class="layer">
        <img src="./images/5.png" data-speed="8" class="layer">
        <img src="./images/6.png" data-speed="-2" class="layer">
        <img src="./images/7.png" data-speed="4" class="layer">
        <img src="./images/8.png" data-speed="-9" class="layer">
        <img src="./images/9.png" data-speed="6" class="layer">
        <img src="./images/10.png" data-speed="-7" class="layer">
        <img src="./images/11.png" data-speed="-5" class="layer">
        <img src="./images/12.png" data-speed="5" class="layer">
    </div>
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/main.js"></script>
    <script src="./js/mouse2.js"></script>
</body>

</html>
