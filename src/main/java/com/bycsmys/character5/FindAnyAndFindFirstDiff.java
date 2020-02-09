package com.bycsmys.character5;

import java.util.Arrays;
import java.util.List;

/**
 * findAny 和 findAny 区别
 * 串行流没有区别
 * 并行流findAny 可能返回任意一个符合的元素
 *
 * @Author wangqd
 * @DATE 2020-02-09
 */
public class FindAnyAndFindFirstDiff {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.stream().findAny().ifPresent(System.out::println);
        list.stream().findFirst().ifPresent(System.out::println);

        System.out.println("------------------------");

        list.parallelStream().findAny().ifPresent(System.out::println);
        list.parallelStream().findFirst().ifPresent(System.out::println);


    }


}
