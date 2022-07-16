package com.devsuperior.movieflix.resource;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
       List<UserDTO> users = userService.findAllUsers();
       return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> findUserByProfile() {
        UserDTO dto = userService.findUserProfile();
        return ResponseEntity.ok().body(dto);
    }
}
