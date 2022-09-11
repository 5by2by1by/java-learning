package main.dblinux.annotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dblinux
 * @Date 2022/6/4 15:19
 */

/*给注解添加元注解*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface initMethod {

}
