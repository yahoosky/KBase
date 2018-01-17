/**
 * 
 */
package late.kbase.dto;

/**
 * 数据传输层，为兼容实体类，中间设置转换层。
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName IEntityConvertDTO.java
 * @author chijingjia
 * @createTime :2018年1月16日 下午2:48:24
 * @version: v1.0
 * @param <T>
 */
public interface IEntityConvertDTO<T> {
	/**
	 * 转为实体类
	 * 
	 * @methodName toEntity
	 * @author chijingjia
	 * @createTime 2018年1月16日 下午2:49:07
	 * @version v1.0
	 * @return
	 */
	T toEntity();

}
