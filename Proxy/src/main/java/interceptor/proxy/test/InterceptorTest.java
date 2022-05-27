package interceptor.proxy.test;

import interceptor.proxy.InterceptorJdkProxy;
import proxy.proxyInterface.HelloWorld;
import proxy.proxyInterface.impl.HelloWorldImpl;

/**
 * @ClassName
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
public class InterceptorTest {
    public static void main(String[] args) {
        HelloWorld proxy= (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "interceptor.impl.InterceptorImpl");
        HelloWorld proxy1= (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), null);
        proxy.sayHelloWorld();
        System.out.println("===");
        proxy1.sayHelloWorld();
    }
}
