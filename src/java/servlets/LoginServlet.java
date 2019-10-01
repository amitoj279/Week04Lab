package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.*;

/**
 *
 * @author 794473
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String s = request.getParameter("logout");
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("hUser");

        if (s == null) {
            if (username != null) {
                response.sendRedirect("home");
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            }
        } else if (s.equals("")) {
            session.invalidate();

            request.setAttribute("message", "You have successfully logged out.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService account = new AccountService();
        User check = account.login(username, password);

        if (check == null) {
            request.setAttribute("message", "Invalid Credentials");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("hUser", check.getUsername());
            response.sendRedirect("home");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
