package com.ktdsuniversity.edu.hellospringhomework2.todolist.service;

import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemListVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.WriteTodoItemVO;

public interface TodoService {

    // 모든 TodoList 를 가져오는 메서드를 정의함.
    public TodoItemListVO selectAllTodo();

    // 새로운 TodoList 를 생성하는 메서드를 정의함.
    public boolean createNewTodo(WriteTodoItemVO writeTodoItemVO);

    // 특정 TodoList 를 삭제하는 메서드를 정의함.
    public boolean deleteOneTodo(int id);

    // 특정 TodoList 를 완료처리 해주는 메서드를 정의함.
    public boolean isDoneTodo(int id);
}
