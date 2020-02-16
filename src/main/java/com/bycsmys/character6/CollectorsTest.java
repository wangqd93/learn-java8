package com.bycsmys.character6;

import com.bycsmys.model.User;
import com.bycsmys.util.ModelUtil;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author wangqd
 * @DATE 2020-02-16
 */
public class CollectorsTest {

    public static void main(String[] args) {

        List<User> users = ModelUtil.initUser();

        // Collectors.toList()
        List<User> toListUsers = users.stream().collect(Collectors.toList());
        System.out.println("---------------");

        // Collectors.toSet()
        Set<User> toSetUsers = users.stream().collect(Collectors.toSet());
        System.out.println("---------------");

        // Collectors.toCollection 可以执行转换结果的类型
        Set<User> toCollectionUsers = users.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("---------------");

        // Collectors.counting() 同 users.stream().count();
        Long count = users.stream().collect(Collectors.counting());
        System.out.println("---------------");

        // 年龄求和
        Integer countAge = users.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println("---------------");

        // Collectors.summarizingInt 统计信息 包括count sum min max average
        IntSummaryStatistics intSummaryStatistics = users.stream().collect(Collectors.summarizingInt(User::getAge));

        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println("---------------");

        // Collectors.averagingInt 平均值
        Double avgAge = users.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println("---------------");

        //Collectors.joining 字符串拼接
        String userNameJoin = users.stream().map(User::getUserName).collect(Collectors.joining(";"));
        System.out.println("---------------");

        //Collectors.maxBy 获取最大值
        Optional<User> maxOptional = users.stream().collect(Collectors.maxBy(Comparator.comparing(User::getAge).thenComparing(User::getUserName)));
        System.out.println("---------------");

        //Collectors.minBy 获取最小值
        Optional<User> minOptional = users.stream().collect(Collectors.minBy(Comparator.comparing(User::getAge).thenComparing(User::getUserName)));
        System.out.println("---------------");

        //Collectors.reducing reduce 操作
        Integer ageSum = users.stream().collect(Collectors.reducing(0, User::getAge, Integer::sum));
        System.out.println("---------------");

        //Collectors.collectingAndThen 操作
        boolean isEmpty = users.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::isEmpty));
        System.out.println("---------------");

        //Collectors.groupingBy 根据age 分组
        Map<Integer, List<User>> ageUserMap = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("---------------");

        //Collectors.partitioningBy 根据age 分区
        Map<Boolean, List<User>> agePartition = users.stream().collect(Collectors.partitioningBy(user -> user.getAge() > 30));
        System.out.println("---------------");
    }
}
