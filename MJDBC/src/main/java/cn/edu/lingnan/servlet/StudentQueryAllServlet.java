package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StudentQueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 V->C param

        //2 C->M->C
        StudentServiceMysqlImpl studentServiceMysql = new StudentServiceMysqlImpl();
        List<Student> allStudent = studentServiceMysql.findAllStudent();
        System.out.println("[Debug] StudentQueryAllServlet 一共查询到" + allStudent.size() + "个学生");
        HttpSession session = req.getSession();
        session.setAttribute("allStudent",allStudent);
        //3 C->V
        resp.sendRedirect("/admin/allStu.jsp");
    }
}
