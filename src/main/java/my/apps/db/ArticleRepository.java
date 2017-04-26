package my.apps.db;

import my.apps.web.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ArticleRepository {

    // 1. define connection params to db pg admin
      final static String URL = "jdbc:postgresql://54.93.65.5:5432/QA6_ANDREI";
      final static String USERNAME = "fasttrackit_dev";
      final static String PASSWORD = "fasttrackit_dev";

    // local host
//    final static String URL = "jdbc:mysql://localhost:3306/qa6-andrei";
//    final static String USERNAME = "root";
//    final static String PASSWORD = "";


    public void insert(Article article) throws ClassNotFoundException, SQLException {
        // 1. load the driver
//        FOR LOCAL HOST
//        Class.forName("com.mysql.jdbc.Driver");
//        FOR WEB DB
        Class.forName("org.postgresql.Driver");


        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO article( product, quantity) VALUES (?,?)");
        pSt.setString(1, article.getProduct());
        pSt.setInt(2, article.getQuantity());

        // 4. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();
//        ResultSet rs = pSt.executeQuery("SELECT product, quantity FROM article");
//        while (rs.next()) {
//            System.out.println("Inserted " + rowsInserted + " rows.");
//        }
//        // iterate the result set and print the values
//        List<Article> articles = new ArrayList<>();
//        while (rs.next()){
//            //TODO found usage for ->
//            /*Article article = new Article(
//                    rs.getString("product"),
//                    rs.getInt("quantity")
//            );
//
//            article.setId(rs.getLong("id"));
//            article.add(article);
//            */
//            System.out.println(rs.getString("product"));
//            System.out.println(rs.getInt("quantity"));
//        }

        System.out.println("Inserted " + rowsInserted + " rows.");

        // 5. close the objects
//        rs.close();
        pSt.close();
        conn.close();
    }

    public List<Article> read() throws ClassNotFoundException, SQLException {
        // 1. load the driver
        //        FOR LOCAL HOST
//        Class.forName("com.mysql.jdbc.Driver");
//        FOR WEB DB
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet rs = st.executeQuery("SELECT id, Product, Quantity FROM article");

        // 5. iterate the result set and print the values
        List<Article> articles = new ArrayList<>();
        while (rs.next()) {
            Article article = new Article(
                    rs.getString("Product"),
                    rs.getInt("Quantity")
            );
            article.setId(rs.getLong("id"));
            articles.add(article);

//            System.out.println("Product: " + rs.getString("product"));
//            System.out.println("Quantity: " + rs.getInt("quantity"));
            System.out.println(article);
        }

        // 6. close the objects
        rs.close();
        st.close();
        conn.close();
        return articles;
    }

    public void delete(Integer id) throws ClassNotFoundException, SQLException {
        // 1. load the driver
        //        FOR LOCAL HOST
//        Class.forName("com.mysql.jdbc.Driver");
//        FOR WEB DB
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM article where id = ?");
        pSt.setInt(1, id);


        // 4. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();
        System.out.println("Deleted " + rowsInserted + " rows.");

        // 5. close the objects
        pSt.close();
        conn.close();
    }
}

