<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuário</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        form { margin-top: 20px; }
        div { margin-bottom: 12px; }
        input { padding: 8px; width: 300px; }
        button { padding: 8px 16px; }
        .erro { color: red; }
    </style>
</head>
<body>
    <h1>Cadastro de Usuário</h1>

    <% if (request.getAttribute("erro") != null) { %>
        <p class="erro"><%= request.getAttribute("erro") %></p>
    <% } %>

    <form action="${pageContext.request.contextPath}/UsuarioController" method="post">
        <div>
            Nome: <input type="text" id="nome" name="nome" required>
        </div>
        <div>
            E-mail: <input type="email" id="email" name="email" required>
        </div>
        <div>
            Senha: <input type="password" id="senha" name="senha" required>
        </div>
        <div>
            <button type="submit">Registrar</button>
        </div>
    </form>

    <a href="${pageContext.request.contextPath}/login.jsp">Já tem conta? Faça login</a>
</body>
</html>
