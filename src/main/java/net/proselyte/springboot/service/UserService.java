package net.proselyte.springboot.service;

import net.proselyte.springboot.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    List<User>getListOfUsers();

    User saveUser(User user);

    void deleteUserById(Long id);
}
