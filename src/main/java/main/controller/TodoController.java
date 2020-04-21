package main.controller;

import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todo-list/")
    public List<Todo> list(){
        Iterable<Todo> todoIterable = todoRepository.findAll();
        List<Todo> todoList = new ArrayList<>();
        for(Todo todo : todoIterable){
            todoList.add(todo);
        }
        return todoList;
    }

    @PostMapping("/todo-list/query={text}")
    public List<Todo> getSearch(@PathVariable String text){
        text = "%" + text + "%";
        List<Todo> todoList = todoRepository.findAllByNameIsLike(text);
        return todoList;
    }

    @PostMapping("/todo-list/")
    public int add(Todo todo) {
        Todo newTodo = todoRepository.save(todo);
        return newTodo.getId();
    }

    @GetMapping("/todo-list/{id}")
    public ResponseEntity<Todo> get(@PathVariable int id){
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(todoOptional.get());
    }

    @PutMapping(value = "todo-list/{id}")
    public ResponseEntity<Todo> put(@RequestParam Map<String, String> mapParam, @PathVariable int id){
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todoOptional.get().setName(mapParam.get("name"));
        todoOptional.get().setDescription(mapParam.get("description"));
        todoOptional.get().setDate(mapParam.get("date"));
        todoRepository.save(todoOptional.get());
        return ResponseEntity.ok(todoOptional.get());
    }

    @DeleteMapping("todo-list/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id){
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
