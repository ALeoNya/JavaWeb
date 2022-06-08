<%@ page import="cn.edu.lingnan.pojo.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/alluser.css">
</head>
<body>
    <h1 align="center">员工职位信息管理页面</h1>
    <hr>
    <a href="/main.jsp">返回</a>
    <a href="/destorystu">注销</a>

    <table>
        <thead>
        <tr>
            <td><input type="checkbox" onclick="allcheck(this);"></td>
            <td>岗位编号</td>
            <td>职位名称</td>
            <td>领导姓名</td>
            <td>备注</td>
            <td>操作&nbsp;&nbsp;<input type="button" value="修改" onclick="delall();"/></td>
        </tr>
        </thead>

        <%
            List<Course> allCourse = (List<Course>)session.getAttribute("allCourse");
            System.out.println(allCourse);
            Iterator<Course> iterable = allCourse.iterator();
            while (iterable.hasNext()){
                Course course = new Course();
                course = iterable.next();
        %>
        <tr>
            <td><input type="checkbox" name="check" value=<%= course.getCid() %>></td>
            <td><%= course.getCid() %></td>
            <td><%= course.getCname() %></td>
            <td><%= course.getTname() %></td>
            <td><%= course.getFlag() %></td>
            <td> <a href="updadteCourse.jsp?cid=<%= course.getCid()%>">修改</a> |
                <a href="deleteStu?sid=<%= course.getCid()%>">删除</a> </td>
        </tr>
        <%
            }
        %>
    </table>
    <script type="text/javascript" src="../js/allStu.js"></script>
</body>
</html>
