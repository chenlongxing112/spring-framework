package bat.ke.qq.com.postprocessor;

import bat.ke.qq.com.bean.Tiger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
//@Component
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		DefaultListableBeanFactory factory = (DefaultListableBeanFactory)beanFactory;
//		AbstractBeanDefinition beanDefinition = new RootBeanDefinition(Tiger.class);
//		beanDefinition.setPrimary(true);
//		//    mybatis-spring
//		factory.registerBeanDefinition("tiger22",beanDefinition);

		AbstractBeanDefinition beanDefinition  = (AbstractBeanDefinition)
				beanFactory.getBeanDefinition("monkey");

		//System.out.println("autowireMode:"+beanDefinition.getAutowireMode());

		beanDefinition.setAutowireMode(3); // 构造器贪婪模式 （参数最多  bean）

	}
}
