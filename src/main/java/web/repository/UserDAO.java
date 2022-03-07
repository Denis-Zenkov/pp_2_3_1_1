package web.repository;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();

    void addUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
