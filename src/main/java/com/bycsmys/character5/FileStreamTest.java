package com.bycsmys.character5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 文件流
 *
 * @Author wangqd
 * @DATE 2020-02-10
 */
public class FileStreamTest {

    public static void main(String[] args) {

        try (Stream<String> lines = Files.lines(Paths.get("/Users/wangqd/code/github/learn-java8/src/main/resources/a.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
