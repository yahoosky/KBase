/**
 * 
 */
package late.kbase.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import late.comm.utils.StringUtils;
import late.kbase.contant.MenuContants;
import late.kbase.dao.IKbaseMenuMastMapper;
import late.kbase.entity.KbaseMenuMastEntity;
import late.kbase.excp.KBaseErrorManager;
import late.kbase.excp.KBaseException;
import late.kbase.service.IMenuService;

/**
 * 用户服务实现类
 * 
 * @projectName kbase
 * @packageName late.kbase.service.impl
 * @fileName UserServiceImpl.java
 * @author chijingjia
 * @createTime :2017年12月1日 下午2:45:26
 * @version: v1.0
 */
@Service(value = "menuService")
public class MenuServiceImpl implements IMenuService {

	@Resource
	IKbaseMenuMastMapper menuMapper = null;

	@Override
	public void addMenu(KbaseMenuMastEntity menuEntity) throws KBaseException {
		menuEntity.setParentId(
				StringUtils.getValWithDefault(menuEntity.getParentId(), MenuContants.MAIN_MENU_ROOT_PARENT_ID));
		if (!MenuContants.MAIN_MENU_ROOT_PARENT_ID.equals(menuEntity.getParentId())) {
			KbaseMenuMastEntity parentMenu = getMenu(menuEntity.getParentId());
			if (parentMenu == null) {
				KBaseErrorManager.throwMessage(MenuContants.ERR_PARENT_MENU_NOTEXISTS, "菜单添加失败", "父菜单",
						menuEntity.getParentId());
			}
		}
		menuMapper.insert(menuEntity);
	}

	@Override
	public KbaseMenuMastEntity getMenu(String menuId) {
		KbaseMenuMastEntity mastEntity = menuMapper.getByPk(menuId);
		return mastEntity;
	}

	@Override
	public List<KbaseMenuMastEntity> queryMenuByParentId(String parentId, int lvl) {
		if (parentId == null || parentId.isEmpty()) {
			parentId = "0";
		}
		return menuMapper.queryMenuByParentId(parentId, lvl);
	}

}
