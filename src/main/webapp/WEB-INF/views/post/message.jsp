<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 7.
  Time: 오전 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub-Message</title>
</head>
<body>
<h2>TalkHub</h2>
<hr/>
<h3>[${post.category}] ${post.title}</h3>
<div>
    <div>작성자 ${post.writer_id}|</span> 작성일 ${post.writed_at}</div>
    <div>조회 ${post.views} |</span> 추천 ${post.likes} </div>
</div>
<hr/>
<p style="white-space: pre-wrap">${post.content }</p>
<hr/>
<a href="${pageContext.request.contextPath}/like?id=${post.id}">
    <input type="hidden" name="postId" value="${post.likes}">
    <p><button type = "button">추천</button></p>
</a>
<a href="${pageContext.request.contextPath}/post/list">
    <p><button type = "button">목록</button></p>
</a>
</body>
</html>
