package com.example.retodos.Repository;

import com.example.retodos.Crud.UserCrudRepository;
import com.example.retodos.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;


    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }


    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public User create (User user){
        return userCrudRepository.save(user);
    }

    public List<User> listar() {
        return userCrudRepository.findAll();
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public void update (User user){userCrudRepository.save(user);}

    public void delete(User user) {
        userCrudRepository.delete(user);
    }
}