package com.bycsmys.character5;

import java.util.stream.Stream;

/**
 * 无限流
 *
 * @Author wangqd
 * @DATE 2020-02-10
 */
public class UnlimitedStreamTest {

    public static void main(String[] args) {
        //斐波那契数列
        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(20)
                .map(array -> array[0])
                .forEach(System.out::println);



    }
}
