package main.controller;

import main.model.Todo;
import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {
    @Autowired
    TodoRepository todoRepository;
    @RequestMapping("/")
    public String index(Model model){
        Iterable<Todo>  todoIterable = todoRepository.findAll();
        ArrayList<Todo> todoList = new ArrayList<>();
        for(Todo todo : todoIterable){
            todoList.add(todo);
        }
        model.addAttribute("todoList", todoList);
        return "index";
    }
}
