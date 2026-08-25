<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Saudação</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h2 { color: #2c3e50; }
        a { display: inline-block; margin-top: 20px; }
    </style>
</head>
<body>
    <h1>Resultado</h1>

    <!-- O servlet colocou o atributo "mensagem" no request -->
    <h2>Olá, ${mensagem}! Seja bem-vindo(a)!</h2>

    <a href="${pageContext.request.contextPath}/">⬅ Voltar para a página inicial</a>
</body>
</html>
