<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>TalkHub</title>
</head>
<body>

<h1>TalkHub</h1>
<hr/>
<h2>TalkHub 게시판</h2>
<ul>
  <c:forEach var="one" items="${posts}">
    <li style="display: flex; justify-content: space-between">
      <div>
        <a href="${pageContext.request.contextPath}/message?id=${one.id}">📝[${one.category}] ${one.title}</a>
      </div>
      <div >
        🌱 ${one.writer_id}  |  🕒 ${one.writed_at} |  👁‍ ${one.views} | ❤️ ${one.likes}
      </div>
    </li>

  </c:forEach>

  <form action="${pageContext.request.contextPath}/write" method="post">
    <p><button type = "submit">글쓰기</button></p>
  </form>
</ul>

</body>
</html>