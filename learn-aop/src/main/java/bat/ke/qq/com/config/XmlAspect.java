package bat.ke.qq.com.config;


import org.aspectj.lang.JoinPoint;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */

public class XmlAspect {

	public void before(JoinPoint point) {
		System.out.println("before");
	}

	public void after() {
		System.out.println("after");
	}
}
