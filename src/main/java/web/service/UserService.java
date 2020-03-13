package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> allUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User getUserById(long id);
}
