package com.bycsmys.character5;

import java.util.stream.IntStream;

/**
 * @Author wangqd
 * @DATE 2020-02-10
 */
public class ReduceTest {

    public static void main(String[] args) {
        // 1-100 和
        int reduce = IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
