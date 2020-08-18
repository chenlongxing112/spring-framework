package bat.ke.qq.com.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object object = methodProxy.invokeSuper(o, objects);

        return object;
    }


}