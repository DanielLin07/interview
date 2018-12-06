package designpattern.proxy;


/**
 * 真实实体类（被代理类）
 *
 * @author lingengxiang
 * @date 2018/12/6 15:20
 */
public class Actor implements Person {

    private String content;

    public Actor(String content) {
        this.content = content;
    }

    @Override
    public void speak() {
        System.out.println(this.content);
    }
}
