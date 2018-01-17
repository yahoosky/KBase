/**
 * 
 */
package late.kbase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import late.comm.dto.BaseTradeRequestDTO;
import late.kbase.entity.UserProfileEntity;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName UserLoginRequestDTO.java
 * @author chijingjia
 * @createTime :2017��12��9�� ����2:11:53
 * @version: v1.0
 */
@JsonIgnoreProperties
public class UserLoginRequestDTO extends BaseTradeRequestDTO {

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
