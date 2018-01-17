/**
 * 
 */
package late.kbase.dto;

import late.comm.UserProfile;
import late.comm.dto.BaseTradeResponseDTO;
import late.kbase.entity.UserProfileEntity;

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
	private UserProfileEntity user;

	/**
	 * 返回用户信息（ticket）
	 */
	private UserProfile contextUser;

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

	/**
	 * @return the contextUser
	 */
	public UserProfile getContextUser() {
		return contextUser;
	}

	/**
	 * @param contextUser
	 *            the contextUser to set
	 */
	public void setContextUser(UserProfile contextUser) {
		this.contextUser = contextUser;
	}

}
