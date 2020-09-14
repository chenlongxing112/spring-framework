/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.function.Supplier;

/**
 * Standalone application context, accepting <em>component classes</em> as input &mdash;
 * in particular {@link Configuration @Configuration}-annotated classes, but also plain
 * {@link org.springframework.stereotype.Component @Component} types and JSR-330 compliant
 * classes using {@code javax.inject} annotations.
 *
 * <p>Allows for registering classes one by one using {@link #register(Class...)}
 * as well as for classpath scanning using {@link #scan(String...)}.
 *
 * <p>In case of multiple {@code @Configuration} classes, {@link Bean @Bean} methods
 * defined in later classes will override those defined in earlier classes. This can
 * be leveraged to deliberately override certain bean definitions via an extra
 * {@code @Configuration} class.
 *
 * <p>See {@link Configuration @Configuration}'s javadoc for usage examples.
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @see #register
 * @see #scan
 * @see AnnotatedBeanDefinitionReader
 * @see ClassPathBeanDefinitionScanner
 * @see org.springframework.context.support.GenericXmlApplicationContext
 * @since 3.0
 */
public class AnnotationConfigApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry {

	private final AnnotatedBeanDefinitionReader reader;

	private final ClassPathBeanDefinitionScanner scanner;


	/**
	 * Create a new AnnotationConfigApplicationContext that needs to be populated
	 * through {@link #register} calls and then manually {@linkplain #refresh refreshed}.
	 * <p>
	 * 初始化注解读取器和Classpath扫描器, 用来读取当前应用程序提供给spring认识的注解和扫描配置类置顶的包
	 */
	public  AnnotationConfigApplicationContext() {
		// 初始化注解读取器在父类构造方法中初始化DefaultListableBeanFactory,
		super();
		// 并且将spring内置bean(添加的内置bean是如下的1,3,4,5,8,9)封装成RootBeanDefinition对象
		// 添加到bean工厂的beanDefinitionMap中去以及将beanName添加至beanDefinitionNames(list)中去
		// 注解读取器
		// 在执行此行代码之前, 先执行了父类的构造方法
		// 此段代码做的事情:
		// 1. 初始化bean工厂
		// 2. 初始化一个注解BeanDefinition读取器
		// 3. 将spring内置的6个类封装成RootBeanDefinition并注册到bean工厂,
		// 注册spring自带bean5个
		this.reader = new AnnotatedBeanDefinitionReader(this);
		// classPath扫描器
		// 并没啥用, 虽然ClassPathBeanDefinitionScanner类的作用是扫描@ComponentScan注解提供的包路径。
		// 但实际上它并没有做扫描工作, spring内部扫描路径的时候, 是在内部新new了一个ClassPathBeanDefinitionScanner,
		// 这个属性目前没啥用, 当然我们可以获取这个对象调用它的scan方法, 但是没有必要! 因为@ComponentScan可以支持多个扫描路径。
		// 那这个类有什么用呢？跟刚刚的解释一样,
		// 我们可以自己new一个ClassPathBeanDefinitionScanner对象或者扩展他,利用它的扫描功能(因为它是使用ASM来扫描的)
		// Mybatis源码中就是自己扩展了ClassPathBeanDefinitionScanner类
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}

	/**
	 * Create a new AnnotationConfigApplicationContext with the given DefaultListableBeanFactory.
	 *
	 * @param beanFactory the DefaultListableBeanFactory instance to use for this context
	 */
	public AnnotationConfigApplicationContext(DefaultListableBeanFactory beanFactory) {
		super(beanFactory);
		this.reader = new AnnotatedBeanDefinitionReader(this);
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}

