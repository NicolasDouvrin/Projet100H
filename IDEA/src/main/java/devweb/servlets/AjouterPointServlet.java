package devweb.servlets;


import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addpoint")
public class AjouterPointServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String email1 = req.getParameter("email");
        Integer point1 = Integer.parseInt(req.getParameter("points"));

        try {
            MembreLibrary.getInstance().addPoint(email1,point1);
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("addpointErrorMessage", e.getMessage());
        }
        resp.sendRedirect("tournoiadmin");

    }
}
