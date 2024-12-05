package br.edu.utfpr.pb.service.impl;

import br.edu.utfpr.pb.model.User;
import br.edu.utfpr.pb.repository.UserRepository;
import br.edu.utfpr.pb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByDisplayNameContaining(String displayName) {
        return userRepository.findByDisplayNameContaining(displayName);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
