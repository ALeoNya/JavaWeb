package cn.edu.lingnan.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //留空
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //1 我要拿到用户权限
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Integer superuser = (Integer)session.getAttribute("superuser");
        System.out.println("[Debug] 权限过滤器中用户权限为" + superuser);
        //2 根据拿到的用户权限进行过滤 0为管理员，其他为用户
        if(superuser!=null){
            //登录了
            if (superuser.equals(0)){
                //登录了是管理员
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                //是普通用户
                resp.sendRedirect("/authority.jsp");
            }
        }else {
            //没登录
            resp.sendRedirect("/index.html");
        }

    }

    @Override
    public void destroy() {
        //留空
    }
}
