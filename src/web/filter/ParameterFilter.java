package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liyu
 */
@WebFilter(value = {"/PageListServlet", "/SeachServlet"}, dispatcherTypes = {DispatcherType.FORWARD,
        DispatcherType.REQUEST})
public class ParameterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {

        ServletRequest proxy = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
                new Class[]{HttpServletRequest.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        // 因为是小项目就没有把这些数值存入文件，为了可扩展性最好把信息存入配置文件
                        Object result = method.invoke(req, objects);
                        if ("getParameter".equals(method.getName())) {
                            if ("row".equals(objects[0].toString())) {
                                return result != null ? result : "5";
                            }
                            if ("currentPage".equals(objects[0].toString())) {
                                if (result == null) {
                                    return "1";
                                } else if (Integer.parseInt(result.toString()) <= 0) {
                                    return "1";
                                }
                            }
                        }
                        return result;
                    }
                });
        chain.doFilter(proxy, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
