package jdkProxy.test;

import jdkProxy.JdkProxyHelloWorld;
import proxyInterface.HelloWorld;
import proxyInterface.impl.HelloWorldImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyHelloWorldTest {
    public static void main(String[] args) {
        //定义一个InvocationHandler实例，它负责实现接口的方法调用；
        //通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
        //使用的ClassLoader，通常就是接口类的ClassLoader；
        //需要实现的接口数组，至少需要传入一个接口进去；
        //用来处理接口方法调用的InvocationHandler实例。
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理对象执行");
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                System.out.println(declaredAnnotations);
                return null;
            }
        };
        HelloWorld helloWorld = (HelloWorld) Proxy.newProxyInstance(HelloWorld.class.getClassLoader(), new Class[]{HelloWorld.class},handler);
        helloWorld.sayHelloWorld();
    }
}
