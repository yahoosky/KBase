/**
 * 
 */
package late.kbase.service;

import java.util.List;

import late.kbase.entity.KbaseMenuMastEntity;
import late.kbase.excp.KBaseException;

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
	 * @createTime 2017年12月27日 下午7:27:40
	 * @version v1.0
	 * @param menuEntity
	 * @throws KBaseException
	 */
	void addMenu(KbaseMenuMastEntity menuEntity) throws KBaseException;

	/**
	 * 根据ID获取指定菜单
	 * 
	 * @methodName getMenu
	 * @author chijingjia
	 * @createTime 2017年12月28日 上午9:37:14
	 * @version v1.0
	 * @param menuId
	 * @return
	 */
	KbaseMenuMastEntity getMenu(String menuId);

	/**
	 * 根据父ID查找菜单列表（包括子菜单）
	 * 
	 * @methodName queryMenuByParentId
	 * @author chijingjia
	 * @createTime 2017年12月27日 下午7:23:13
	 * @version v1.0
	 * @param parentId
	 *            菜单ID
	 * @param lvl
	 *            显示层级，0表示全部
	 * @return
	 */
	List<KbaseMenuMastEntity> queryMenuByParentId(String parentId, int lvl);
}
