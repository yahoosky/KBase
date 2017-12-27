/**
 * 
 */
package late.kbase.service;

import java.util.List;

import late.kbase.entity.KbaseMenuMastEntity;

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
	 * @createTime 2017��12��27�� ����7:27:40
	 * @version v1.0
	 * @param menuEntity
	 */
	void addMenu(KbaseMenuMastEntity menuEntity);

	/**
	 * ���ݸ�ID���Ҳ˵��б������Ӳ˵���
	 * 
	 * @methodName queryMenuByParentId
	 * @author chijingjia
	 * @createTime 2017��12��27�� ����7:23:13
	 * @version v1.0
	 * @param parentId
	 *            �˵�ID
	 * @param lvl
	 *            ��ʾ�㼶��0��ʾȫ��
	 * @return
	 */
	List<KbaseMenuMastEntity> queryMenuByParentId(String parentId, int lvl);
}
