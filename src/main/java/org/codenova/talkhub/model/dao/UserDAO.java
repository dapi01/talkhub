package org.codenova.talkhub.model.dao;
import org.codenova.talkhub.model.vo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDAO {
    public boolean create(String id, String password, String nickname, String gender, int birth) {
        boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://database.c36ii4ae4s6v.ap-southeast-2.rds.amazonaws.com:3306/talkhub",
                    "admin",
                    "gksmfqkek01!");

            PreparedStatement ps = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, now())");
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setString(4, gender);
            ps.setInt(5, birth);

            int r = ps.executeUpdate();
            result = true;

            conn.close();
        } catch (Exception e) {
            System.out.println("userDAO.create : " + e.toString());
        }
        return result;
    }// end boolean create(String id, String password,....)

    public User findById(String specificId){
        User one = null;

        return null;
    }

}
