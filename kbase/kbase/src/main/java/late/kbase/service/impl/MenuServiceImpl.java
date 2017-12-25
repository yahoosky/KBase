/**
 * 
 */
package late.kbase.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import late.kbase.dao.IKbaseMenuMastMapper;
import late.kbase.dto.MainMenuAddResponseDTO;
import late.kbase.dto.MainMenuQueryRequestDTO;
import late.kbase.dto.MainMenuQueryResponseDTO;
import late.kbase.service.IMenuService;

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
@Service(value = "menuService")
public class MenuServiceImpl implements IMenuService {

	@Resource
	IKbaseMenuMastMapper menuMapper = null;

	/**
	 * ��Ӳ˵�
	 * 
	 * @methodName addMenu
	 * @author chijingjia
	 * @createTime 2017��12��14�� ����10:58:36
	 * @version v1.0
	 * @param request
	 * @return
	 */
	public MainMenuAddResponseDTO addMenu(MainMenuAddResponseDTO request) {
		MainMenuAddResponseDTO response = new MainMenuAddResponseDTO();

		int retCode = menuMapper.insert(request.getMenuMast());
		System.out.println(retCode);

		return response;
	}

	/**
	 * ��ѯ�˵�
	 * 
	 * @methodName queryMenu
	 * @author chijingjia
	 * @createTime 2017��12��14�� ����11:02:32
	 * @version v1.0
	 * @param request
	 * @return
	 */
	public MainMenuQueryResponseDTO queryMenu(MainMenuQueryRequestDTO request) {
		MainMenuQueryResponseDTO response = new MainMenuQueryResponseDTO();

		return response;
	}

}
