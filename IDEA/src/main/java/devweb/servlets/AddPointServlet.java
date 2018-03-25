package devweb.servlets;

import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/addpoint")
public class AddPointServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idemail = req.getParameter("emailjoueur");
        System.out.println("email :"+idemail);

        /*Integer nbpoint = Integer.parseInt(req.getParameter("nb-point"));
        System.out.println("nbpoint"+nbpoint);*/

        String idemail1="samuel.drilleau@hei.yncrea.fr";
        Integer nbpoint1=10;

        try {
            MembreLibrary.getInstance().addPoint(idemail1,nbpoint1);
            resp.sendRedirect("tournoiadmin");
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("addpointErrorMessage", e.getMessage());
        }

    }
}
