package interceptor.impl;

import java.lang.reflect.Method;

/**
 * 实现拦截器的接口
 */
public class InterceptorImpl implements interceptor.Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object args) {
        boolean flag = false;
        System.out.println("拦截器前的方法，判断是否有拦截器，现在返回的是:" + flag);
        return flag;
    }

    public void around(Object proxy, Object target, Method method, Object args) {
        System.out.println("拦截器的方法");
    }

    public void after(Object proxy, Object target, Method method, Object args) {
        System.out.println("拦截器执行后的方法");
    }
}
