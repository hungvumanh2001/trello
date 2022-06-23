package service;

import model.Post;
import model.User;

import java.util.List;

public interface TrelloService {
    List<User> findAll();
    void add(User user);
    User checkLogin(String username, String password);
    List<User> findByName(String username);
    void update(int id,User user);
    void remove(int id);
}
