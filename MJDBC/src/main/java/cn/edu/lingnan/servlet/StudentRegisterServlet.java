package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerstu")
public class StudentRegisterServlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //1
        Student student = new Student();
        student.setSid(req.getParameter("sid"));
        student.setSname(req.getParameter("sname"));
        student.setPassword(req.getParameter("password"));
        student.setSuperuser(Integer.parseInt(req.getParameter("superuser")));
        student.setFlag(Integer.parseInt(req.getParameter("flag")));
        //2
        new StudentServiceMysqlImpl().insertStudent(student);
        //3
        response.sendRedirect("/index.html");
    }

}
