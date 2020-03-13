package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> allUser();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User getUserById(long id);
}
