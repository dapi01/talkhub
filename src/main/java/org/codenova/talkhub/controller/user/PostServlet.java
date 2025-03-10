package org.codenova.talkhub.controller.user;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/write")
public class PostServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");

        String writerId = user.getId();

        req.setAttribute("writer_id", writerId);

        req.getRequestDispatcher("/WEB-INF/views/post/write.jsp").forward(req, resp);
    }
}
