package com.bycsmys.character3;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <p>
 * lambda 表达式 对应的class 是什么
 * </p>
 *
 * 通过下面例子可以看出：
 * <p>1、lambda 表达式对应的class对象是lambda 的代理</p>
 * <p>2、lambda 表达式的superClass 是 Object</p>
 * <p>3、lambda 表达式的classloader 是 appClassLoader</p>
 * <p>4、lambda 表达式在用法上和匿名内部类很相似，但是对应的class不同</p>
 *
 * <p>相关lambda 如何编译可以查看stackoverflow</p>
 * @see <a href="https://stackoverflow.com/questions/16827262/how-will-java-lambda-functions-be-compiled">https://stackoverflow.com/questions/16827262/how-will-java-lambda-functions-be-compiled</a>
 * @see <a href="http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html">http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html</a>
 *
 *
 * @Author wangqd
 * @DATE 2020-02-02
 */
public class LambdaDefine {

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;

        System.out.println("consumer.getClass().getName():" + consumer.getClass().getName()); //com.bycsmys.character3.LambdaDefine$$Lambda$14/0x0000000800066840
        System.out.println("consumer.getClass().getSuperclass().getName():" + consumer.getClass().getSuperclass().getName());//java.lang.Object
        System.out.println("consumer.getClass().getClassLoader():" + consumer.getClass().getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@512ddf17

        System.out.println("------------------------");

        Function<String, Integer> function = Integer::parseInt;
        System.out.println("function.getClass().getName()：" + function.getClass().getName()); //com.bycsmys.character3.LambdaDefine$$Lambda$15/0x0000000800066c40
        System.out.println("function.getClass().getSuperclass().getName():" + function.getClass().getSuperclass().getName()); //java.lang.Object
        System.out.println("function.getClass().getClassLoader():" + function.getClass().getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@512ddf17

        System.out.println("-----------------------------");

        Consumer<String> innerConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        System.out.println("innerConsumer.getClass().getName():" + innerConsumer.getClass().getName());//com.bycsmys.character3.LambdaDefine$1
        System.out.println("nnerConsumer.getClass().getSuperclass().getName():" + innerConsumer.getClass().getSuperclass().getName());//java.lang.Object
        System.out.println("innerConsumer.getClass().getClassLoader():" + innerConsumer.getClass().getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@512ddf17
    }
}
