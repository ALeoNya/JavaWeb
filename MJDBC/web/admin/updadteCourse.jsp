<%@ page import="cn.edu.lingnan.pojo.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/alluser.css">

</head>
<body>
<h1 align="center">职位修改页面</h1>
<hr>
<a href="allStu.jsp">返回</a>
<form action="/updateCourse">
    <table>
        <thead>
        <tr>
            <td>留空</td>
            <td>工号</td>
            <td>职位</td>
            <td>领导</td>
            <td>修改</td>
            <td>操作(删除和修改)</td>
        </tr>
        </thead>

        <%
            String cid = request.getParameter("cid");
            List<Course> allCourse = (List<Course>)session.getAttribute("allCourse");
            Iterator<Course> iterable = allCourse.iterator();
            while (iterable.hasNext()){
                Course course = new Course();
                course = iterable.next();
                if (course.getCid().equals(cid)){
        %>
        <tr>
            <td></td>
            <td><input type="text" name="cid" value="<%= course.getCid() %>" readonly="true"></td>
            <td><input type="text" name="cname" value="<%= course.getCname() %>"></td>
            <td><input type="text" name="tname" value="<%= course.getTname() %>"></td>
            <td><input type="text" name="flag" value="<%= course.getFlag() %>"></td>
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
