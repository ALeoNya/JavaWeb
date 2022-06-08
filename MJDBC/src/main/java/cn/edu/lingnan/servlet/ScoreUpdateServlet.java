package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateScore")
public class ScoreUpdateServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            //1
            Score score = new Score();
            score.setSid(req.getParameter("sid"));
            score.setCid(req.getParameter("cid"));
            score.setScore(Integer.parseInt(req.getParameter("score")));
            System.out.println("[Debug] 修改员工信息为："+ score);

            new StudentServiceMysqlImpl().updateScore(score);
            //3
            resp.sendRedirect("/queryallstu");
        }
}
