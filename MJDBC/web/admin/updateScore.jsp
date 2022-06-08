<%@ page import="cn.edu.lingnan.pojo.Score" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 29235
  Date: 2022/6/8
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/alluser.css">

</head>
<body>
<h1 align="center">工资修改页面</h1>
<hr>
<a href="allStu.jsp">返回</a>
<form action="/updateScore">
    <table>
        <thead>
        <tr>
            <td>留空</td>
            <td>员工编号</td>
            <td>职位工号</td>
            <td>工资</td>
            <td>操作</td>
        </tr>
        </thead>

        <%
            String sid = request.getParameter("sid");
            List<Score> allScore = (List<Score>)session.getAttribute("allScore");
            Iterator<Score> iterable = allScore.iterator();
            while (iterable.hasNext()){
                Score score = new Score();
                score = iterable.next();
                if (score.getSid().equals(sid)){
        %>
        <tr>
            <td></td>
            <td><input type="text" name="sid" value="<%= score.getSid() %>" readonly="true"></td>
            <td><input type="text" name="cid" value="<%= score.getCid() %>"></td>
            <td><input type="text" name="score" value="<%= score.getScore() %>"></td>
            <td><input type="submit" value="确认修改"></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
