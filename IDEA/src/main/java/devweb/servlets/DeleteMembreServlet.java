package devweb.servlets;

import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delcompte")
public class DeleteMembreServlet extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        /*

        String email = (String) req.getAttribute("utilisateur");

        System.out.println(email);
        try {
            MembreLibrary.getInstance().deleteMembre(email);
            resp.sendRedirect("accueil");
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("deleteMembreErrorMessage", e.getMessage());
        }
            */

    }
}
