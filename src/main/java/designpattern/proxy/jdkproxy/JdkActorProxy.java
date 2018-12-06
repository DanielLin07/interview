package designpattern.proxy.jdkproxy;

import designpattern.proxy.Actor;
import designpattern.proxy.Person;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *
 * @author lingengxiang
 * @date 2018/12/6 15:27
 */
public class JdkActorProxy {

    /**
     * 返回一个代理对象
     *
     * @param interfaceClazz 代理类所实现的接口
     * @param object         被代理对象实例
     * @return 代理对象
     */
    public static Object getProxy(Class interfaceClazz, Object object) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                new Class[]{interfaceClazz}, new ActorHandler(object));
    }

    public static void main(String[] args) {
        Person person = (Person) JdkActorProxy.getProxy(Person.class, new Actor("I AM AN ACTOR"));
        person.speak();
    }

}
