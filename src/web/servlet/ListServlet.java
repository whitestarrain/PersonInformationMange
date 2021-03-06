package web.servlet;

import domain.Instructor;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liyu
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StudentService ss = new StudentServiceImpl();
        //查询数据库本来会和用户相关，这里只是一个小案例，直接展现数据库所有数据了。即使这里传了参其实也没使用
        Instructor loginInstructor = (Instructor) session.getAttribute("loginInstructor");
        session.setAttribute("studentList", ss.getStudent(loginInstructor));
        response.sendRedirect(request.getContextPath() + "/list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
