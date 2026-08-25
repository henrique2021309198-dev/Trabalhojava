<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        form { margin-top: 20px; }
        input[type="text"] { padding: 8px; width: 300px; }
        button { padding: 8px 16px; margin-left: 8px; }
        nav { margin-top: 30px; }
    </style>
</head>
<body>
    <h1>Projeto Web com Servlet</h1>

    <p>Digite seu nome ou uma mensagem para receber uma saudação personalizada:</p>

    <!-- Formulário envia uma mensagem via GET para o SaudacaoServlet -->
    <form action="${pageContext.request.contextPath}/saudacao" method="get">
        <input type="text" name="mensagem" placeholder="Digite seu nome" required>
        <button type="submit">Enviar</button>
    </form>

    <nav>
        <a href="${pageContext.request.contextPath}/produtos">
            📦 Ver lista de produtos
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/registrar.jsp">
            📝 Registrar
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/login.jsp">
            🔐 Login
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/admin/">
            🔒 Área Logada
        </a>
    </nav>
</body>
</html>

