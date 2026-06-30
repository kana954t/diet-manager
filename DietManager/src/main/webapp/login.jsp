<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン | Diet Manager</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Diet Manager</h1>
        <p class="subtitle">my daily diet log</p>
        <h2>ログイン</h2>

        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p style="color: green;"><%= message %></p>
        <% } %>

        <% String errorMsg = (String) request.getAttribute("errorMsg"); %>
        <% if (errorMsg != null) { %>
            <p style="color: red;"><%= errorMsg %></p>
        <% } %>

        <form action="LoginServlet" method="post">
            <p>
                ユーザー名<br>
                <input type="text" name="name" required>
            </p>
            <p>
                パスワード<br>
                <input type="password" name="password" required>
            </p>
            <button type="submit">ログイン</button>
        </form>

        <p>
            <a href="RegisterServlet">新規登録はこちら</a>
        </p>
    </div>
</body>
</html>