<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        form { margin-top: 20px; }
        div { margin-bottom: 12px; }
        input { padding: 8px; width: 300px; }
        button { padding: 8px 16px; }
    </style>
</head>
<body>
    <h1>Login</h1>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div>
            E-mail: <input type="email" id="email" name="email" required>
        </div>
        <div>
            Senha: <input type="password" id="senha" name="senha" required>
        </div>
        <div>
            <button type="submit">Entrar</button>
        </div>
    </form>

    <a href="${pageContext.request.contextPath}/registrar.jsp">Criar conta</a>
</body>
</html>
