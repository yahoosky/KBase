package late.kbase.dao;

import java.util.List;

import late.kbase.entity.KbaseMenuMastEntity;

public interface IKbaseMenuMastMapper extends BaseMapper {

	/**
	 * 根据父ID查找菜单列表
	 * 
	 * @methodName queryMenuByParentId
	 * @author chijingjia
	 * @createTime 2017年12月27日 下午7:29:58
	 * @version v1.0
	 * @param parentId
	 *            父菜单 缺省为第一层
	 * @param lvl
	 *            层级 0-全部
	 * @return
	 */
	List<KbaseMenuMastEntity> queryMenuByParentId(String parentId, int lvl);

}