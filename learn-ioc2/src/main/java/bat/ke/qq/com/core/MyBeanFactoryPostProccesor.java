package bat.ke.qq.com.core;

import bat.ke.qq.com.bean.Fox;
import bat.ke.qq.com.dao.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
//@Component
public class MyBeanFactoryPostProccesor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		// jdk 动态代理  UserMapper 接口
		UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class[]{UserMapper.class},
				new MyMapperProxy());

		beanFactory.registerSingleton("userMapper",userMapper);

	}
}
