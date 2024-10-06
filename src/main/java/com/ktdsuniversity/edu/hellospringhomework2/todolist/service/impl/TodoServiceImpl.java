package com.ktdsuniversity.edu.hellospringhomework2.todolist.service.impl;

import com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.TodoDao;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.service.TodoService;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemListVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.WriteTodoItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    // 모든 TodoList 를 가져오는 메서드
    @Override
    public TodoItemListVO selectAllTodo() {

        TodoItemListVO todoItemListVO = new TodoItemListVO();

        todoItemListVO.setTodoItemList(this.todoDao.selectAllTodo());

        return todoItemListVO;
    }

    // 새로운 TodoList 를 생성하는 메서드
    @Override
    public boolean createNewTodo(WriteTodoItemVO writeTodoItemVO) {
        int createCount = this.todoDao.createNewTodo(writeTodoItemVO);

        return createCount > 0;
    }

    // 특정 TodoList 를 삭제하는 메서드
    @Override
    public boolean deleteOneTodo(int id) {
        int deleteCount = this.todoDao.deleteOneTodo(id);

        return deleteCount > 0;
    }

    @Override
    public boolean isDoneTodo(int id) {
        int updateCount = this.todoDao.updateTodo(id);

        return updateCount > 0;
    }
}
