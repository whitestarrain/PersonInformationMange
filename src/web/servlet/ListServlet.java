package web.servlet;

import domain.Instructor;
import domain.Student;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liyu
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据库本来会和用户相关，这里只是一个小案例，直接展现数据库所有数据了。即使这里传了参其实也没使用
        Instructor instructor=(Instructor)request.getSession().getAttribute("loginInstructor");
        List<Student> students = new StudentServiceImpl().getStudent(instructor);
        request.getSession().setAttribute("studentList",students);
        response.sendRedirect(request.getContextPath()+"/list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
