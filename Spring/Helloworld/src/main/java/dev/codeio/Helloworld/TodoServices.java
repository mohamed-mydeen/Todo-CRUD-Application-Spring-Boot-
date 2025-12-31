package dev.codeio.Helloworld;

import dev.codeio.Helloworld.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {
    @Autowired
    private TodoRepository todoRepository;
    //createApi
    public Todo CreateTodo(Todo todo){
        return todoRepository.save(todo);
    }
    //getSpecificApi By Using ID
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not Found"));
    }
    //getAllApi
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
    //updateApi
    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }
    //deleteApi
    public void deleteById(Long id){
        todoRepository.delete(getTodoById(id));
    }



}
