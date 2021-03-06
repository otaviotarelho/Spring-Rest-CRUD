package edu.otaviotarelho.userservice.service;

import edu.otaviotarelho.userservice.domain.User;
import edu.otaviotarelho.userservice.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(new User(), "User not found"));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException(new User(), "User not found"));
    }

    public User insert(User obj){
        obj.setId(null);
        return userRepository.save(obj);
    }

    public User update(User obj){
        return userRepository.save(obj);
    }

    public void delete(Integer id){
        User user = findById(id);
        userRepository.delete(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
