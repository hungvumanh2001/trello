package service;

import model.Post;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrelloServicelmpl implements TrelloService {
    public TrelloServicelmpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trello?useSSL=false", "root", "06102001");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("Select * from user");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String address = rs.getString("address");
                String phonenumber = rs.getString("phonenumber");
                String role = rs.getString("role");
                String status = rs.getString("status");
                users.add(new User(id, username, password, email, fullname, address, phonenumber, role, status));
            }
        } catch (SQLException e) {
        }
        return users;
    }

    @Override
    public void add(User user) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("Insert into user(id, username, password, email, fullname, address, phonenumber, role, status) value(?, ?, ?, ?, ?, ?, ?, ?, ?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getFullname());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getPhonenumber());
            preparedStatement.setString(8, user.getRole());
            preparedStatement.setString(9, user.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public User checkLogin(String u, String p) {
        User userLogin = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where username = ? and password = ?");) {
            preparedStatement.setString(1, u);
            preparedStatement.setString(2, p);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String address = rs.getString("address");
                String phonenumber = rs.getString("phonenumber");
                String role = rs.getString("role");
                String status = rs.getString("status");
                userLogin = new User(id, u, p, email, fullname, address, phonenumber, role, status);
            }
        }
        catch (SQLException e) {
        }
        return userLogin;
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Post> findByName(String name) {
        return null;
    }

}
