package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CourseQueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentServiceMysqlImpl studentServiceMysql = new StudentServiceMysqlImpl();
        List<Course> allCourse = studentServiceMysql.findAllCourse();
        System.out.println("[Debug] StudentQueryAllServlet get there are "+ allCourse.size() +" students in total");
        HttpSession session = req.getSession();
        session.setAttribute("allCourse",allCourse);
        resp.sendRedirect("/admin/allCourse.jsp");
    }
}
