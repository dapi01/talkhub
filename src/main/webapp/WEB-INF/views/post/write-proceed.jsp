<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>TalkHub-Post</title>
</head>
<body>
<h2>TalkHub-Post</h2>
<c:choose>
    <c:when test="${success}">

        <div>
            <h4> 글 작성이 완료되었습니다.</h4>
            <a href="${pageContext.request.contextPath}/message">글 확인하기</a>
            <a href="${pageContext.request.contextPath}/post/list">목록으로</a>
        </div>
    </c:when>
    <c:otherwise>
        <div>
            <h4> 글 작성에 실패했습니다.</h4>
            <a href="${pageContext.request.contextPath}/write">다시 작성</a>
        </div>
    </c:otherwise>
</c:choose>
<p>
    TalkHub에 오신 것을 환영합니다!
</p>
</body>
</html>

