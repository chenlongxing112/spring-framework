package com.chenlx.spring01;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author chenlx
 * @date 2020-08-14 21:46
 */
//@Component
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
		User user = new User();
		user.setUserId(1111111L);
		user.setUserName("1111111111L");
		return user;
    }


    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
