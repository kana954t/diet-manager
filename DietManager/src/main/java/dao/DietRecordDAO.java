package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DietRecord;

public class DietRecordDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/diet_manager";
    private final String DB_USER = "root";
    private final String DB_PASS = "1234";

    public boolean create(DietRecord record) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO diet_records "
                        + "(user_id, record_date, weight, bmi, breakfast, lunch, dinner, exercise, memo) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setInt(1, record.getUserId());
                pStmt.setDate(2, Date.valueOf(record.getRecordDate()));
                pStmt.setDouble(3, record.getWeight());
                pStmt.setDouble(4, record.getBmi());
                pStmt.setString(5, record.getBreakfast());
                pStmt.setString(6, record.getLunch());
                pStmt.setString(7, record.getDinner());
                pStmt.setString(8, record.getExercise());
                pStmt.setString(9, record.getMemo());

                int result = pStmt.executeUpdate();

                return result == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<DietRecord> findByUserId(int userId) {
        List<DietRecord> recordList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String sql = "SELECT id, user_id, record_date, weight, bmi, breakfast, lunch, dinner, exercise, memo "
                        + "FROM diet_records WHERE user_id = ? ORDER BY record_date DESC";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setInt(1, userId);

                ResultSet rs = pStmt.executeQuery();

                while (rs.next()) {
                    DietRecord record = new DietRecord(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getDate("record_date").toLocalDate(),
                            rs.getDouble("weight"),
                            rs.getDouble("bmi"),
                            rs.getString("breakfast"),
                            rs.getString("lunch"),
                            rs.getString("dinner"),
                            rs.getString("exercise"),
                            rs.getString("memo")
                    );

                    recordList.add(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return recordList;
    }
}