package main.dblinux.annotationDemo;
import java.lang.reflect.Method;

/**
 * @author dblinux
 * @Date 2022/6/4 15:21
 */
/* TODO 通过反射机制来运行注解*/
public class testAnnotation {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("main.dblinux.annotationDemo.initDemo");
        Method[] methods = clazz.getMethods();
        if(methods != null){
            for(Method method : methods){
                boolean isInitMethod = method.isAnnotationPresent(initMethod.class);
                if(isInitMethod){
                    method.invoke(clazz.getConstructor(null).newInstance(null), null);
                }
            }
        }
    }
}
