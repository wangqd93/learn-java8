package com.bycsmys.character7;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author wangqd
 * @DATE 2020-02-28
 */
public class WordCountStream {
    private final int counter;
    private final boolean lastSpace;

    public WordCountStream(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCountStream accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            //当前是空格
            return lastSpace ? this : new WordCountStream(counter, true);
        } else {
            return lastSpace ? new WordCountStream(counter + 1, false) : this;
        }
    }

    public WordCountStream combine(WordCountStream wordCountStream){
        return new WordCountStream(counter + wordCountStream.counter,wordCountStream.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        final String SENTENCE = "NEl  mezzo del cammin  di nostra vita";

        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);

        WordCountStream wordCountStream = characterStream.reduce(new WordCountStream(0, true), WordCountStream::accumulate, WordCountStream::combine);
        System.out.println(wordCountStream.getCounter());

        System.out.println("-------------------");

        Spliterator<Character> spliterator = new WordCountSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        WordCountStream reduce = stream.reduce(new WordCountStream(0, true), WordCountStream::accumulate, WordCountStream::combine);
        System.out.println(reduce.getCounter());
    }
}


