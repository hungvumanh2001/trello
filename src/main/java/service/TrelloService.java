package service;

import model.Post;
import model.User;

import java.util.List;

public interface TrelloService {
    List<User> findAll();
    List<Post> findAllPost();
    void save(Post post);
    Post findById(int id);
    int findIndexById(int id);
    Post delete(int id);
    void update(int id,Post post);
    void remove(int id);
    List<Post> findByName(String name);
}
