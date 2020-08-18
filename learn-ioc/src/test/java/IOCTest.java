

import bat.ke.qq.com.bean.Fox;
import bat.ke.qq.com.bean.User;
import bat.ke.qq.com.config.AppConfig;
import bat.ke.qq.com.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 */
public class IOCTest {

	@Test
	public void test(){

		// ioc容器
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		//((AnnotationConfigApplicationContext) context).close();

		//NoSuchBeanDefinitionException
		// BeanDefinition   bean定义  承载bean的属性   init-method  scope
		// BeanDefinitionRegistry 注册器
		// registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
		// BeanDefinitionMap    key(beanName)  value: BeanDefinition（Fox.class）
		// beanFactoryPostProcessor
//		BeanFactory beanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();
		// 注册 Cat.class 的beanDefinition
		// 实现了 BeanDefinitionRegistry   BeanFactory
//		BeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
//		((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("cat",beanDefinition);

		// singletonObjects   map 缓存单例bean  beanName---singletonObject
//		Cat cat = new Cat();
//		((DefaultListableBeanFactory) beanFactory).registerSingleton("cat",cat);

		//System.out.println(context.getBean("myFactoryBean"));
	//	System.out.println(context.getBean("&myFactoryBean")); //  singletonObjects

	//	DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();



		context.getBean("userService");
	}

	@Test
	public void testXml(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		//NoSuchBeanDefinitionException   BeanDefinition
//		context.getBean("fox");
		// ResourceLoader
		///ResourceLoader resourceLoader = new DefaultResourceLoader();
		//Resource resource = resourceLoader.getResource("spring.xml");

		//BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		// beanFactory   BeanDefinitionRegistry
		DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

		BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
		beanDefinition.getPropertyValues().add("name","fox");
		//beanDefinition.setBeanClassName("bat.ke.qq.com.bean.Fox");
		registry.registerBeanDefinition("user",beanDefinition);
		
		//reader.loadBeanDefinitions(resource);

		System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

		System.out.println(registry.getBean("user")); //


	}

}
