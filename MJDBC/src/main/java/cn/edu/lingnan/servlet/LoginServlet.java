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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1 V -> C -> M -> C -> V
        // V -> C : ��ȡҳ�洫�ݹ����Ĳ�����ʹ��HttpServletRequest����
        String userName = req.getParameter("username");
        String password = req.getParameter("pass");
        System.out.println("userName =" + userName + ", password = " + password);
        //2 C -> M -> C ,����ҵ���߼��������ݣ����ҵõ�����ֵ
        Student student = new StudentServiceMysqlImpl().findStudentByNameAndPassword(userName,password);
        System.out.println("Student = " + student.toString());
        HttpSession session= req.getSession();
        session.setAttribute("userName",userName);
        session.setAttribute("superuser",student.getSuperuser());
        //3 C -> V :���ݷ���ֵ����ҳ����ת
        String sname = student.getSname();
        if(sname != null){
            resp.sendRedirect("/main.jsp");
        }else {
            resp.sendRedirect("/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
