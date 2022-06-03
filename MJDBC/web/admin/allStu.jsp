<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.Student" %>
<%@ page import="java.util.Iterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/alluser.css">

</head>
<body>
<h1 align="center">学生信息管理页面</h1>
<hr>
<a href="/main.jsp">返回</a>
<a href="/destorystu">注销</a>

<table>
    <thead>
    <tr>
        <td>留空(复选框)</td>
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>学生密码</td>
        <td>学生权限</td>
        <td>备注信息</td>
        <td>操作(删除和修改)</td>
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
        <td></td>
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
</body>
</html>
