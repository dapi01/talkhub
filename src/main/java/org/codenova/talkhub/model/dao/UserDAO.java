package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.User;

import java.sql.*;

/*
    user 테이블에 관련된 DB작업을 처리하게 될거임.
 */
public class UserDAO {

    //1. 데이터 등록
    // insert into users values(?, ?, ?, ?, ?, now() )
    public boolean create(String id, String password, String nickname, String gender, int birth) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database.c36ii4ae4s6v.ap-southeast-2.rds.amazonaws.com:3306/talkhub", "admin", "1q2w3e4r");

            PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?, now())");
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setString(4, gender);
            ps.setInt(5, birth);

            int r = ps.executeUpdate();
            result = true; // r값을 확인안하고 result 를 true로 설정한 이유?

            conn.close();

        } catch (Exception e) {
            System.out.println("UserDAO.create : " + e.toString());
        }
        return result;

    }//====================================

    public User findById(String specificId) {
        User one = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database.c36ii4ae4s6v.ap-southeast-2.rds.amazonaws.com:3306/talkhub", "admin", "1q2w3e4r");
            PreparedStatement ps = conn.prepareStatement("select * from users where id =?");
            ps.setString(1, specificId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                one = new User();
                one.setId(rs.getString("id"));
                one.setPassword(rs.getString("password"));
                one.setNickname(rs.getString("nickname"));
                one.setGender(rs.getString("gender"));
                one.setBirth(rs.getInt("birth"));
                one.setCreatedAt(rs.getDate("created_at"));

            }
            conn.close();
        } catch (Exception e) {
            System.out.println("UserDAO.findById : " + e.toString());
        }
        return one;
    }// end User findById(String specificId)


}
