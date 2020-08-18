package bat.ke.qq.com.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */

public class AopMethodInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("=====方法调用前======");
		Long  start = System.currentTimeMillis();
		Object result = invocation.proceed();
		System.out.println("=====方法调用后======");
		System.out.println("调用时间：" +(System.currentTimeMillis()-start));
		return result;
	}
}
