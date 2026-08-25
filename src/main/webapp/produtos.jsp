<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.ProdutoModel" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #2c3e50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .vazio { color: #888; font-style: italic; }
        .acoes a { margin-right: 10px; }
        a { display: inline-block; margin-top: 20px; }
    </style>
</head>
<body>
    <h1>Lista de Produtos</h1>

    <a href="${pageContext.request.contextPath}/produtos/novo">➕ Novo Produto</a>

    <%
        List<ProdutoModel> produtos = (List<ProdutoModel>) request.getAttribute("produtos");
    %>

    <% if (produtos == null || produtos.isEmpty()) { %>
        <p class="vazio">Nenhum produto encontrado no banco de dados.</p>
    <% } else { %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% for (ProdutoModel p : produtos) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getNome() %></td>
                        <td>R$ <%= String.format("%.2f", p.getPreco()) %></td>
                        <td><%= p.getQuantidade() %></td>
                        <td class="acoes">
                            <a href="${pageContext.request.contextPath}/produtos/editar?id=<%= p.getId() %>">Editar</a>
                            <a href="${pageContext.request.contextPath}/produtos/excluir?id=<%= p.getId() %>" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>

    <a href="${pageContext.request.contextPath}/admin/">⬅ Voltar para a área logada</a>
</body>
</html>
