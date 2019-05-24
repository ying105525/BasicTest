package other.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * desc: XXXX
 *
 * @author Ying
 * Date: 2019/4/11
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        TestService testServiceImpl =  new TestServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(testServiceImpl);
        TestService proxy = (TestService) Proxy.newProxyInstance(testServiceImpl.getClass().getClassLoader(),testServiceImpl.getClass().getInterfaces(),invocationHandler);
        System.out.println(proxy.getName());
        System.out.println(proxy.getDesc());
    }
}
