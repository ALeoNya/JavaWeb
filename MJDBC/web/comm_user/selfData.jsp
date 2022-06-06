<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.Student" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.edu.lingnan.pojo.Course" %>
<%@ page import="cn.edu.lingnan.pojo.Score" %>
<%@ page import="cn.edu.lingnan.pojo.Self" %>
<%@ page import="java.util.Vector" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/alluser.css">

</head>
<body>
<h1 align="center">职工个人信息页面</h1>
<hr>
<a href="/main.jsp">返回主菜单</a>
<a href="/destorystu">注销</a>

<table>
    <thead>
    <tr>
        <td>职工编号</td>
        <td>职工姓名</td>
        <td>职工领导</td>
        <td>职位编号</td>
        <td>职工职位</td>
        <td>职工工资</td>
        <td>备注信息</td>
    </tr>
    </thead>

    <%
        String userName = (String) session.getAttribute("useName");
        Vector<Self> vector = (Vector<Self>) session.getAttribute("selfData");
        Iterator<Self> iterator = vector.iterator();
            Self self = iterator.next();
    %>
        <tr>
            <td><%= self.getSid() %></td>
            <td><%= self.getSname() %></td>
            <td><%= self.getTname() %></td>
            <td><%= self.getCid() %></td>
            <td><%= self.getCname() %></td>
            <td><%= self.getScore() %></td>
            <td><a>打印工资单</a></td>
        </tr>

</table>
</body>
</html>
