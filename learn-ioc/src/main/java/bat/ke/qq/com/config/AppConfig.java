package bat.ke.qq.com.config;

import bat.ke.qq.com.bean.Fox;
import bat.ke.qq.com.bean.MyImportBeanDefinitionRegistrar;
import bat.ke.qq.com.bean.MyImportSelector;
import bat.ke.qq.com.bean.User;
import org.springframework.context.annotation.*;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Configuration
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
@ComponentScan("bat.ke.qq.com")
public class AppConfig {

	@Bean(initMethod = "initXml",destroyMethod = "destroyXml")
	// method.invoke
	//@Scope("prototype")
	public Fox fox(){
		// 多例   ---》 单例   beanFactory.getBean("fox")
		return new Fox();
	}

//	@Bean
//	//@Primary
//	public Fox fox2(){
//		// 多例   ---》 单例   beanFactory.getBean("fox")
//		return new Fox();
//	}


//	@Bean
//	public User user(){
//		//  ConfigurationClassBeanDefinition
//		return new User();
//	}
//
//	@Bean
//	public User user3(){
//		return new User(fox());
//	}

}
