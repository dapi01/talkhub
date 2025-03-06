<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 5.
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1>TalkHub</h1>
<h3> 토크허브에 회원가입하기 </h3>


<form action="${pageContext.request.contextPath}/join-proceed" method="post">

    <div>
        <label> 아이디 </label>

        <div>
            <input type="text"  name="id" value="${param.id}"/>
        </div>
        <c:if test="${idError != null}"/>
        <div style="color: red; font-size:small">${idError}</div>
    </div>

    <div>
        <label> 비밀번호 </label>
        <div>
            <input type="text"  name="password" value="${param.password}"/>
        </div>
        <c:if test="${passwordError != null}"/>
        <div style="color: red; font-size:small">${passwordError}</div>
    </div>
    <div>
        <label> 활동명 </label>
        <div>
            <input type="text"  name="nickname" value="${param.nickname}"/>
        </div>
        <c:if test="${nicknameError != null}"/>
        <div style="color: red; font-size:small">${nicknameError}</div>
    </div>
    <div>
        <label> 성별 </label>
        <div>
            <label><input type="radio" name="gender" value="남"/>남</label>
            <label><input type="radio" name="gender" value="여"/>여</label>
            <label><input type="radio" name="gender"  value="비공개"/>비공개</label>
            <c:if test="${genderError != null}"/>
            <div style="color: red; font-size:small">${genderError}</div>
        </div>
    </div>


    <div>
        <label> 출생년도 </label>
        <div>
            <select name="birth">
                <c:forEach var = "i" begin="1970" end="2025">
                    <option value="${i}">${i}년</option>
                </c:forEach>
            </select>

        </div>
    </div>
    <p style="color:red; font-size:small">
        ${error}
    </p>
    <p><button type = "submit">가입하기</button></p>
</form>
</body>
</html>
