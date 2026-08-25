package controller;

import java.io.IOException;
import java.util.List;

import dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProdutoModel;

@WebServlet(urlPatterns = { "/produtos", "/produtos/novo", "/produtos/editar", "/produtos/excluir" })
public class ProdutoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProdutoDAO produtoDao;

    @Override
    public void init() throws ServletException {
        produtoDao = new ProdutoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String acao = req.getServletPath();

        switch (acao) {
            case "/produtos":
                listar(req, resp);
                break;
            case "/produtos/novo":
                mostrarFormulario(req, resp, null);
                break;
            case "/produtos/editar":
                mostrarFormularioEdicao(req, resp);
                break;
            case "/produtos/excluir":
                excluir(req, resp);
                break;
            default:
                listar(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String acao = req.getServletPath();

        if ("/produtos/novo".equals(acao)) {
            salvar(req, resp);
        } else if ("/produtos/editar".equals(acao)) {
            atualizar(req, resp);
        } else {
            listar(req, resp);
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<ProdutoModel> produtos = produtoDao.listarTodos();
        req.setAttribute("produtos", produtos);
        req.getRequestDispatcher("/produtos.jsp").forward(req, resp);
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse resp, ProdutoModel produto)
            throws ServletException, IOException {

        req.setAttribute("produto", produto);
        req.getRequestDispatcher("/produto-form.jsp").forward(req, resp);
    }

    private void mostrarFormularioEdicao(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        ProdutoModel produto = produtoDao.buscarPorId(id);
        mostrarFormulario(req, resp, produto);
    }

    private void salvar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nome = req.getParameter("nome");
        double preco = Double.parseDouble(req.getParameter("preco"));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        ProdutoModel produto = new ProdutoModel();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);

        produtoDao.inserir(produto);
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }

    private void atualizar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        double preco = Double.parseDouble(req.getParameter("preco"));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        ProdutoModel produto = new ProdutoModel();
        produto.setId(id);
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);

        produtoDao.editar(produto);
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        produtoDao.deletar(id);
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}
