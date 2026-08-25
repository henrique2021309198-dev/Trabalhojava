<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.ProdutoModel" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Formulário de Produto</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        form { margin-top: 20px; }
        div { margin-bottom: 12px; }
        input { padding: 8px; width: 300px; }
        button { padding: 8px 16px; }
    </style>
</head>
<body>
    <h1>Produto</h1>

    <% 
        ProdutoModel produto = (ProdutoModel) request.getAttribute("produto");
        boolean edicao = (produto != null);
        String acao = edicao ? "editar" : "novo";
        String tituloBotao = edicao ? "Atualizar" : "Salvar";
    %>

    <form action="${pageContext.request.contextPath}/produtos/<%= acao %>" method="post">
        <% if (edicao) { %>
            <input type="hidden" name="id" value="<%= produto.getId() %>">
        <% } %>

        <div>
            Nome: <input type="text" name="nome" value="<%= edicao ? produto.getNome() : "" %>" required>
        </div>
        <div>
            Preço: <input type="number" step="0.01" name="preco" value="<%= edicao ? produto.getPreco() : "" %>" required>
        </div>
        <div>
            Quantidade: <input type="number" name="quantidade" value="<%= edicao ? produto.getQuantidade() : "" %>" required>
        </div>
        <div>
            <button type="submit"><%= tituloBotao %></button>
        </div>
    </form>

    <a href="${pageContext.request.contextPath}/produtos">⬅ Voltar para a lista</a>
</body>
</html>
