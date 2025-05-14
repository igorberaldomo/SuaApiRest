package main.java.com.example.demo.controller;

import main.java.com.example.demo.service.UserService;
import main.java.com.example.demo.model.user;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class userController {

    private final UserService userService;
    
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> findByID(@PathVariable int id) {
        var user = userService.findByID(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<user> create(@RequestBody user user) {
        var userCreated = userService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}
