package com.akechsalim.springsecurity.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODO_LIST =
            List.of(
                    new Todo("akechsalim", "Learn AWS"),
                    new Todo("akechsalim", "Get AWS Certified")
            );

    @GetMapping("/todos")
    private static List<Todo> TODO_LIST() {
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    private Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    private void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("create{} for {}", todo,username);

    }

}

record Todo(String username, String description) {
}
