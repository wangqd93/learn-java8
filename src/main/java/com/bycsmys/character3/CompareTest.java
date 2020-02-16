package com.bycsmys.character3;

import com.bycsmys.model.User;
import com.bycsmys.util.ModelUtil;

import java.util.Comparator;
import java.util.List;

/**
 * @Author wangqd
 * @DATE 2020-02-14
 */
public class CompareTest {

    public static void main(String[] args) {
        List<User> users = ModelUtil.initUser();

        //按照 age 排序
        users.sort(Comparator.comparing(User::getAge));

        //按照 age 倒序
        users.sort(Comparator.comparing(User::getAge).reversed());

        //按照 age 排序 相同则按照 name 排序
        users.sort(Comparator.comparing(User::getAge).thenComparing(User::getUserName));

    }



}
