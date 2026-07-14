package userregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userregistration.entity.User;
import userregistration.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){

        return repository.save(user);

    }

}

