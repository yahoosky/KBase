package late.kbase.dao;

import java.util.List;

import late.kbase.entity.KbaseMenuMastEntity;

public interface IKbaseMenuMastMapper extends BaseMapper {

	/**
	 * ���ݸ�ID���Ҳ˵��б�
	 * 
	 * @methodName queryMenuByParentId
	 * @author chijingjia
	 * @createTime 2017��12��27�� ����7:29:58
	 * @version v1.0
	 * @param parentId
	 *            ���˵� ȱʡΪ��һ��
	 * @param lvl
	 *            �㼶 0-ȫ��
	 * @return
	 */
	List<KbaseMenuMastEntity> queryMenuByParentId(String parentId, int lvl);

}