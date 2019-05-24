package other.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * desc: XXXX
 *
 * @author Ying
 * Date: 2019/4/11
 * @version 1.0.0
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())) {
            System.out.println("------------这里是动态代理的方法中getName相等时内部----------------");
            System.out.println("------------Before---" + method.getName() + "----------------");
            Object object = method.invoke(target, args);
            System.out.println("------------After---" + method.getName() + "----------------");
            return object;
        } else {
            System.out.println("------------这里是动态代理的方法中Other时内部----------------");
            Object object = method.invoke(target, args);
            return object;
        }
    }
}
