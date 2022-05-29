<%@ page import="cn.edu.lingnan.pojo.Student" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 29235
  Date: 2022/4/27
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type=text/css" href="../css/alluser.css">
</head>
<body>
    <h1 align="center">修改学生信息页面</h1><hr><br><br>
    <form action="/updatestu  ">
    <table>
        <thead>
        <tr>
            <td>留空</td>
            <td>学生编号</td>
            <td>学生姓名</td>
            <td>学生密码</td>
            <td>学生权限</td>
            <td>备注信息</td>
            <td>操作</td>
        </tr>
        </thead>
<%--        <%--%>
<%--            String sid =     request.getParameter("sid");--%>
<%--            Vector<Student> allStudent = (Vector<Student>)session.getAttribute("allStudent");--%>
<%--            Iterator<Student> iterator = allStudent.iterator();--%>
<%--            Student student = new Student();--%>
<%--            while(iterator.hasNext()){--%>
<%--                student = iterator.next();--%>
<%--                if(student.getSid().equals(sid)){--%>
<%--        %>--%>
<%--            <tr>--%>
<%--                <td>留空</td>--%>
<%--                <td><input type="hidden" name="sid" value="<%=student.getSid()%>"/><%=student.getSid()%> </td>--%>
<%--                <td><input type="text" name="sname" value="<%=student.getSname()%>"/></td>--%>
<%--                <td><input type="text" name="password" value="<%=student.getPassword()%>"/></td>--%>
<%--                <td><input type="text" name="superuser" value="<%=student.getSuperuser()%>"/></td>--%>
<%--                <td><input type="text" name="flag" value="<%=student.getFlag()%>"/></td>--%>
<%--                <td><input type="submit" value="确认修改"></td>--%>
<%--            </tr>--%>
<%--        <%--%>
<%--            }}--%>

<%--        %>--%>

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
            <td><input type="text" name="sname" value="<%= student.getSname() %>"></td>
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
