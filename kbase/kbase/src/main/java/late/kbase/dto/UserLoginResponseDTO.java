/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeResponseDTO;
import late.kbase.entity.UserProfile;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName UserLoginResponseDTO.java
 * @author chijingjia
 * @createTime :2017年12月4日 上午10:20:17
 * @version: v1.0
 */
public class UserLoginResponseDTO extends BaseTradeResponseDTO {
	/**
	 * 用户实体
	 */
	private UserProfile user;

	/**
	 * @return the user
	 */
	public UserProfile getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserProfile user) {
		this.user = user;
	}

}
