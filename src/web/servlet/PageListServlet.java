package web.servlet;

import domain.PageBean;
import domain.Student;
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
@WebServlet("/PageListServlet")
public class PageListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String row=request.getParameter("row");
        if(currentPage==null){
            currentPage="1";
        }else if(Integer.parseInt(currentPage)<=0){
            currentPage="1";
        }

        if(row==null){
            row="5";
        }

        StudentService ss = new StudentServiceImpl();
        PageBean<Student> pb = ss.getStudentByPage(Integer.parseInt(row), Integer.parseInt(currentPage));
        HttpSession session = request.getSession();
        session.setAttribute("pageBean",pb);
        response.sendRedirect(request.getContextPath()+"/listByPage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
