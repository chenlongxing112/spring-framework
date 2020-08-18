package bat.ke.qq.com.core;

import bat.ke.qq.com.bean.User;
import bat.ke.qq.com.dao.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */

public class MyFactoryBean implements FactoryBean {

	private Class mapperInterface;

	public MyFactoryBean(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		// jdk 动态代理
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class[]{mapperInterface},
				new MyMapperProxy());
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
