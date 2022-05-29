package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatestu")
public class StudentUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1
        Student student = new Student();

        System.out.println(req.getParameter("sid"));
        System.out.println(req.getParameter("sname"));

        student.setSid(req.getParameter("sid"));
        student.setSname(req.getParameter("sname"));
        student.setPassword(req.getParameter("password"));
        student.setSuperuser(Integer.parseInt(req.getParameter("superuser") ));
        student.setFlag(Integer.parseInt(req.getParameter("flag") ));
        System.out.println("[Debug]修改学生信息为" + student.toString());
        // 2
        new StudentServiceMysqlImpl().updateStudent(student);
        // 3
        resp.sendRedirect("/queryallstu");
    }



//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //1 V->C param
//
//        //2 C->M->C
//        StudentServiceMysqlImpl studentServiceMysql = new StudentServiceMysqlImpl();
//        List<Student> allStudent = studentServiceMysql.findAllStudent();
//        System.out.println("[Debug] StudentQueryAllServlet 一共查询到" + allStudent.size() + "个学生");
//        HttpSession session = req.getSession();
//        session.setAttribute("allStudent",allStudent);
//        //3 C->V
//        resp.sendRedirect("/admin/allStu.jsp");
//    }
}
