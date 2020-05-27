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
import java.util.Map;

/**
 * @author liyu
 */
@WebServlet("/PageListServlet")
public class PageListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String row=request.getParameter("row");

        HttpSession session = request.getSession();
        if(null != request.getParameter("all")){
            session.removeAttribute("condition");
        }
        StudentService ss = new StudentServiceImpl();
        PageBean<Student> pb = ss.searchStudent((Map<String,String>)session.getAttribute("condition"),Integer.parseInt(row), Integer.parseInt(currentPage));
        session.setAttribute("pageBean",pb);
        response.sendRedirect(request.getContextPath()+"/listByPage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
