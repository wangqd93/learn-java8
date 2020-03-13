package com.bycsmys.character7;

/**
 * @Author wangqd
 * @DATE 2020-02-28
 */
public class WordCount {

    public static void main(String[] args) {
        final String SENTENCE = "NEl  mezzo del cammin  di nostra vita";

        System.out.println(countWordsIteratively(SENTENCE));


    }


    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }
}
