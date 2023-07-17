package dev.demo.usersapi.services;

import dev.demo.usersapi.models.User;
import dev.demo.usersapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //Find user by Id
    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }
    //Create User
    public User createUser(User user) {
        return userRepository.save(user);
    }
    //Update user
    public User updateUser(String id, User user){
        user.setId(id);
        return userRepository.save(user);
    }
    //Delete user
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
