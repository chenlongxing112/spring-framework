package bat.ke.qq.com.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Component
public class MyFactoryBean implements FactoryBean {



	public Object getObject(){
		return new ReentrantLock();
	}

	public Class getObjectType(){
		return ReentrantLock.class;
	}
}
