/**
 * 
 */
package late.kbase.dao;

import java.io.Serializable;
import java.util.List;

import late.kbase.entity.BaseEntity;

/**
 * mapper父接口
 * 
 * @projectName kbase
 * @packageName late.kbase.dao
 * @fileName BaseMapper.java
 * @author chijingjia
 * @createTime :2017年12月27日 下午7:02:45
 * @version: v1.0
 */
public interface BaseMapper<T extends BaseEntity, PK extends Serializable> {
	/**
	 * 插入
	 * 
	 * @methodName insert
	 * @author chijingjia
	 * @createTime 2017年12月27日 下午7:04:06
	 * @version v1.0
	 * @param entity
	 */
	void insert(T entity);

	/**
	 * 根据主键修改信息
	 * 
	 * @methodName updById
	 * @author chijingjia
	 * @createTime 2017年12月28日 上午9:38:15
	 * @version v1.0
	 * @param entity
	 */
	void updByPK(PK pk);

	/**
	 * 根据主键获取记录
	 * 
	 * @methodName getById
	 * @author chijingjia
	 * @createTime 2017年12月28日 上午9:38:28
	 * @version v1.0
	 * @param entity
	 */
	T getByPk(PK pk);

	/**
	 * 根据实体类查找
	 * 
	 * @methodName find
	 * @author chijingjia
	 * @createTime 2017年12月28日 上午9:51:12
	 * @version v1.0
	 * @param entity
	 * @return
	 */
	List<T> find(T entity);
}
