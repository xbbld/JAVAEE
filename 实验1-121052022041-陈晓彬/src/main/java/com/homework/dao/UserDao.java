package com.homework.dao;

import com.homework.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 23:35
 */

@Repository
public class UserDao {
    @Autowired
    private Connection conn ;

    public int insert(User user) {
        /**
         * todo: 写出对应的sql
         */
        String sql = "INSERT INTO user (userId, name , password,gender,salt,createTime) VALUES (?, ?, ?,?,?,?)" ;
        try (
                PreparedStatement ps =  conn.prepareStatement(sql) ;
                ){
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getGender());
            ps.setString(5, user.getSalt());
            ps.setDate(6, (Date) user.getCreateTime());
            ps.executeUpdate();
        } catch (Exception e) {
            /**
             * todo: 异常输出
             */
            e.printStackTrace();
        }
        return 1 ;
    }

    /**
     * todo: 实现登录
     * @param name
     * @param password
     * @return
     */
    public User login(String name, String password) {
        String sql = "SELECT * FROM user WHERE name=? AND password=?";
        try (
                PreparedStatement ps =  conn.prepareStatement(sql) ;
        ){
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("登入成功");
            } else{
                System.out.println("账户与密码不匹配");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null ;
    }

    /**
     * todo: 统计所有的用户数
     * @return
     */
    public int countAllUsers() {
        int num =0;
        String sql = "SELECT count(*) FROM user";
        try (
                PreparedStatement ps =  conn.prepareStatement(sql) ;
        ){
            ResultSet rs = ps.executeQuery();
            rs.next();
            num = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("有"+num+"位用户");
        return num;
    }

}
