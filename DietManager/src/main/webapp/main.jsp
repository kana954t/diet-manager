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
<title>ホーム | Diet Manager</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Diet Manager</h1>
        <p class="subtitle">my daily diet log</p>

        <p>
            ようこそ、<%= loginUser.getName() %> さん
        </p>

        <h2>メニュー</h2>

        <ul>
            <li><a href="record.jsp">ダイエット記録を登録する</a></li>
            <li><a href="RecordServlet">記録一覧を見る</a></li>
            <li><a href="LogoutServlet">ログアウト</a></li>
        </ul>
    </div>
</body>
</html>