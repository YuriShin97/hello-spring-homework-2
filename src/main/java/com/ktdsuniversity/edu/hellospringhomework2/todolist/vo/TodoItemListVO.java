package com.ktdsuniversity.edu.hellospringhomework2.todolist.vo;

import java.util.List;

public class TodoItemListVO {

    private int todoCnt;
    private List<TodoItemVO> todoItemList;

    public int getTodoCnt() {
        return todoCnt;
    }

    public void setTodoCnt(int todoCnt) {
        this.todoCnt = todoCnt;
    }

    public List<TodoItemVO> getTodoItemList() {
        return todoItemList;
    }

    public void setTodoItemList(List<TodoItemVO> todoItemList) {
        this.todoItemList = todoItemList;
    }
}
