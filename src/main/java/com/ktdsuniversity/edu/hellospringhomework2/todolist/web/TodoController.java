package com.ktdsuniversity.edu.hellospringhomework2.todolist.web;

import com.ktdsuniversity.edu.hellospringhomework2.todolist.service.TodoService;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.TodoItemListVO;
import com.ktdsuniversity.edu.hellospringhomework2.todolist.vo.WriteTodoItemVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    // TodoService 선언
    @Autowired
    private TodoService todoService;

    // TodoItem 전체 리스트를 보는 화면에 대한 핸들러
    @GetMapping("/todo/list")
    public String viewTodoList(Model model) {

        TodoItemListVO todoItemListVO = this.todoService.selectAllTodo();

        model.addAttribute("todoItemListVO", todoItemListVO);

        return "todo/todolist";
    }

    // 새로운 TodoItem 를 작성하는 화면에 대한 핸들러
    @GetMapping("/todo/write")
    public String viewTodoWritePage() {
        return "todo/todoWrite";
    }

    // 새로운 TodoItem 를 요청하는 화면에 대한 핸들러
    @PostMapping("/todo/write")
    public String doCreateNewTodo(@Valid WriteTodoItemVO writeTodoItemVO
                                 , BindingResult bindingResult
                                 , Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("todoItemListVO", writeTodoItemVO);
            return "todo/todoWrite";
        }

        boolean isCreate = this.todoService.createNewTodo(writeTodoItemVO);

        if (isCreate) {
            return "redirect:/todo/list";
        } else {
            model.addAttribute("writeTodoItemVO", writeTodoItemVO);
            return "todo/todoWrite";
        }
    }

    // 특정 TodoItem 을 삭제하는 요청에 대한 핸들러
    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        boolean isDeleted = this.todoService.deleteOneTodo(id);
        if (isDeleted) {
            return "redirect:/todo/list";
        } else {
            return "redirect:/todo/view/" + id;
        }
    }

    // 완료 버튼 처리에 관환 핸들러
    @GetMapping("/todo/done/{id}")
    public String doUpdateTodo(@PathVariable int id) {
        boolean isDone = this.todoService.isDoneTodo(id);
        if (isDone) {
            return "redirect:/todo/list";
        }
        return "redirect:/todo/list";
    }
}
