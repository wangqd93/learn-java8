package com.bycsmys.character5;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author wangqd
 * @DATE 2020-02-09
 */
public class IntStreamTest {

    public static void main(String[] args) {

        //输出100内 符合 a * a + b * b = c * c
        IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
                IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1.0 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        ).forEach((int[] array) -> System.out.println(Arrays.toString(array)));

        System.out.println("------------------");

    }
}
