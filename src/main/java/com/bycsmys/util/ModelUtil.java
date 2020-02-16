package com.bycsmys.util;

import com.bycsmys.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangqd
 * @DATE 2020-02-16
 */
public class ModelUtil {

    private ModelUtil() {

    }

    public static List<User> initUser() {
        List<User> users = new ArrayList<>();

        users.add(new User("zhangsan", 10));
        users.add(new User("lisi", 20));
        users.add(new User("wangwu", 30));
        users.add(new User("zhaoliu", 20));

        return users;
    }
}
