package bat.ke.qq.com.bean;

import bat.ke.qq.com.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */
@Component
public class Tiger {

//	public Tiger(){
//		System.out.println("===Tiger()===");
//	}


	public Tiger(User user){
		System.out.println("===Tiger(User user)===");
	}


	public Tiger(User user,Fox fox){
		System.out.println("===Tiger(User user,Fox fox)===");
	}
	//
	//@Autowired
	public Tiger(User user,Cat cat){
		System.out.println("===Tiger(User user,Cat cat)===");
	}

//	public Tiger(User user,Cat cat, Monkey monkey){
//		System.out.println("===Tiger(User user,Cat cat, Monkey monkey)===");
//	}

}
