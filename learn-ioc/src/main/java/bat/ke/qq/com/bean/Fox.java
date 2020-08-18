package bat.ke.qq.com.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Component
public class Fox implements InitializingBean, DisposableBean {

	public Fox(){
		System.out.println("new fox()");
	}

	@PostConstruct
	public void init(){
		// before   Todo
		System.out.println("PostConstruct init");
	}

	public void initXml(){
		System.out.println("xml init");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy");
	}


	public void destroyXml(){
		//
		System.out.println("xml destroy");
	}

	@PreDestroy
	public void destroy2()  {
		System.out.println("PreDestroy  destroy");
	}
}
