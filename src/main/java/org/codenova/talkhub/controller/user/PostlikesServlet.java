package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.dao.PostLikeDAO;
import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/like")
public class PostlikesServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id")); // 좋아요를 하고싶은 포스트 아이디
        PostLikeDAO postLikeDAO = new PostLikeDAO();

        User requester = (User)req.getSession().getAttribute("user"); // 현재 요청자의 아이디를 뽑아서
       List<PostLike> likes = postLikeDAO.findByUserId(requester.getId()); // 이 유저가 등록한 좋아요 목록을 가지고 온 후

        //검증 : 포스트 아이디를 좋아요 한적이 있는지 찾음.
        boolean alreadyLiked = false;
        for(PostLike like: likes){
            if(like.getPostId() == id ){
                alreadyLiked = true;
            }
        }
        // 반복처리가 끝나면, 이미 한적있으면 true, 아니면 false일것.
        if(!alreadyLiked){ // false라면 좋아요 처리되게 if 처리를 했음.
            PostDAO dao = new PostDAO();
            dao.increaseLikesById(id); // 좋아요가 올라감.

            PostLike log = PostLike.builder().userId(requester.getId()).postId(id).build();
            postLikeDAO.create(log);
        }

            resp.sendRedirect(req.getContextPath() + "/message?id="+id);

    }
}


