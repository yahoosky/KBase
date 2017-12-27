/**
 * 
 */
package late.kbase.dao;

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
public interface BaseMapper {
	/**
	 * 插入
	 * 
	 * @methodName insert
	 * @author chijingjia
	 * @createTime 2017年12月27日 下午7:04:06
	 * @version v1.0
	 * @param entity
	 */
	void insert(BaseEntity entity);
}
