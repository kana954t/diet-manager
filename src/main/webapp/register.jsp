<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録 | Diet Manager</title>
</head>
<body>
    <h1>Diet Manager</h1>
    <h2>新規登録</h2>

    <% String errorMsg = (String) request.getAttribute("errorMsg"); %>
    <% if (errorMsg != null) { %>
        <p style="color: red;"><%= errorMsg %></p>
    <% } %>

    <form action="RegisterServlet" method="post">
        <p>
            ユーザー名<br>
            <input type="text" name="name" required>
        </p>
        <p>
            パスワード<br>
            <input type="password" name="password" required>
        </p>
        <button type="submit">登録</button>
    </form>

    <p>
        <a href="login.jsp">ログイン画面に戻る</a>
    </p>
</body>
</html>