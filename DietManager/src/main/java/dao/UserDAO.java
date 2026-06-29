package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/diet_manager";
    private final String DB_USER = "root";
    private final String DB_PASS = "1234";

    public User findByNameAndPassword(String name, String password) {
        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String sql = "SELECT id, name, password FROM users WHERE name = ? AND password = ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, name);
                pStmt.setString(2, password);

                ResultSet rs = pStmt.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String userName = rs.getString("name");
                    String userPassword = rs.getString("password");

                    user = new User(id, userName, userPassword);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean create(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO users (name, password) VALUES (?, ?)";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, user.getName());
                pStmt.setString(2, user.getPassword());

                int result = pStmt.executeUpdate();

                return result == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}