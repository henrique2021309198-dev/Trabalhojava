package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet que recebe uma mensagem do formulário e encaminha para uma página
 * que exibe a saudação.
 *
 * Métodos HTTP utilizados:
 * - doGet:  usado para solicitar dados (formulários simples, links).
 * - doPost: usado para enviar dados (formulários com dados sensíveis ou grandes).
 */
@WebServlet("/saudacao")
public class SaudacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Recebe o parâmetro "mensagem" enviado pelo formulário
        String mensagem = req.getParameter("mensagem");

        if (mensagem == null || mensagem.trim().isEmpty()) {
            mensagem = "Visitante";
        }

        // Adiciona a mensagem como atributo do request para a página JSP
        req.setAttribute("mensagem", mensagem);

        // Encaminha (forward) para a página saudacao.jsp
        req.getRequestDispatcher("/saudacao.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Configura o encoding para aceitar caracteres especiais
        req.setCharacterEncoding("UTF-8");

        // Também pode tratar POST redirecionando para o mesmo fluxo de GET
        doGet(req, resp);
    }
}
