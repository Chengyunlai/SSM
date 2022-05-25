package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyHelloWorld implements InvocationHandler {
    private Object target = null;

    public Object bind(Object target){
        this.target = target;
        // newProxyInstance包含3个参数
        // 1. 类加载器，采用target本身的类加载器
        // 2. 把生成的动态代理对象下挂在哪些接口下，这个写法就是放在target实现的接口下，指的是HelloWorld
        // 3. 定义实现方法逻辑的代理类，this表示当前对象，它必须实现InvocationHandler接口的invoke方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy 代理对象，Bind方法生成的对象
     * @param method 调度当前的方法
     * @param args 调用方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object invoke = method.invoke(target, args);
        System.out.println("在调度真实对象之后的服务");
        return invoke;
    }
}
