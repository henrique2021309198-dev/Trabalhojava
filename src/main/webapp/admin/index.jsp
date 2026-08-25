<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.UsuarioModel" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Área Logada</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        nav { margin-top: 20px; }
    </style>
</head>
<body>
    <h1>Área Protegida</h1>

    <%
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");

        if (usuario != null) {
            out.println("<p>Bem-vindo, " + usuario.getNome() + "</p>");
    %>
            <nav>
                <a href="${pageContext.request.contextPath}/produtos">📦 Gerenciar Produtos</a><br><br>
                <a href="${pageContext.request.contextPath}/logout">Sair</a>
            </nav>
    <%
        } else {
            out.println("Usuário não está logado.");
        }
    %>
</body>
</html>
