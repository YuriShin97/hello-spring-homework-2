package com.ktdsuniversity.edu.hellospringhomework2.todolist.vo;

import jakarta.validation.constraints.NotBlank;

public class TodoItemVO {
    private int id;

    @NotBlank
    private boolean isDone;

    @NotBlank
    private String todoSubject;
    @NotBlank
    private String deadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsdone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

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
