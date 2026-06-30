package model;

import dao.UserDAO;

public class LoginLogic {
    public User execute(String name, String password) {
        UserDAO dao = new UserDAO();
        User user = dao.findByNameAndPassword(name, password);
        return user;
    }
}