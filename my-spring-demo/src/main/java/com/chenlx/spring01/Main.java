package com.chenlx.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenlx
 * @date 2020-08-15 09:28
 */
public class Main {
	public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-${SHLVL}.xml");

		Object bean2 = applicationContext.getBean("userService");
		System.out.println(bean2);
	}
}
