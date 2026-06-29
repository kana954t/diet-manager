<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");

if (loginUser == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録登録 | Diet Manager</title>
</head>
<body>
    <h1>Diet Manager</h1>
    <h2>ダイエット記録登録</h2>

    <% String errorMsg = (String) request.getAttribute("errorMsg"); %>
    <% if (errorMsg != null) { %>
        <p style="color: red;"><%= errorMsg %></p>
    <% } %>

    <form action="RecordServlet" method="post">
        <p>
            記録日<br>
            <input type="date" name="recordDate" required>
        </p>

        <p>
            身長（cm）<br>
            <input type="number" step="0.1" name="height" required>
        </p>

        <p>
            体重（kg）<br>
            <input type="number" step="0.1" name="weight" required>
        </p>

        <p>
            朝食<br>
            <input type="text" name="breakfast">
        </p>

        <p>
            昼食<br>
            <input type="text" name="lunch">
        </p>

        <p>
            夕食<br>
            <input type="text" name="dinner">
        </p>

        <p>
            運動内容<br>
            <input type="text" name="exercise">
        </p>

        <p>
            メモ<br>
            <textarea name="memo" rows="4" cols="40"></textarea>
        </p>

        <button type="submit">登録</button>
    </form>

    <p>
        <a href="main.jsp">ホームに戻る</a>
    </p>
</body>
</html>