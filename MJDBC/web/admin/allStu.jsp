<%@ page import="cn.edu.lingnan.pojo.Student" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %><%--
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
    <h1 align="center">学生管理员</h1><hr><br><br>

    <table>
        <tr>
            <td>留空</td>
            <td>学生编号</td>
            <td>学生姓名</td>
            <td>学生密码</td>
            <td>学生权限</td>
            <td>备注信息</td>
            <td>操作</td>
        </tr>
        <%
            Vector<Student> allStudent = (Vector<Student>)session.getAttribute("allStudent");
            Iterator<Student> iterator = allStudent.iterator();
            Student student = new Student();
            while(iterator.hasNext()){
                student = iterator.next();
        %>
        <tr>
            <td>留空</td>
            <td><%=student.getSid()%></td>
            <td><%=student.getSname()%></td>
            <td><%=student.getPassword()%></td>
             <td><%=student.getSuperuser()%></td>
            <td><%=student.getFlag()%></td>
            <td><a href="updateStu.jsp?sid=<%=student.getSid()%>">修改</a>|
                <a href="deleteStu.jsp?sid=<%=student.getSid()%>">删除</a></td>
        </tr>
        <%
            }

        %>
    </table>
</body>
</html>
