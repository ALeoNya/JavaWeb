package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.Score;
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
        Score score = new Score();
        Course course = new Course();

        score.setSid(req.getParameter("sid"));
        score.setCid(req.getParameter("cid"));

        course.setCid(req.getParameter("cid"));

        student.setSid(req.getParameter("sid"));
        student.setSname(req.getParameter("sname"));
        student.setPassword(req.getParameter("password"));
        student.setSuperuser(Integer.parseInt(req.getParameter("superuser")));
        student.setFlag(Integer.parseInt(req.getParameter("flag")));


        //2
        new StudentServiceMysqlImpl().insertStudent(student);
        new StudentServiceMysqlImpl().insertScore(score);
        new StudentServiceMysqlImpl().insertCourse(course);

        //3
        response.sendRedirect("/index.html");
    }

}
