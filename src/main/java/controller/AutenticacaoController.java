package controller;

import java.io.IOException;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UsuarioModel;

@WebServlet(urlPatterns = {
        "/AutenticacaoController",
        "/login",
        "/logout"
})
public class AutenticacaoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AutenticacaoController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getServletPath();

        if (acao.equals("/logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String acao = request.getServletPath();

        if (acao.equals("/login")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            UsuarioModel usuario = UsuarioDAO.login(email, senha);

            if (usuario != null && usuario.getId() != null) {
                System.out.println(usuario.toString());

                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/admin/");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
    }
}
