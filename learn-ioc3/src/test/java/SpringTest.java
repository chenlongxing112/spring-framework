import bat.ke.qq.com.bean.*;
import bat.ke.qq.com.config.AppConfig;
import bat.ke.qq.com.proxy.FoxProxy;
import bat.ke.qq.com.service.MyService;
import bat.ke.qq.com.service.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class SpringTest {

	@Test
	public void test(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
//		System.out.println(context.getBean("myFactoryBean")); //getObject
//		System.out.println(context.getBean("&myFactoryBean")); //myFactoryBean
//

		// userService,userService2    UserService.class
		// beanDefinitionMap  beanName---beanDefinition
		//context.getBean(UserService.class);// type-beanName ---getBean(beanName)

//		UserService userService = (UserService) context.getBean("userService");
//
//		userService.find();


		//context.close();


//		// 拿到工厂
//		DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
//
//		//创建一个beanDefinition
//		RootBeanDefinition beanDefinition = new RootBeanDefinition(Monkey.class);
//
//		// 注册
//		beanFactory.registerBeanDefinition("monkey",beanDefinition);
//
//		//填充属性
//		//beanDefinition.getPropertyValues().add("name","xxxx");
//
//		// autowireMode==3  构造器贪婪模式
//		//beanDefinition.setAutowireMode(3);
//
//		System.out.println(context.getBean("monkey"));



	}

	@Test
	public void test2(){


		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("Spring.xml");

		context.getBean(Fox.class);

		//创建一个简单注册器   map  key---beanDefiniton
		//BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();

//		//创建一个实现了注册器的工厂   即是一个工厂，又是一个注册器
//		BeanDefinitionRegistry register = new DefaultListableBeanFactory();
//	//创建bean定义读取器
//		BeanDefinitionReader reader = new XmlBeanDefinitionReader(register);
//
//		reader.loadBeanDefinitions("spring.xml");
//
//		System.out.println(Arrays.toString(register.getBeanDefinitionNames()));
//		System.out.println(register.getBeanDefinition("fox22"));
//
//		System.out.println(((DefaultListableBeanFactory) register).getBean("fox22"));
//

// 创建资源读取器
//DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

// 装载Bean的定义

// 打印构建的Bean 名称
		//System.out.println(Arrays.toString(register.getBeanDefinitionNames());

// 工厂调用getBean方法
	//	System.out.println(register.getBean("user"));



	}



}
