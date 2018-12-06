package designpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实际处理方法增强
 *
 * @author lingengxiang
 * @date 2018/12/6 15:29
 */
public class ActorHandler implements InvocationHandler {

    private Object proxy;

    public ActorHandler(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("HI");
        Object result = method.invoke(this.proxy, args);
        System.out.println("BYE");
        return result;
    }
}
