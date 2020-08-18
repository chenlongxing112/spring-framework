

import bat.ke.qq.com.bean.Fox;
import bat.ke.qq.com.config.AppConfig;
import bat.ke.qq.com.core.MyMapperProxy;
import bat.ke.qq.com.dao.AccountMapper;
import bat.ke.qq.com.dao.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;


/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class IOCTest {

	@Test
	public void test(){
		//ioc容器
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		// FactoryBean既可以是本身，也可以是特殊bean(getObject())
		//System.out.println(context.getBean("myFactoryBean"));
	//	System.out.println(context.getBean("&myFactoryBean"));

		// jdk动态代理
		UserMapper userMapper  = (UserMapper) context.getBean("userMapper");
		System.out.println(userMapper.query());

		userMapper.query();

		AccountMapper accountMapper = (AccountMapper) context.getBean("accountMapper");
		accountMapper.query();

		//  将userMapper交给spring管理

		// NoSuchBeanDefinitionException
		// BeanDefinition   承载bean属性的文件
		// BeanDefinitionMap   key: id/name  beanName  value: BeanDefinition

//		BeanFactory beanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();
//		// 注册BeanDefinition
////		BeanDefinition beanDefinition = new RootBeanDefinition(Fox.class);
////		((DefaultListableBeanFactory) beanFactory)
////				.registerBeanDefinition("fox",beanDefinition);
//
//		// singletonObjects 单例对象池   Map :  key: beanName value:  bean对象 object
//		((DefaultListableBeanFactory) beanFactory)
//				.registerSingleton("fox",new Fox());
//
//		context.getBean("fox");






	}



}
