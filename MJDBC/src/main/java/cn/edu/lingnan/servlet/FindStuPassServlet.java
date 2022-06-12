package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

public class FindStuPassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fp_userName = req.getParameter("username1");
        String fp_sid = req.getParameter("sid1");
        System.out.println("userName =" + fp_userName + ", sid = " + fp_sid);



        Vector<Student> vector = new StudentServiceMysqlImpl().findPass(fp_userName,fp_sid);
        HttpSession session = req.getSession();
        session.setAttribute("pass",vector);
        resp.sendRedirect("/getPass.jsp");//点击立即找回跳转到找回页面，方案一：不一定使用
    }
}
