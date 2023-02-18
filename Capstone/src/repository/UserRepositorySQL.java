package repository;

import db.Database;
import entity.user.User;
import exception.NotFoundException;
import exception.UserNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:37
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class UserRepositorySQL implements UserRepository {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findById(String id) throws UserNotFoundException {
        Database db = Database.getInstance();
        User user = null;
        try {
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user where ID='%s'".formatted(id));
            resultSet.next();
            user = new User(resultSet.getString("ID"), resultSet.getString("Name"),
                    resultSet.getString("UserName"), resultSet.getString("Password"));
        } catch (SQLException e) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }
}
