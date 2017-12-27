/**
 * 
 */
package late.kbase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import late.kbase.dao.IUserProfileMapper;
import late.kbase.entity.UserProfileEntity;
import late.kbase.excp.CommonErrCodeConstants;
import late.kbase.excp.KBaseErrorManager;
import late.kbase.excp.KBaseException;
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

	public UserProfileEntity getUserByUsername(String userName) throws KBaseException {
		UserProfileEntity prop = new UserProfileEntity();
		prop.setUserName(userName);

		UserProfileEntity user = mapper.getByUsername(prop);
		if (user == null) {
			KBaseErrorManager.throwMessage(CommonErrCodeConstants.USER_NOT_FOUND, "�û�������", "�û���", userName);
		}

		return user;
	}

}
