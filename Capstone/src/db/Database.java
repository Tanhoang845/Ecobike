package db;

import utils.ENV;

import java.sql.*;
import java.util.logging.Logger;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 17:04
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class Database {
    public static final String HOST_URI = ENV.getenv("DB_HOSTNAME");
    public static final String USER = ENV.getenv("DB_USERNAME");
    public static final String PASSWORD = ENV.getenv("DB_PASSWORD");
    public static final String packagePath = "com.mysql.cj.jdbc.Driver";

    private static Connection connection;
    private static Database instance;

    private Database() {
        try {
            Class.forName(packagePath);
            connection = DriverManager.getConnection(HOST_URI, USER, PASSWORD);
            Logger.getLogger(getClass().getName()).info("Connect to database successfully!");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) instance = new Database();
        return instance;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        instance = null;
        Logger.getLogger(getClass().getName()).info("Connection closed!");
    }

    public static void main(String[] args) {
        Database db = Database.getInstance();
        try {
            Statement statement = db.createStatement();
            ResultSet set = statement.executeQuery("select * from rentbike");
            while (set.next()) {
                System.out.println(set.getTimestamp("RentedAt").getTime());
            }
            db.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
