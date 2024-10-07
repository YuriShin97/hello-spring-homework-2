<%--
  Created by IntelliJ IDEA.
  User: sinpyungho
  Date: 24. 9. 28.
  Time: 오전 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TodoList 작성하기</title>
    <link rel="stylesheet" type="text/css" href="/css/write.css">
</head>
<body>
<form:form modelAttribute="writeTodoItemVO" method="post">
    <div>
        <form:errors path="todoSubject" element="div" cssClass="errors"/>
        <form:errors path="deadline" element="div" cssClass="errors"/>
        <c:if test="${not empty message}">
            <div class="errors">${message}</div>
        </c:if>
    </div>

    <div class="grid">
        <label for="todoSubject">제목</label>
        <input
                id="todoSubject"
                type="text"
                name="todoSubject"
                placeholder="제목 입력"
                value="${writeTodoItemVO.todoSubject}"/>
        <label for="deadline">기한</label>
        <input
                id="deadline"
                type="date"
                name="deadline"
                placeholder="기한 날짜 선택"
                value="${writeTodoItemVO.deadline}"/>

        <div class="btn-group">
            <div class="right-align">
                <input id="button" type="submit" value="등록" />
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
