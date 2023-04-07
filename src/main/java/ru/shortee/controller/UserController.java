package ru.shortee.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shortee.dto.UserDTO;
import ru.shortee.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @PostMapping("/registration")
    public ResponseEntity registration(@Valid @RequestBody UserDTO.Request.Registration request) {
        return ResponseEntity.ok(new UserDTO.Response.Registration(userService.registration(request)));
    }
}
