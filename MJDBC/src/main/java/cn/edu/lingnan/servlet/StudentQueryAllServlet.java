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

public class StudentQueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //(2)
//        StudentServiceMysqlImpl studentService = new StudentServiceMysqlImpl();
//        Vector<Student>allStudent = studentService.findAllStudent();

        Vector<Student>allStudent = new StudentServiceMysqlImpl().findAllStudent();
        System.out.println("[Debug]查询所有学生信息，共有" +allStudent.size()+"条");
        HttpSession session = req.getSession();
        session.setAttribute("allStudent",allStudent);
        //(3)
        resp.sendRedirect("/admin/allStu.jsp");
    }
}
