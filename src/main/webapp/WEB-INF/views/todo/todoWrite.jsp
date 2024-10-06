<%--
  Created by IntelliJ IDEA.
  User: sinpyungho
  Date: 24. 9. 28.
  Time: 오전 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TodoList 작성하기</title>
    <link rel="stylesheet" type="text/css" href="/css/write.css">
</head>
<body>
<form class="div-group" method="post" action="/todo/write">
    <div class="grid">
        <label for="todoSubject">제목</label>
        <input
                id="todoSubject"
                type="text"
                name="todoSubject"
                placeholder="제목 입력" />
        <label for="deadline">기한</label>
        <input
                id="deadline"
                type="date"
                name="deadline"
                placeholder="기한 날짜 선택"/>

        <div class="btn-group">
            <div class="right-align">
                <button>저장</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
