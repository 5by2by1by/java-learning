package main.dblinux.lambdaLearn;

import java.util.function.Supplier;

/**
 * @author dblinux
 * @Date 2022/6/9 7:35
 */
public class testFuntion {
    public static void main(String[] args) {
        Supplier<Integer> supplier = ()-> 1;

        System.out.println(supplier.get());
    }
}
