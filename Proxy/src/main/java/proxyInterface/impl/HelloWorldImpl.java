package proxyInterface.impl;

import proxyInterface.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    public void sayHelloWorld() {
        System.out.println("你好 世界");
    }
    public void sayName(String name){
        System.out.println("你好"+name);
    }
}
