package com.bycsmys.character3;

import com.bycsmys.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static com.bycsmys.util.ModelUtil.initUser;

/**
 * 方法引用事件
 *
 * @Author wangqd
 * @DATE 2020-02-08
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        List<User> users = initUser();

        initUser().stream().filter(user -> user.getAge() == 20 && "zhaoliu".equals(user.getUserName())).forEach(System.out::println);


        Predicate<User> userPredicate = user -> user.getAge() == 20;
        Predicate<User> negate = userPredicate.negate();

        Predicate<User> userAnd = userPredicate.and(user -> "zhaoliu".equals(user.getUserName()));
        Predicate<User> userOr = userPredicate.or(user -> "zhangsan".equals(user.getUserName()));


        System.out.println("-------------------");
        //sort 年龄逆序 名字重复则 名字正序
        users.sort(Comparator.comparing(User::getAge).reversed()
                .thenComparing(User::getUserName));

        users.forEach(System.out::println);

    }


}
