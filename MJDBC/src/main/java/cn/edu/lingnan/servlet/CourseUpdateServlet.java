package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCourse")
public class CourseUpdateServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            //1
            Course course = new Course();
            course.setCid(req.getParameter("cid"));
            course.setCname(req.getParameter("cname"));
            course.setTname(req.getParameter("tname"));
            course.setFlag(Integer.parseInt(req.getParameter("flag")));

            System.out.println("[Debug] 修改员工信息为：" + course);
            new StudentServiceMysqlImpl().updateCourse(course);
            //3
            resp.sendRedirect("/queryallstu");

        }
}
