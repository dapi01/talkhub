package org.codenova.talkhub.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class PostDAO {

    public boolean create(String writer_id, String category, String title, String content) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database.c36ii4ae4s6v.ap-southeast-2.rds.amazonaws.com:3306/talkhub", "admin", "1q2w3e4r");

            PreparedStatement ps = conn.prepareStatement("insert into posts values(null,?,?,?,?,0,0,now(),now())");
            ps.setString(1, writer_id);
            ps.setString(2, category);
            ps.setString(3, title);
            ps.setString(4, content);

            int r = ps.executeUpdate();
            result = true;

            conn.close();

        } catch (Exception e) {
            System.out.println("PostDAO.create : " + e.toString());
        }
        return result;

    }
}
