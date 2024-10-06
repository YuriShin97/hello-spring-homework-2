package com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.impl;

import com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.TodoDao;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.WriteTodoItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDaoImpl extends SqlSessionDaoSupport implements TodoDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    // DB 에 저장된 모든 TodoList 의 목록을 조회
    @Override
    public List<TodoItemVO> selectAllTodo() {
        return getSqlSession().selectList("com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.TodoDao.selectAllTodo");
    }

    @Override
    public int createNewTodo(WriteTodoItemVO writeTodoItemVO) {
        return this.getSqlSession().insert("com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.TodoDao.createNewTodo", writeTodoItemVO);
    }

    @Override
    public int deleteOneTodo(int id) {
        return this.getSqlSession().delete("com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.TodoDao.deleteOneTodo", id);
    }

    @Override
    public int updateTodo(int id) {
        return this.getSqlSession().update("com.ktdsuniversity.edu.hellospringhomework2.todolist.dao.TodoDao.updateTodo", id);
    }
}
