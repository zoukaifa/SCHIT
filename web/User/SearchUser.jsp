<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/29
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Bootstrap.jsp"%>
    <title>好友搜索</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <form action="searchUser.action" method="post">
        请输入昵称进行搜索：
        <input type="text" name="nickname">
        <button type="submit">搜索</button>
    </form>
    <s:if test="%{userList != null}">
        <s:if test="%{userList.size() == 0}">
            没有用户！<br>
        </s:if>
        <s:else>
            <s:iterator value="userList">
                ${nickname}<br>
            </s:iterator>
            <nav>
                <ul class="pager">
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${1}">首页</a></li>
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${pageNumber-1}">上一页</a></li>
                    <li>${pageNumber}/${pageCount}</li>
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${pageNumber+1}">下一页</a></li>
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${pageCount}">末页</a></li>
                </ul>
            </nav>
        </s:else>
    </s:if>


</body>
</html>