package dev.codeio.Helloworld;
//import org.springframework.web.bind.annotation.RestController;

import dev.codeio.Helloworld.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private TodoServices todoServices;

//    @GetMapping("/get")
//    String getTodo() {
//        return "todo";
//    }

    //Path variable
    //createTodo
    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoServices.CreateTodo(todo), HttpStatus.CREATED);
    }

    //getSpecific
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id) {
        try {
            Todo createTodo=todoServices.getTodoById(id);
            return new ResponseEntity<>(createTodo, HttpStatus.OK);
        }
        catch (RuntimeException exception){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    //getAllTodo
    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(todoServices.getTodos(),HttpStatus.OK);
    }

    //updateTodo
    @PutMapping
    ResponseEntity<Todo> updateTodo(@RequestBody Todo todo){
        return  new ResponseEntity<>(todoServices.updateTodo(todo),HttpStatus.OK);
    }

    //deleteTodo
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  Long id){
        todoServices.deleteById(id);
    }








    //Request Param/Parameter
//    @GetMapping
//    String getTodoIdParam(@RequestParam("param") long id) {
//        return "toDoIdParam " + id;
//    }

    //    @GetMapping("/create")//end-point
//    String getuserId(@RequestParam String userName,@RequestParam String  password){
//        return "toDo with UserName: "+userName+" Password: "+ password;
//    }




}


//@GetMapping("/create")//end-point
//String getuserId(@RequestBody String body){
//    return body;
//}
//
//
//}
