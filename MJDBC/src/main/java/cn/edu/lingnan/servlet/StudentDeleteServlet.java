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
        String flag = req.getParameter("flag");
        System.out.println("[Debug]Number waiting to be deleted" + sid +" flag is£º "+flag);
        //2
        if(flag==null) {
            System.out.println("[Debug]Only one the number just waiting to be deleted is:" + sid);
            new StudentServiceMysqlImpl().deleteStudent(sid);
        }else {
            System.out.println("[Debug]More the number just waiting to be deleted is:" + sid);
            String[] split = sid.split(",");
            for (String s:split) {
                new StudentServiceMysqlImpl().deleteStudent(s);
            }
        }
        //3
        resp.sendRedirect("/queryallstu");
//        resp.sendRedirect("/admin/allStu.jsp");
    }
}
