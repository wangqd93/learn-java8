package com.bycsmys.character5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author wangqd
 * @DATE 2020-02-09
 */
public class FlatMapTest {

    public static void main(String[] args) {

        // ["hello","world"] -> ["h","e","l","o","w","r","d"]
        Stream.of("hello", "world").map(s -> s.split(""))
                .flatMap(Stream::of).distinct()
                .forEach(System.out::println);

        System.out.println("--------------------");

        //[1,2,3] [3,4] -> [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        list.stream()
                .flatMap(l -> list2.stream().map(l2 -> "(" + l + "," + l2 + ")"))
                .forEach(System.out::println);

        System.out.println("-------");

        Stream.of("1","2","3").filter(i -> "4".equals(i))
                .findAny().ifPresentOrElse(FlatMapTest::print,()-> test());

    }


    public static void test(){
        return;
    }

    public static void print(String s){
        System.out.println(s);
    }




}

