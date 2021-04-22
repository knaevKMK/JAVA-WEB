package knev.lern_spring_plus_db.web;


import knev.lern_spring_plus_db.exception.InvalidEntityException;
import knev.lern_spring_plus_db.models.User;
import knev.lern_spring_plus_db.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
@Slf4j

public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public Collection<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("{id}")
    public User getUsers(@PathVariable UUID id) {
        return service.getUserById(id);
    }

    @DeleteMapping("{id}")
    public User deleteUsers(@PathVariable UUID id) {
        return service.deleteUser(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = service.createUser(user);
        URI location = MvcUriComponentsBuilder.fromMethodName(UserController.class, "createUser", User.class)
                .pathSegment("{id}").buildAndExpand(created.getId()).toUri() ;
        log.info("User created: {}", location);
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        if(user.getId() != id) throw new InvalidEntityException(
                String.format("User ID=%s from path is different from Entity ID=%s", id, user.getId()));
        User updated = service.updateUser(user);
        log.info("User updated: {}", updated);
        return ResponseEntity.ok(updated);
    }
}
