/**
 * 
 */
package late.kbase.service;

import late.kbase.entity.UserProfile;

/**
 * 用户服务接口
 * 
 * @projectName kbase
 * @packageName late.kbase.service
 * @fileName IUserService.java
 * @author chijingjia
 * @createTime :2017年12月1日 下午2:44:52
 * @version: v1.0
 */
public interface IUserService {
	/**
	 * 获取用户信息
	 * 
	 * @methodName getUser
	 * @author chijingjia
	 * @createTime 2017年12月1日 下午2:46:08
	 * @version v1.0
	 */
	UserProfile getUserByUsername(String userId);
}
