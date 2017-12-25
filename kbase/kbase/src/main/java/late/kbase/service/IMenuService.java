/**
 * 
 */
package late.kbase.service;

import late.kbase.dto.MainMenuAddResponseDTO;

/**
 * �˵�����ӿ�
 * 
 * @projectName kbase
 * @packageName late.kbase.service
 * @fileName IMenuService.java
 * @author chijingjia
 * @createTime :2017��12��14�� ����10:54:24
 * @version: v1.0
 */
public interface IMenuService {

	/**
	 * ��Ӳ˵�
	 * 
	 * @methodName addMenu
	 * @author chijingjia
	 * @createTime 2017��12��14�� ����10:56:09
	 * @version v1.0
	 * @param request
	 * @return
	 */
	MainMenuAddResponseDTO addMenu(MainMenuAddResponseDTO request);
}
