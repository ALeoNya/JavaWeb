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
        // V -> C : 获取页面传递过来的参数，使用HttpServletRequest对象
        String userName = req.getParameter("username");
        String password = req.getParameter("pass");
        System.out.println("userName =" + userName + ", password = " + password);
        //2 C -> M -> C ,调用业务逻辑处理数据，并且得到返回值
        Student student = new StudentServiceMysqlImpl().findStudentByNameAndPassword(userName,password);
        System.out.println("Student = " + student.toString());
        HttpSession session= req.getSession(); /*
                                                * 第一次访问的时候，发送请求到后端，在后台HttpSession session=req.getSession () ，
                                                * 那么第一次没有Session，那么就会由服务器创建一个HttpSession，
                                                * 并且将HttpSession对应的Sessionid绑定到http协议中响应回客户端。
                                                * */

        session.setAttribute("userName",userName);
        session.setAttribute("superuser",student.getSuperuser());
        //3 C -> V :依据返回值进行页面跳转
        String sname = student.getSname();
        Integer superuser = student.getSuperuser();
        if(sname != null&&superuser == 0){
            resp.sendRedirect("/main.jsp");
        }else if(sname != null&&superuser != 0) {
            resp.sendRedirect("/main1.jsp");
        }else {
            resp.sendRedirect("/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
