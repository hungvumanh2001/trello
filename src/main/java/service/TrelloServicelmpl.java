package service;

import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TrelloServicelmpl implements TrelloService {
    private static List<User> userList;
    private static List<Post> postList;
    static {
        userList = new ArrayList<>();
        userList.add(new User(1,"Cao1","cao1","cao1@gmail","levancao1","DongAnh1","001","Admin","Khong"));
        userList.add(new User(2,"Cao2","cao12","cao2@gmail","levancao2","DongAnh2","002","client","Khong"));
        userList.add(new User(3,"Cao3","cao123","cao3@gmail","levancao3","DongAnh3","003","client","Khong"));

        postList = new ArrayList<>();
        postList.add(new Post(1,"Cao",1,"cao","cao","cao","cao","cao1","cao1"));
        postList.add(new Post(2,"Tuan",2,"tuan","tuan","tuan","tuan","cao2","cao2"));
        postList.add(new Post(2,"Linh",2,"linh","linh","linh","linh","cao2","cao2"));
    }
    private String jdbcUrl="jdbc:mysql://localhost:3306/trello";
    private String username="root";
    private String password="cao0974782521";

    private static final String GET_CUSTOMER_ALL="SELECT * FROM post";
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
    public List<Post> findAllPost() {
        return new ArrayList<>(postList);
    }

    @Override
    public void save(Post post) {
        postList.add(post);
    }

    @Override
    public Post findById(int id) {
        for (Post post: postList
        ) {
            if (post.getId()==id)
                return post;
        }
        return null;
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i=0;i<postList.size();i++)
        {
            if (postList.get(i).getId()==id)
            {
                index=i;
            }
        }
        return index;
    }

    @Override
    public Post delete(int id) {
        return postList.remove(findIndexById(id));
    }

    @Override
    public void update(int id, Post post) {
        int idexOf=findIndexById(id);
        postList.set(idexOf,post);
    }

    @Override
    public void remove(int id) {
        postList.remove(id);
    }

    @Override
    public List<Post> findByName(String name) {
        List<Post> list = new ArrayList<>();
        List<Post> searchList = new ArrayList<>();
        for (Post item:list
             ) {
            if (item.getTitle().toLowerCase().contains(name.toLowerCase().trim()))
            {
                Post post = item;
                searchList.add(post);
            }

        }
        return searchList;
    }
//    @Override
//    public List<Post> findAllPost() {
//        List<Post> customerslist=new ArrayList<>();
//        try
//        {
//            Connection connection=getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_ALL);
//            //add dependenci
//            ResultSet rs=preparedStatement.executeQuery();
//            while(rs.next())
//            {
//                Post customers=new Post(rs.getInt("id"),rs.getString("title"),rs.getInt("date_created"),rs.getString("content"),rs.getString("description"),rs.getString("authority"),rs.getString("status"),rs.getString("user_id"),rs.getString("type_id"));
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
