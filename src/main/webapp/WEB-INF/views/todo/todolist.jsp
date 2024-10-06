<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- JSTL 을 위한 Directive 선언 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TodoList 조회</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
</head>
<body>
<div class="grid">
    <table class="table">
        <thead>
        <tr>
            <th>번호</th>
            <th>완료?</th>
            <th>TODO Subject</th>
            <th>기한</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty todoItemListVO.todoItemList}">
                <c:forEach items="${todoItemListVO.todoItemList}" var="todoList">
                    <tr>
                        <td>${todoList.id}</td>
                        <c:choose>
                            <c:when test="${todoList.isdone == true}">
                                <td>DONE</td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                        <td>${todoList.todoSubject}</td>
                        <td>${todoList.deadline}</td>
                        <c:choose>
                            <c:when test="${todoList.isdone == false}">
                                <td><a href="/todo/done/${todoList.id}">완료</a></td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                        <td><a href="/todo/delete/${todoList.id}">삭제</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="6">TodoList가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <div class="btn-group">
        <div class="right-align">
            <a href="/todo/write">
                <input type="button" value="새 아이템 추가">
            </a>
        </div>
    </div>
</div>
</body>
</html>