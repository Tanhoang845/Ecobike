package controller;

import factory.DBFactory;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 02:26
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class BaseController {
    private static DBFactory dbFactory;

    public static DBFactory getDbFactory() {
        return dbFactory;
    }

    public static void setDbFactory(DBFactory dbFactory) {
        BaseController.dbFactory = dbFactory;
    }
}
