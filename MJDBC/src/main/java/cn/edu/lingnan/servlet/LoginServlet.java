package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //(1)��ȡҳ�洫�����Ĳ���
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.printf("[Debug] username = " + username + ",password = " + password);

            //(2)�������ݵ���ҵ���߼�
            
            StudentServiceMysqlImpl studentServiceMysql = new StudentServiceMysqlImpl();

            Student student = studentServiceMysql.findStudentNameAndPassword(username,password);
            String sname = student.getSname();
            System.out.printf("[Debug] ����ֵ sname = " + sname );
            HttpSession session = req.getSession();
            session.setAttribute("username",sname);
            //(3)ҳ����ת
            if(sname!=null){
                resp.sendRedirect("/main.jsp");
            }else{
                resp.sendRedirect("/error.html");
            }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
