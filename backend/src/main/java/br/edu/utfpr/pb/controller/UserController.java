package br.edu.utfpr.pb.controller;

import br.edu.utfpr.pb.dto.UserDTO;
import br.edu.utfpr.pb.error.ApiError;
import br.edu.utfpr.pb.model.User;
import br.edu.utfpr.pb.service.UserService;
import br.edu.utfpr.pb.shared.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createUser(
            @RequestBody @Valid UserDTO user) {
        userService.save(modelMapper.map(user, User.class));
        return ResponseEntity.ok(new GenericResponse("User saved!"));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(modelMapper.map(user, UserDTO.class));
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> getUserByDisplayName(@RequestParam String displayName) {
        User user = userService.findByDisplayNameContaining(displayName);
        return ResponseEntity.ok(modelMapper.map(user, UserDTO.class));
    }
}
