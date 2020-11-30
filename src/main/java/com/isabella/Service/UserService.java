package com.isabella.Service;

import com.isabella.DAO.UserDAO;
import com.isabella.Entity.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(){
        userDAO=new UserDAO();
    }

    public User login(String username,String password){
        User user=userDAO.getUserByUsername(username);
        if (user.getPassword().equals(password)){
            user.setPassword("");
            return user;
        }else {
            return null;
        }
    }

    public boolean reg(User user){
        return userDAO.addUser(user);
    }
}
