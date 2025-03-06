<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>TalkHub</h1>
<c:choose>
    <c:when test="${authentication}">

    <div>
        <a href="${pageContext.request.contextPath}/user/profile">마이페이지</a>
        <a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
    </div>
</c:when>
    <c:otherwise>
<div>
    <a href="${pageContext.request.contextPath}/login">로그인</a>
    <a href="${pageContext.request.contextPath}/join">회원가입</a>
</div>
</c:otherwise>
</c:choose>
<p>
  TalkHub에 오신 것을 환영합니다!
</p>
</body>
</html>
