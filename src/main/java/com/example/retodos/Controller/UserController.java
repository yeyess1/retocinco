package com.example.retodos.Controller;

import com.example.retodos.Model.User;
import com.example.retodos.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService servicio;

    @GetMapping("/all")
    public List<User> Listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return servicio.getUser(id);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return servicio.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticateUser(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return servicio.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicio.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicio.delete(id);
    }

    @GetMapping("/birthday/{month}")
    public List<User> getByMonthBirthDay(@PathVariable("month") String month){
        return servicio.getByMonthBirthDay(month);
    }
}