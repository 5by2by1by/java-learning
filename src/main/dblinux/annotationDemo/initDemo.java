package main.dblinux.annotationDemo;

/**
 * @author dblinux
 * @Date 2022/6/4 15:32
 */
public class initDemo {
    @initMethod
    public void init(){
        System.out.println("init...");
    }

    @initMethod
    public void test(){
        System.out.println("test...");
    }
}
