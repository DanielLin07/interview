package designpattern.proxy.staticproxy;

import designpattern.proxy.Actor;
import designpattern.proxy.Person;

/**
 * Actor代理类
 *
 * @author lingengxiang
 * @date 2018/12/6 15:21
 */
public class StaticActorProxy implements Person {

    private Actor actor;
    private String before;
    private String after;

    public StaticActorProxy(Actor actor, String before, String after) {
        this.actor = actor;
        this.before = before;
        this.after = after;
    }

    @Override
    public void speak() {
        // 方法增强
        System.out.println(this.before);
        // 实际方法
        this.actor.speak();
        // 方法增强
        System.out.println(this.after);
    }

    public static void main(String[] args) {
        Actor actor = new Actor("I AM AN ACTOR");
        StaticActorProxy actorProxy = new StaticActorProxy(actor, "HI", "BYE");
        actorProxy.speak();
    }
}
