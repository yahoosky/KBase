/**
 * 
 */
package late.kbase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jdk.nashorn.internal.runtime.UserAccessorProperty;
import late.kbase.dao.IUserProfileMapper;
import late.kbase.entity.UserProfile;
import late.kbase.service.IUserService;

/**
 * �û�����ʵ����
 * 
 * @projectName kbase
 * @packageName late.kbase.service.impl
 * @fileName UserServiceImpl.java
 * @author chijingjia
 * @createTime :2017��12��1�� ����2:45:26
 * @version: v1.0
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Resource
	IUserProfileMapper mapper = null;

	public UserProfile getUserByUsername(String userName) {
		UserProfile prop = new UserProfile();
		prop.setUserName(userName);
		;

		UserProfile user = mapper.selectByPrimaryKey(1L);

		return user;
	}

}
