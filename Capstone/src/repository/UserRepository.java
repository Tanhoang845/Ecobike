package repository;

import entity.user.User;
import exception.NotFoundException;
import exception.UserNotFoundException;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 22:56
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface UserRepository extends Repository<User> {
    @Override
    List<User> getAll();

    @Override
    User findById(String id) throws UserNotFoundException;

    @Override
    User save(User user);

    @Override
    void delete(User user);
}
