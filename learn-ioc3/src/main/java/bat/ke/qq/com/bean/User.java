package bat.ke.qq.com.bean;

import bat.ke.qq.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Component
public class User {

	@Autowired
	private Fox fox;  //field.set(obj,value)

	@Autowired  // byType  ---- byName
	//@Qualifier("userService2")
	private UserService userService;

	public User() {

		System.out.println("=====User()====");
	}


	public Fox getFox() {
		return fox;
	}

	//@Autowired   //autowireMode=1 2
	public void setFox(Fox fox) {
		System.out.println(fox+"=======setFox(Fox fox)======");
		this.fox = fox;
	}


	@Override
	public String toString() {
		return "User{" +
				"fox=" + fox +
				", userService=" + userService +
				'}';
	}

}
