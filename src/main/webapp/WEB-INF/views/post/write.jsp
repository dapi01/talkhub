<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1>TalkHub-Post</h1>
<h3> 토크허브에 글쓰기 </h3>


<form action="${pageContext.request.contextPath}/write-proceed" method="post">
    <div>
        <label> 작성자 아이디 </label>

        <div>
            <input type="text"  name="writerId"/>
        </div>
    </div>
    <div>
        <label> 카테고리 </label>
        <div>
            <label><input type="radio" name="category"  value="공지"/>공지</label>
            <label><input type="radio" name="category" value="음악"/>음악</label>
            <label><input type="radio" name="category" value="일상"/>일상</label>
            <label><input type="radio" name="category"  value="게임"/>게임</label>
            <label><input type="radio" name="category"  value="패션"/>패션</label>
        </div>
    </div>
    <div>
        <label> 제목 </label>
        <div>
            <input type="text"  name="title"/>
        </div>
    </div>
    <div>
        <label> 내용 </label>
        <div>
            <input type="text"  name="content"/>
        </div>
    </div>




    <p><button type = "submit">작성하기</button></p>
</form>
</body>
</html>

