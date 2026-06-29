package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.DietRecordDAO;
import model.DietRecord;
import model.RecordLogic;
import model.User;

@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        DietRecordDAO dao = new DietRecordDAO();
        List<DietRecord> recordList = dao.findByUserId(loginUser.getId());

        request.setAttribute("recordList", recordList);
        request.getRequestDispatcher("recordList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String recordDateStr = request.getParameter("recordDate");
        String weightStr = request.getParameter("weight");
        String heightStr = request.getParameter("height");
        String breakfast = request.getParameter("breakfast");
        String lunch = request.getParameter("lunch");
        String dinner = request.getParameter("dinner");
        String exercise = request.getParameter("exercise");
        String memo = request.getParameter("memo");

        LocalDate recordDate = LocalDate.parse(recordDateStr);
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        RecordLogic logic = new RecordLogic();
        double bmi = logic.calculateBmi(height, weight);

        DietRecord record = new DietRecord(
                loginUser.getId(),
                recordDate,
                weight,
                bmi,
                breakfast,
                lunch,
                dinner,
                exercise,
                memo
        );

        DietRecordDAO dao = new DietRecordDAO();
        boolean result = dao.create(record);

        if (result) {
            response.sendRedirect("RecordServlet");
        } else {
            request.setAttribute("errorMsg", "記録の登録に失敗しました。");
            request.getRequestDispatcher("record.jsp").forward(request, response);
        }
    }
}