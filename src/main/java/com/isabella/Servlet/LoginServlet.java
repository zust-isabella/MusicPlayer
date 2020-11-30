package com.isabella.Servlet;

import com.isabella.DAO.UserDAO;
import com.isabella.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

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
        System.out.println("==执行登录操作==");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || password == null) System.out.println("参数缺失");
        System.out.println("username:" + req.getParameter("username") + "  " + "password:" + req.getParameter("password"));

        User user = userDAO.getUserByUsername(username);
        System.out.println("数据库数据："+user.toString());

        if (password.equals(user.getPassword())){
            System.out.println("登陆成功");
        }else {
            System.out.println("密码错误");
        }
    }
}
