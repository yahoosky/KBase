/**
 * 
 */
package late.kbase.dao;

import late.kbase.entity.BaseEntity;

/**
 * mapper���ӿ�
 * 
 * @projectName kbase
 * @packageName late.kbase.dao
 * @fileName BaseMapper.java
 * @author chijingjia
 * @createTime :2017��12��27�� ����7:02:45
 * @version: v1.0
 */
public interface BaseMapper {
	/**
	 * ����
	 * 
	 * @methodName insert
	 * @author chijingjia
	 * @createTime 2017��12��27�� ����7:04:06
	 * @version v1.0
	 * @param entity
	 */
	void insert(BaseEntity entity);
}
