package knev.lern_spring_plus_db.service;

import knev.lern_spring_plus_db.models.User;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UserService {
    Collection<User> getUsers();
    User getUserById(UUID id);
    User getUserByUsername(String username);
    User createUser(User user);
    User updateUser(User user);
    User deleteUser(UUID id);
    long getUsersCount();
    List<User> createUsersBatch(List<User> users);
}
