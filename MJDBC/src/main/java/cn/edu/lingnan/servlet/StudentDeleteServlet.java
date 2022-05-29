package cn.edu.lingnan.servlet;

import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteStu")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1
        String sid = req.getParameter("sid");
        System.out.println("[]待删除的学生编号为" + sid);
        //2
        new StudentServiceMysqlImpl().deleteStudentBySid(sid);
        //3
        resp.sendRedirect("/queryallstu");


//        //1
//        String sid = req.getParameter("sid");
//        //2
//        boolean flag = new StudentServiceMysqlImpl().deleteStudentBySid(sid);
//        System.out.println(flag);
//        //3
//        resp.sendRedirect("/queryallstu");
    }
}
