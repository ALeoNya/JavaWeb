package cn.edu.lingnan.servlet;

import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deletestu")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1
        String sid = req.getParameter("sid");
//        System.out.println("[Debug]��ɾ����ѧ�����Ϊ" + sid);
        //2
        new StudentServiceMysqlImpl().deleteStudent(sid);
        //3
        resp.sendRedirect("//queryallStudent");
    }
}
