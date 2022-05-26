package interceptor;

import java.lang.reflect.Method;

/**
 *拦截器的接口
 */
public interface Interceptor {
    /**
     *
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 运行时参数
     * @return 判断是否有拦截器对象如果有(true)，调用拦截器around方法，如果没有(false)调用真实对象的方法
     */
    public boolean before(Object proxy, Object target, Method method, Object args);

    public  void around(Object proxy, Object target, Method method, Object args);

    public void after(Object proxy, Object target, Method method, Object args);
}