	/**
	 * Create a new AnnotationConfigApplicationContext, deriving bean definitions
	 * from the given component classes and automatically refreshing the context.
	 *
	 * @param componentClasses one or more component classes &mdash; for example,
	 *                         {@link Configuration @Configuration} classes
	 */
	public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
		//1. 初始化bean定义读取器和扫描器;
		// 2.调用父类GenericApplicationContext无参构造函数，初始化一个BeanFactory：DefaultListableBeanFactory
		// 3.注册Spring自带的bean,共5个  包括:
		// ConfigurationClassPostProcessor
		// AutowiredAnnotationBeanPostProcessor
		// CommonAnnotationBeanPostProcessor
		// EventListenerMethodProcessor
		// DefaultEventListenerFactory
		this();
		//  注册AppConfig, ApplicationContext传入的配置类
		register(componentClasses);
		// 启动容器
		refresh();
	}

	/**
	 * Create a new AnnotationConfigApplicationContext, scanning for components
	 * in the given packages, registering bean definitions for those components,
	 * and automatically refreshing the context.
	 *
	 * @param basePackages the packages to scan for component classes
	 */
	public AnnotationConfigApplicationContext(String... basePackages) {
		this();
		scan(basePackages);
		refresh();
	}


	/**
	 * Propagate the given custom {@code Environment} to the underlying
	 * {@link AnnotatedBeanDefinitionReader} and {@link ClassPathBeanDefinitionScanner}.
	 */
	@Override
	public void setEnvironment(ConfigurableEnvironment environment) {
		super.setEnvironment(environment);
		this.reader.setEnvironment(environment);
		this.scanner.setEnvironment(environment);
	}

	/**
	 * Provide a custom {@link BeanNameGenerator} for use with {@link AnnotatedBeanDefinitionReader}
	 * and/or {@link ClassPathBeanDefinitionScanner}, if any.
	 * <p>Default is {@link AnnotationBeanNameGenerator}.
	 * <p>Any call to this method must occur prior to calls to {@link #register(Class...)}
	 * and/or {@link #scan(String...)}.
	 *
	 * @see AnnotatedBeanDefinitionReader#setBeanNameGenerator
	 * @see ClassPathBeanDefinitionScanner#setBeanNameGenerator
	 * @see AnnotationBeanNameGenerator
	 * @see FullyQualifiedAnnotationBeanNameGenerator
	 */
	public void setBeanNameGenerator(BeanNameGenerator beanNameGenerator) {
		this.reader.setBeanNameGenerator(beanNameGenerator);
		this.scanner.setBeanNameGenerator(beanNameGenerator);
		getBeanFactory().registerSingleton(
				AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR, beanNameGenerator);
	}

	/**
	 * Set the {@link ScopeMetadataResolver} to use for registered component classes.
	 * <p>The default is an {@link AnnotationScopeMetadataResolver}.
	 * <p>Any call to this method must occur prior to calls to {@link #register(Class...)}
	 * and/or {@link #scan(String...)}.
	 */
	public void setScopeMetadataResolver(ScopeMetadataResolver scopeMetadataResolver) {
		this.reader.setScopeMetadataResolver(scopeMetadataResolver);
		this.scanner.setScopeMetadataResolver(scopeMetadataResolver);
	}


	//---------------------------------------------------------------------
	// Implementation of AnnotationConfigRegistry
	//---------------------------------------------------------------------

	/**
	 * 1. register方法, 里面是传入所有被注解类的Class类(可传配置类(全配置类和部分配置类)和单个bean)
	 * 2. 将所有配置类的信息封装成AnnotatedBeanDefinition对象存到BeanDefinitionMap中去以及所有配置类的beanName存入beanDefinitionNames中去
	 * 至此, 还没有一个bean被创建出来.
	 * <p>
	 * 传入的是一个被注解类的Class数组, 可以是配置类也可以是普通类
	 * <p>
	 * 作用: 将传入的被注解的类以AnnotatedGenericBeanDefinition的类型注册到bean工厂。
	 * 至此， 还没有一个bean被创建出来。
	 * 以下为注册AnnotatedGenericBeanDefinition的具体代码逻辑, 可以看到注册bean调用了这个方法:
	 * registerBeanDefinition(这个方法很重要. 后续注册beanDefinition到bean工厂基本上都会用到这个方法)
	 * <p>
	 * Register one or more component classes to be processed.
	 * <p>Note that {@link #refresh()} must be called in order for the context
	 * to fully process the new classes.
	 *
	 * @param componentClasses one or more component classes &mdash; for example,
	 *                         {@link Configuration @Configuration} classes
	 * @see #scan(String...)
	 * @see #refresh()
	 */
	@Override
	public void register(Class<?>... componentClasses) {
		Assert.notEmpty(componentClasses, "At least one component class must be specified");
		// 此处用到了构造方法new出来的AnnotatedBeanDefinitionReader,
		// 这里解释下, 为什么能用这个类来将传入的类注册到bean工厂中:
		// 因为它内部维护了一个registry, 这个registry就是AnnotationConfigApplicationContext
		this.reader.register(componentClasses);
	}

	/**
	 * Perform a scan within the specified base packages.
	 * <p>Note that {@link #refresh()} must be called in order for the context
	 * to fully process the new classes.
	 *
	 * @param basePackages the packages to scan for component classes
	 * @see #register(Class...)
	 * @see #refresh()
	 */
	@Override
	public void scan(String... basePackages) {
		Assert.notEmpty(basePackages, "At least one base package must be specified");
		this.scanner.scan(basePackages);
	}


	//---------------------------------------------------------------------
	// Adapt superclass registerBean calls to AnnotatedBeanDefinitionReader
	//---------------------------------------------------------------------

	@Override
	public <T> void registerBean(@Nullable String beanName, Class<T> beanClass,
								 @Nullable Supplier<T> supplier, BeanDefinitionCustomizer... customizers) {

		this.reader.registerBean(beanClass, beanName, supplier, customizers);
	}

}
