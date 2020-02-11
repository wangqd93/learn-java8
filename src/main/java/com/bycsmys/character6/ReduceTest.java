package com.bycsmys.character6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author wangqd
 * @DATE 2020-02-11
 */
public class ReduceTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world");


        String str1 = list.stream().collect(Collectors.joining(""));
        System.out.println(str1);

        System.out.println("-----------");

        String str2 = list.stream().collect(Collectors.reducing("", Function.identity(), String::concat));
        System.out.println(str2);

    }
}
