/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeResponseDTO;
import late.kbase.entity.UserProfileEntity;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName UserLoginResponseDTO.java
 * @author chijingjia
 * @createTime :2017��12��4�� ����10:20:17
 * @version: v1.0
 */
public class UserLoginResponseDTO extends BaseTradeResponseDTO {
	/**
	 * �û�ʵ��
	 */
	private UserProfileEntity user;

	/**
	 * @return the user
	 */
	public UserProfileEntity getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserProfileEntity user) {
		this.user = user;
	}

}
