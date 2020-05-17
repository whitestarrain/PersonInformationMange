package web.servlet;

import domain.Instructor;
import org.apache.commons.beanutils.BeanUtils;
import service.InstructorService;
import service.impl.InstructorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author liyu
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        String checkcode = (String) request.getSession().getAttribute("checkcode");
        if (checkcode != null && checkcode.equalsIgnoreCase(request.getParameter("checkcode"))) {
            Map<String, String[]> map = request.getParameterMap();
            Instructor instructor = new Instructor();
            try {
                BeanUtils.populate(instructor, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            InstructorService service = new InstructorServiceImpl();
            Instructor loginInsturctor = service.login(instructor);
            if (loginInsturctor == null) {
                request.setAttribute("loginInfo", "用户名或密码错误");request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                //将登录的人的信息保存在Sessiong中
                //TODO Cookie保证Session持久化功能带完善
                request.getSession().setAttribute("loginInstructor", loginInsturctor);
                request.getRequestDispatcher("/PageListServlet").forward(request, response);
            }
        } else {
            request.setAttribute("checkcodeInfo", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        //登录验证完成后删除checkcode
        request.getSession().removeAttribute("checkcode");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
