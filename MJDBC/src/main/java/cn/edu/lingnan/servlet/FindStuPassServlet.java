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
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        String userName = req.getParameter("username");
//        String sid = req.getParameter("sid");
//        System.out.println("userName =" + userName + ", sid = " + sid);
//
//
//
//        Vector<Student> vector = new StudentServiceMysqlImpl().findPass(userName,sid);
//        HttpSession session = req.getSession();
////        System.out.println("Student = " + vector.toString());
//        session.setAttribute("pass",vector.getClass());
//
//        response.sendRedirect("/findPass.jsp");//点击立即找回跳转到找回页面，方案一：不一定使用
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String sid = req.getParameter("sid");
        System.out.println("userName =" + userName + ", sid = " + sid);



        Vector<Student> vector = new StudentServiceMysqlImpl().findPass(userName,sid);
        HttpSession session = req.getSession();
//        System.out.println("Student = " + vector.toString());
        session.setAttribute("pass",vector);

        resp.sendRedirect("/findPass.jsp");//点击立即找回跳转到找回页面，方案一：不一定使用
    }
}
