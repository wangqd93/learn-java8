package com.bycsmys.character6;

import com.bycsmys.model.User;
import com.bycsmys.util.ModelUtil;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Author wangqd
 * @DATE 2020-02-18
 */
public class CollectorTest {


    public static void main(String[] args) {
        List<User> users = ModelUtil.initUser();
        users.parallelStream().collect(new Test<User>());

    }

    /**
     * Collector<T, A, R>
     *  T: 元素类型
     *  A: 归约运算的可变累积类型
     *  R: 结果类型
     * @param <T>
     */
    public static class Test<T> implements Collector<T, List<T>, List<T>> {

        /**
         * 建立新的结果容器
         *
         * @return
         */
        @Override
        public Supplier<List<T>> supplier() {
            System.out.println("Supplier");
            return ArrayList::new;
        }

        /**
         * 将元素添加到结果容器
         * 返回执行归约操作的函数。当遍历到流中第n个元素时，这个函数执行时，
         * 会有两个参数：保存归约结果的累加器（以收集了流中的前n-1个项目），还有第n个元素本身
         *
         * @return
         */
        @Override
        public BiConsumer<List<T>, T> accumulator() {
            System.out.println("accumulator");
            return List::add;
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            System.out.println("combiner");
            return (list1,list2) ->{
                list1.addAll(list2);
                return list1;
            };
        }

        /**
         * 对结果容器应用最终转换
         * @return
         */
        @Override
        public Function<List<T>, List<T>> finisher() {
            System.out.println("finisher");
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT, Characteristics.IDENTITY_FINISH));
        }
    }
}






