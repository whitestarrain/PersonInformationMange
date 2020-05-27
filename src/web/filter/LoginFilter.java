package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liyu
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        //0 强制转换（一般都会）
        HttpServletRequest request = (HttpServletRequest) req;
        //1 获取资源请求路径
        String uri = request.getRequestURI();
        //2 判断是否包含登录相关路径
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/css/") || uri.contains("/js" +
                "/") || uri.contains("/font/") || uri.contains("/checkCode") || uri.contains("/index.html")
                || uri.equals(((HttpServletRequest) req).getContextPath()+"/")) {
            //包含，是为了登录，放行
            chain.doFilter(req, resp);
        } else {
            //不包含，检查是否已经登录
            Object loginInstructor = request.getSession().getAttribute("loginInstructor");
            if (loginInstructor != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("noLogin", "请先登录");
                //这里传入request还是req都行
                request.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
