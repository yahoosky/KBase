/**
 * 
 */
package late.kbase.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import late.kbase.dao.IKbaseMenuMastMapper;
import late.kbase.entity.KbaseMenuMastEntity;
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
	public void addMenu(KbaseMenuMastEntity menuEntity) {
		menuMapper.insert(menuEntity);
	}

	@Override
	public List<KbaseMenuMastEntity> queryMenuByParentId(String parentId, int lvl) {
		if(parentId==null||parentId.isEmpty()){
			parentId = "0";
		}
		return menuMapper.queryMenuByParentId(parentId, lvl);
	}

}
