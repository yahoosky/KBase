/**
 * 
 */
package late.kbase.service;

import late.kbase.dto.MainMenuAddResponseDTO;

/**
 * 菜单服务接口
 * 
 * @projectName kbase
 * @packageName late.kbase.service
 * @fileName IMenuService.java
 * @author chijingjia
 * @createTime :2017年12月14日 上午10:54:24
 * @version: v1.0
 */
public interface IMenuService {

	/**
	 * 添加菜单
	 * 
	 * @methodName addMenu
	 * @author chijingjia
	 * @createTime 2017年12月14日 上午10:56:09
	 * @version v1.0
	 * @param request
	 * @return
	 */
	MainMenuAddResponseDTO addMenu(MainMenuAddResponseDTO request);
}
