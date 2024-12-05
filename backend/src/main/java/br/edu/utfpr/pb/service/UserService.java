package br.edu.utfpr.pb.service;

import br.edu.utfpr.pb.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User findByDisplayNameContaining(String displayName);
    User save(User user);
    List<User> findAll();
}
