package com.ktdsuniversity.edu.hellospringhomework2.todolist.vo;

import jakarta.validation.constraints.NotBlank;

public class WriteTodoItemVO {

    @NotBlank(message = "Todo 목표를 입력해주세요.")
    private String todoSubject;

    @NotBlank(message = "기한을 입력해주세요.")
    private String deadline;

    public String getTodoSubject() {
        return todoSubject;
    }

    public void setTodoSubject(String todoSubject) {
        this.todoSubject = todoSubject;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
