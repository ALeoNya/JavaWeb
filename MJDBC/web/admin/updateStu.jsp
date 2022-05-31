<%@ page import="cn.edu.lingnan.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/alluser.css">
</head>
<body>
<h1 align="center">学生信息修改页面</h1>
<hr>
<a href="allStu.jsp">返回</a>

<form action="/updatestu">
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
            String sid = request.getParameter("sid");
            List<Student> allStudent = (List<Student>)session.getAttribute("allStudent");
            Iterator<Student> iterable = allStudent.iterator();
            while (iterable.hasNext()){
                Student student = new Student();
                student = iterable.next();
                if (student.getSid().equals(sid)){
        %>
        <tr>
            <td></td>
            <td><input type="text" name="sid" value="<%= student.getSid() %>" readonly="true"></td>
            <td><input type="text" name="username" value="<%= student.getSname() %>"></td>
            <td><input type="text" name="password" value="<%= student.getPassword() %>"></td>
            <td><input type="text" name="superuser" value="<%= student.getSuperuser() %>"></td>
            <td><input type="text" name="flag" value="<%= student.getFlag() %>"></td>
            <td><input type="submit" value="确认修改"></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</form>
</body>
</html>
