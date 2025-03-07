package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.User;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts order by id desc ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post one = new Post();

                one.setId(rs.getInt("id"));
                one.setWriter_id(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setViews(rs.getInt("views"));
                one.setLikes(rs.getInt("likes"));

                one.setWrited_at(rs.getDate("writed_at"));
                one.setModified_at(rs.getDate("modified_at"));

                posts.add(one);

            }

            conn.close();
        } catch (Exception e) {
            System.out.println("PostDAO.create : " + e.toString());
        }
        return posts;
    }

    public Post findById(int postId) {
        Post one = null;

        try {

            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts where id=?");
            ps.setInt(1, postId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                one = new Post();
                one.setId(rs.getInt("id"));
                one.setWriter_id(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setViews(rs.getInt("views"));
                one.setLikes(rs.getInt("likes"));

                one.setWrited_at(rs.getDate("writed_at"));
                one.setModified_at(rs.getDate("modified_at"));

            }
            conn.close();
        } catch (Exception e) {
            System.out.println("UserDAO.create : " + e.toString());
        }
        return one;
    }

    // 조회수 증가 (by Id)
    public boolean increaseViewsById(int postId){
        boolean result = false;

        /*  try with resources statement/ close가 필요한 객체는 try 안에 적을 수 있음.
         */
        try(Connection conn = ConnectionFactory.open()){
            PreparedStatement ps = conn.prepareStatement("update posts set views = views + 1 where id =?");
            ps.setInt(1,postId);

            int r = ps.executeUpdate();
            if(r > 0){
                result = true;
            }

        }catch (Exception e){
            System.out.println("PostDAO.create : " + e.toString());
        }
        return result;
    }
    //좋아요
public boolean increaseLikesById(int postId){

        boolean result = false;
    try(Connection conn = ConnectionFactory.open()){
        PreparedStatement ps = conn.prepareStatement("update posts set likes = likes + 1 where id =?");
        ps.setInt(1,postId);

        int r = ps.executeUpdate();
        if(r > 0){
            result = true;
        }

    }catch (Exception e){
        System.out.println("PostDAO.create : " + e.toString());
    }
    return result;
}
}
