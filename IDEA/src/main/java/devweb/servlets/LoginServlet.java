package devweb.servlets;



import devweb.managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setCharacterEncoding("UTF-8");

        WebContext context = new WebContext(req, resp, req.getServletContext());

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("login", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email1=req.getParameter("email1");
        String password1=req.getParameter("password1");
        String password2= MembreLibrary.getInstance().getMdp(email1);

        if (password2==null){
            password2="";
        }

        if (password2.equals(password1)) {
            req.getSession().setAttribute("utilisateurConnecte",email1);
            resp.sendRedirect("accueil");
        } else{
            resp.sendRedirect("error");
        }

    }
}

