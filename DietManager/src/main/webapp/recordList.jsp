<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.DietRecord" %>
<%
User loginUser = (User) session.getAttribute("loginUser");

if (loginUser == null) {
    response.sendRedirect("login.jsp");
    return;
}

List<DietRecord> recordList = (List<DietRecord>) request.getAttribute("recordList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記録一覧 | Diet Manager</title>
</head>
<body>
    <h1>Diet Manager</h1>
    <h2>記録一覧</h2>

    <% if (recordList == null || recordList.isEmpty()) { %>
        <p>まだ記録がありません。</p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>日付</th>
                <th>体重</th>
                <th>BMI</th>
                <th>朝食</th>
                <th>昼食</th>
                <th>夕食</th>
                <th>運動</th>
                <th>メモ</th>
            </tr>

            <% for (DietRecord record : recordList) { %>
                <tr>
                    <td><%= record.getRecordDate() %></td>
                    <td><%= record.getWeight() %> kg</td>
                    <td><%= record.getBmi() %></td>
                    <td><%= record.getBreakfast() %></td>
                    <td><%= record.getLunch() %></td>
                    <td><%= record.getDinner() %></td>
                    <td><%= record.getExercise() %></td>
                    <td><%= record.getMemo() %></td>
                </tr>
            <% } %>
        </table>
    <% } %>

    <p>
        <a href="record.jsp">記録を追加する</a>
    </p>

    <p>
        <a href="main.jsp">ホームに戻る</a>
    </p>
</body>
</html>