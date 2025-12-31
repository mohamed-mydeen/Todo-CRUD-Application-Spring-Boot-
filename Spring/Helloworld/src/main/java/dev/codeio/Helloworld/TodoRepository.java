package dev.codeio.Helloworld;

import dev.codeio.Helloworld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long>{

}
