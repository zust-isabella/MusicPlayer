package com.isabella.Servlet;

import com.isabella.DAO.UserDAO;
import com.isabella.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class RegServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行注册操作");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!username.equals("") || !password.equals("")){
            User user=new User();
            Integer id= 1 + ((int) (new Random().nextFloat() * 999));
            User exist=userDAO.getUserById(id.toString());
            while (exist!=null){
                System.out.println("获得id:"+id);
                id=1 + ((int) (new Random().nextFloat() * 999));
                exist=userDAO.getUserById(id.toString());
            }
            user.setId(Integer.toString(id));
            user.setUsername(username);
            user.setPassword(password);
            userDAO.addUser(user);
        }
    }
}
