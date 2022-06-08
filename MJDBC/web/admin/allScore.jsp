<%@ page import="cn.edu.lingnan.pojo.Score" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/alluser.css">
</head>
<body>
    <h1 align="center">员工工资信息页面</h1>
    <hr>
    <a href="/main.jsp">返回</a>
    <a href="/destorystu">注销</a>

    <table>
        <thead>
        <tr>
            <td><input type="checkbox" onclick="allcheck(this);"></td>
            <td>员工编号</td>
            <td>员工工号</td>
            <td>员工工资</td>
            <td>操作&nbsp;&nbsp;<input type="button" value="修改" onclick="delall();"/></td>
        </tr>
        </thead>

        <%
            List<Score> allScore = (List<Score>)session.getAttribute("allScore");
//            System.out.println(allScore);
            Iterator<Score> iterable = allScore.iterator();
            while (iterable.hasNext()){
                Score score = new Score();
                score = iterable.next();
        %>
        <tr>
            <td><input type="checkbox" name="check" value=<%= score.getSid() %>></td>
            <td><%= score.getSid() %></td>
            <td><%= score.getCid() %></td>
            <td><%= score.getScore() %></td>
            <td> <a href="updateScore.jsp?sid=<%= score.getSid()%>">修改</a> |
                <a href="deleteStu?sid=<%= score.getSid()%>">删除</a> </td>
        </tr>
        <%
            }
        %>
    </table>
    <script type="text/javascript" src="../js/allStu.js"></script>
</body>
</html>
