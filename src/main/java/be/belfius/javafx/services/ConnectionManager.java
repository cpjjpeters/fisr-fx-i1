package be.belfius.javafx.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/fisr_database";
    private  Connection connection;
    public Connection Connect(){
        try {
            log.info("Connect");
            String url = "jdbc:mysql://localhost:3306/fisr_database";
            String user = "javauser";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return connection;
    }
//    public  Connection getConnection() {
//        log.info("trying getConnection");
//        if (connection == null) {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                connection = DriverManager.getConnection(URL, "javauser", "");
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }catch (Exception e){
//                log.error("other Exception");
//            }
//        }
//        return connection;
//    }
//    public void connect2DB()throws Exception{
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(URL , "javauser","");
//            System.out.println("connect2DB");
//            log.info("model= {}", connection.toString());
//
//        }catch (Exception e){
//            throw e;
//        }finally {
//            closeConnection();
//        }
//    }
    public  void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
