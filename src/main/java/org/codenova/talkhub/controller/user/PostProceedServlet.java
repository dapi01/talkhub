package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.dao.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/write-proceed")
public class PostProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String writerId = req.getParameter("writer_id");
        String category = req.getParameter("category");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        //=============================================================================================
        PostDAO postDAO = new PostDAO();

        boolean success = postDAO.create(writerId, category, title, content);

        //=========================================================================================
        if (success) {
            req.setAttribute("success",true);
        }else {
            req.setAttribute("success",false);
        }
        req.getRequestDispatcher("/WEB-INF/views/post/write-proceed.jsp").forward(req, resp);
    }
}