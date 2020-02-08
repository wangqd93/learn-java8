package com.bycsmys.character3;

import com.bycsmys.model.User;

import java.util.function.Function;

/**
 *
 * <p>方法引用</>
 * 方法引用存在三类：
 * 1、指向静态方法的方法引用（例如Integer的parseInt方法，写作Integer::parseInt）
 * 2、指向任意类型实例方法的方法引用（例如String的length方法，写作String::length）
 * 3、指向现有对象的实例方法的方法引用(假设你有一个局部变量expensiveTransaction用于存放Transaction类型对象，他支持实例方法getValue，那么你就可以些expensive-Transaction:;getValue。)
 *
 *
 *
 * 方法引用
 * @Author wangqd
 * @DATE 2020-02-06
 */
public class MethodReference {

    public static void main(String[] args) {

        //静态方法引用
        Function<String,String> staticMethodReference = MethodReference::appendHelloWorld;
        Function<String,String> lambdaExpression = s -> MethodReference.appendHelloWorld(s);

        //实例方法引用
        Function<String,String> instanceMethodReference = String::toUpperCase;
        Function<String,String> lamdaExpression2 = s -> s.toUpperCase();

        //现有对象的实例方法的方法引用
        User user = new User();
        Runnable localVariableMethodReference = user::getUserName;
        Runnable lambdaExpression3 = () -> user.getUserName();


    }


    public static String appendHelloWorld(String s){
        return s + " hello world";
    }






}
