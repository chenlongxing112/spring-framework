package bat.ke.qq.com.bean;

import bat.ke.qq.com.proccessor.MyInstantiationAwareBeanPostProcessor;
import bat.ke.qq.com.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		//((DefaultListableBeanFactory) beanFactory).registerSingleton("cat",new Cat());

		// 承载bean的属性的    class.newInstance()
		AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("user");
		// user -->cat  Cat.newInstance()   bat.ke.qq.com.bean.Cat@3c407114
		//beanDefinition.setBeanClassName("bat.ke.qq.com.bean.Cat");

		// 构造器贪婪模式
		// Autowiring mode  自动装配模式    xml     setter  constructor
		// @Autowired  field.set    setter  constructor
	    //beanDefinition.setAutowireMode(3);

		// 属性填充
		beanDefinition.getPropertyValues().add("name","fox");

		beanDefinition.getPropertyValues().add("age",30);


		//BeanDefinition cat = beanFactory.getBeanDefinition("cat");
		//cat.setBeanClassName("bat.ke.qq.com.bean.Fox");

		beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());



		beanFactory.registerSingleton("userService",new UserService());
	}
}
