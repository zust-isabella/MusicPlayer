package com.isabella.DAO;

import com.isabella.Entity.User;
import com.isabella.Util.JdbcUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public boolean addUser (User user){
        Connection conn = JdbcUtil.getConnection();
        String sql = "insert into user(id,username,password,nickname,birthday,sign) values (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2,user.getUsername());
            stmt.setString(3,user.getPassword());
            stmt.setString(4,user.getNickname());
            stmt.setDate(5,user.getBirthday());
            stmt.setString(6,user.getSign());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            JdbcUtil.release(conn,stmt);
        }
        return true;
    }

    public User getUserByUsername (String username){
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setBirthday(resultSet.getDate("birthday"));
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getString("id"));
                user.setNickname(resultSet.getString("nickname"));
                user.setSign(resultSet.getString("sign"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.release(conn,stmt,resultSet);
        }
        return user;
    }

    public User getUserById (String id){
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setBirthday(resultSet.getDate("birthday"));
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getString("id"));
                user.setNickname(resultSet.getString("nickname"));
                user.setSign(resultSet.getString("sign"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.release(conn,stmt,resultSet);
        }
        return user;
    }


    @Test
    public void test(){
    }
}
