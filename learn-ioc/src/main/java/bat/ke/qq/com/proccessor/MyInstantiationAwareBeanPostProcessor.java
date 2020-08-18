package bat.ke.qq.com.proccessor;

import bat.ke.qq.com.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//		if(beanClass.equals(User.class)){
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(beanClass);
//			enhancer.setCallback(new MethodInterceptor() {
//				@Override
//				public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//					return methodProxy.invokeSuper(o,objects);
//				}
//			});
//			Object proxy = enhancer.create();
//
//			System.out.println("代理对象:"+proxy);
//			return proxy;
//
//		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		if(beanName.equals("user")){
////			return false;
////		}
		return true;
	}
}
