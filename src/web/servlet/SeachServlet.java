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
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 */
@WebServlet("/SeachServlet")
public class SeachServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String row=request.getParameter("row");
        StudentService ss = new StudentServiceImpl();
        Map<String, String> conditionMap = new HashMap<String, String>();
        conditionMap.put("name", request.getParameter("name"));
        conditionMap.put("deptName", request.getParameter("deptName"));
        conditionMap.put("totCred", request.getParameter("totCred"));
        HttpSession session = request.getSession();
        session.setAttribute("condition", conditionMap);
        PageBean<Student> pb = ss.searchStudent(conditionMap, Integer.parseInt(row), Integer.parseInt(currentPage));
        session.setAttribute("pageBean",pb);
        response.sendRedirect(request.getContextPath()+"/listByPage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
