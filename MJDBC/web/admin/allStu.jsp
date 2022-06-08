<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.Student" %>
<%@ page import="java.util.Iterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/alluser.css">
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
<h1 align="center">员工信息管理页面</h1>
<hr>
<a href="/main.jsp">返回</a>
<a href="/destorystu">注销</a>
<a href="/findscore"><button>工资管理</button></a>
<a href="/findcourse"><button>职位管理</button></a>

    <table>
        <thead>
        <tr>
            <td><input type="checkbox" onclick="allcheck(this);"></td>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>员工密码</td>
            <td>员工权限</td>
            <td>备注信息</td>
            <td>操作&nbsp;&nbsp;<input type="button" value="批量删除" onclick="delall();"/></td>
        </tr>
        </thead>

        <%
            List<Student> allStudent = (List<Student>)session.getAttribute("allStudent");
            System.out.println(allStudent);
            Iterator<Student> iterable = allStudent.iterator();
            while (iterable.hasNext()){
                Student student = new Student();
                student = iterable.next();
        %>
        <tr>
            <td><input type="checkbox" name="check" value=<%= student.getSid() %>></td>
            <td><%= student.getSid() %></td>
            <td><%= student.getSname() %></td>
            <td><%= student.getPassword() %></td>
            <td><%= student.getSuperuser() %></td>
            <td><%= student.getFlag() %></td>
            <td> <a href="updateStu.jsp?sid=<%= student.getSid()%>">修改</a> |
                <a href="deleteStu?sid=<%= student.getSid()%>">删除</a> </td>
        </tr>
        <%
            }
        %>
    </table>
    <script type="text/javascript" src="../js/allStu.js"></script>
</body>
</html>
