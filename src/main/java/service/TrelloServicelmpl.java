package service;

import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class TrelloServicelmpl implements TrelloService {
    private static List<User> userList;
    static {
        userList = new ArrayList<>();
        userList.add(new User(1,"Cao1","cao1","cao1@gmail","levancao1","DongAnh1","001","Admin","Khong"));
        userList.add(new User(2,"Cao2","cao12","cao2@gmail","levancao2","DongAnh2","002","client","Khong"));
        userList.add(new User(3,"Cao3","cao123","cao3@gmail","levancao3","DongAnh3","003","client","Khong"));

    }
    private String jdbcUrl="jdbc:mysql://localhost:3306/trello";
    private String username="root";
    private String password="cao0974782521";

    private static final String GET_CUSTOMER_ALL="SELECT * FROM customer";
    private static final String INSERT_CUSTOMER="INSERT INTO customer(namecr,address,email) VALUE(?,?,?)";
    private static final String GET_CUSTOMER_GETBYID="SELECT * FROM customer WHERE id=?";
    private static final String UPDATE_CUSTOMER="UPDATE customer SET namecr=?,address=?,email=? where id=?; ";
    private static final String DELETE_CUSTOMER="DELETE FROM customer WHERE Id=?";

    private Connection getConnection()
    {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
         return new ArrayList<>(userList);
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Post post) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Post> findByName(String name) {
        return null;
    }
//    @Override
//    public List<Customer> findAll() {
//        List<Customer>customerslist=new ArrayList<>();
//        try
//        {
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_ALL);
//            //add dependenci
//            ResultSet rs=preparedStatement.executeQuery();
//            while(rs.next())
//            {
//                Customer customers=new Customer(rs.getInt("Id"),rs.getString("namecr"),rs.getString("address"),rs.getString("email"));
//                customerslist.add(customers);
//            }
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            //thiếu logger
//            //log4j để ghi log
//        }
//        return customerslist;
//    }
//
//    @Override
//    public void save(Customer customer) {
//        try
//        {
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
//            preparedStatement.setString(1,customer.getName());
//            preparedStatement.setString(2,customer.getAddress());
//            preparedStatement.setString(3,customer.getEmail());
//            preparedStatement.setInt(4, customer.getId());
//
//            //câu lệnh này dùng để update bản cập nhật mới
//
//            preparedStatement.executeUpdate();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Customer findById(int id) {
//        Customer customers=null;
//        try{
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_GETBYID);
//            preparedStatement.setInt(1,id);
//            ResultSet rs=preparedStatement.executeQuery();
//            while(rs.next())
//            {
//                customers=new Customer(rs.getInt("Id"),rs.getString("namecr"),rs.getString("address"),rs.getString("email"));
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return customers;
//    }
//
//    @Override
//    public void update(Customer customer) {
//        try
//        {
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
//            preparedStatement.setString(1,customer.getName());
//            preparedStatement.setString(2,customer.getAddress());
//            preparedStatement.setString(3,customer.getEmail());
//            preparedStatement.setInt(4, customer.getId());
//
//            //câu lệnh này dùng để update bản cập nhật mới
//
//            preparedStatement.executeUpdate();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void remove(int id) {
//        try
//        {
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
//            preparedStatement.setInt(1,id);
//            preparedStatement.executeUpdate();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void Insert(Customer customer) {
//        try
//        {
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
//            preparedStatement.setString(1,customer.getName());
//            preparedStatement.setString(2,customer.getAddress());
//            preparedStatement.setString(3,customer.getEmail());
//            preparedStatement.executeUpdate();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

}
