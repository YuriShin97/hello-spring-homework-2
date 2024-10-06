package com.ktdsuniversity.edu.hellospringhomework2.todolist.dao;

import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.WriteTodoItemVO;

import java.util.List;

public interface TodoDao {

    // DB 에 저장된 모든 TodoList 의 목록을 조회
    public List<TodoItemVO> selectAllTodo();

    // DB 에 새로운 TodoList 등록
    public int createNewTodo(WriteTodoItemVO writeTodoItemVO);

    // 특정 ID 를 가진 게시글을 삭제하는 메서드 정의
    public int deleteOneTodo(int id);

    // 완료 버튼 선택 시 완료 해주는 메서드 정의
    public int updateTodo(int id);
}
