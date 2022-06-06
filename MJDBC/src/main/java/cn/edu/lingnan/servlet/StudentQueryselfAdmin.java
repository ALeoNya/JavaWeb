package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Self;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StudentQueryselfAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println("userName =" + userName);/*
                                                    *从session里面获取到了userName
                                                    */
        StudentServiceMysqlImpl studentServiceMysql = new StudentServiceMysqlImpl();
        List<Self> selfData = studentServiceMysql.findSelfDataByName(userName);
        System.out.println("selfData = " + selfData.toString());

//        System.out.println("[Debug] StudentQueryself get there are " + selfData.size() + " students in total");


        session = req.getSession();
        session.setAttribute("selfData", selfData);
        session.setAttribute("userName",userName);

        resp.sendRedirect("/admin/selfData.jsp");
    }
}
