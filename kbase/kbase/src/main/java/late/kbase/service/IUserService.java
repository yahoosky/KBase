/**
 * 
 */
package late.kbase.service;

import late.kbase.entity.UserProfile;

/**
 * �û�����ӿ�
 * 
 * @projectName kbase
 * @packageName late.kbase.service
 * @fileName IUserService.java
 * @author chijingjia
 * @createTime :2017��12��1�� ����2:44:52
 * @version: v1.0
 */
public interface IUserService {
	/**
	 * ��ȡ�û���Ϣ
	 * 
	 * @methodName getUser
	 * @author chijingjia
	 * @createTime 2017��12��1�� ����2:46:08
	 * @version v1.0
	 */
	UserProfile getUserByUsername(String userId);
}
