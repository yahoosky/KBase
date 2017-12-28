/**
 * 
 */
package late.kbase.dao;

import java.io.Serializable;
import java.util.List;

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
public interface BaseMapper<T extends BaseEntity, PK extends Serializable> {
	/**
	 * ����
	 * 
	 * @methodName insert
	 * @author chijingjia
	 * @createTime 2017��12��27�� ����7:04:06
	 * @version v1.0
	 * @param entity
	 */
	void insert(T entity);

	/**
	 * ���������޸���Ϣ
	 * 
	 * @methodName updById
	 * @author chijingjia
	 * @createTime 2017��12��28�� ����9:38:15
	 * @version v1.0
	 * @param entity
	 */
	void updByPK(PK pk);

	/**
	 * ����������ȡ��¼
	 * 
	 * @methodName getById
	 * @author chijingjia
	 * @createTime 2017��12��28�� ����9:38:28
	 * @version v1.0
	 * @param entity
	 */
	T getByPk(PK pk);

	/**
	 * ����ʵ�������
	 * 
	 * @methodName find
	 * @author chijingjia
	 * @createTime 2017��12��28�� ����9:51:12
	 * @version v1.0
	 * @param entity
	 * @return
	 */
	List<T> find(T entity);
}
