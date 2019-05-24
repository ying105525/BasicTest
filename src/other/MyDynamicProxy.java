package other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * desc: XXXX
 *
 * @author Ying
 * Date: 2019/4/9
 * @version 1.0.0
 */
public class MyDynamicProxy {
        public static  void main (String[] args) {
            HelloImpl hello = new HelloImpl();
            MyInvocationHandler handler = new MyInvocationHandler(hello);
            // 构造代码实例
            Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
            // 调用代理方法
            proxyHello.sayHello();
        }

    interface Hello {
        void sayHello();
    }

    static class HelloImpl implements  Hello {
        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }

    static class MyInvocationHandler implements InvocationHandler {
        private Object target;
        public MyInvocationHandler(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("Invoking sayHello");
            Object result = method.invoke(target, args);
            return result;
        }
    }

}
