package com.bycsmys.character6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author wangqd
 * @DATE 2020-02-16
 */
public class PrimeTest {

    public static void main(String[] args) {

        // 获取100 以内的质数
        List<Integer> list = IntStream.range(2, 1000)
                .filter(i -> IntStream.range(2, i).noneMatch(j -> i % j == 0))
                .boxed().collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
