package bat.ke.qq.com.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		BeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
		//beanDefinition.getPropertyValues().add("name","")
		//beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("");
		//beanDefinition.setBeanClassName("bat.ke.qq.com.bean.Fox");

		registry.registerBeanDefinition("cat",beanDefinition);

	}
}
