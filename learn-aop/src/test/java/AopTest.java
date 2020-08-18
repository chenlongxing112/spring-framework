import bat.ke.qq.com.bean.Fox;
import bat.ke.qq.com.config.AppConfig;
import bat.ke.qq.com.config.AspectConfig;
import bat.ke.qq.com.config.XmlAspect;
import bat.ke.qq.com.dao.FoxDao;
import bat.ke.qq.com.dao.IFoxDao;
import bat.ke.qq.com.proxy.MyInvocationHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
public class AopTest {

	@Test
	public void test(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// jdk动态代理 基于接口 extend Proxy implements IFoxDao 只支持接口和Proxy
		// cglib   基于继承，支持接口和目标类
		IFoxDao dao = (IFoxDao) context.getBean("foxDao");
		dao.query();
		//dao.query("fox");
		//dao.query(new Fox());



//		IFoxDao dao = (IFoxDao) Proxy.newProxyInstance(AopTest.class.getClassLoader(),
//				new Class[]{IFoxDao.class},new MyInvocationHandler(new FoxDao()));
//		dao.query();




	}


	@Test
	public void test2(){
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("spring-aop.xml");

		IFoxDao foxDao = (IFoxDao) context.getBean("foxDao");

		foxDao.query();

	}


}
