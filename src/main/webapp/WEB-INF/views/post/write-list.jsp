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
  <title>TalkHub-Post</title>
</head>
<body>
<h3> TalkHub-Post | <small> 글 목록 </small></h3>
<p>
  총 ${count}개의 글이 작성되어있습니다.
</p>
<c:forEach var="i" begin="1" end = "10">
  ${i}
  <c:if test="${i != 10}"> | </c:if>
</c:forEach>
<ul>
  <c:forEach var = "p" items = "${datas}">
    <li>
      <a href="${pageContext.request.contextPath}/read?code=${p.code}">
        <img src="${p.imageUrl}" alt="${p.name}" />
      </a>
      <span>${p.name}</span>
    </li>
  </c:forEach>
</ul>

</body>
</html>