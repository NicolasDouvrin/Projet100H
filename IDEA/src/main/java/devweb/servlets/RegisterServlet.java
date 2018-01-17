package devweb.servlets;

import devweb.managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.swing.JOptionPane.showMessageDialog;

@WebServlet("/register")
public class RegisterServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        WebContext context = new WebContext(req, resp, req.getServletContext());

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("register", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String classe = req.getParameter("classe");
        String mdp = req.getParameter("password");
        try {
            MembreLibrary.getInstance().addMembre(email,nom,prenom,classe,mdp);
        } catch (IllegalArgumentException e) {
            resp.sendRedirect("error");
            showMessageDialog(null,"Erreur d'inscription");
            return;
        }
        resp.sendRedirect("login");
    }
}


