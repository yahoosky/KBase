/**
 * 
 */
package late.kbase.dto;

/**
 * ���ݴ���㣬Ϊ����ʵ���࣬�м�����ת���㡣
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName IEntityConvertDTO.java
 * @author chijingjia
 * @createTime :2018��1��16�� ����2:48:24
 * @version: v1.0
 * @param <T>
 */
public interface IEntityConvertDTO<T> {
	/**
	 * תΪʵ����
	 * 
	 * @methodName toEntity
	 * @author chijingjia
	 * @createTime 2018��1��16�� ����2:49:07
	 * @version v1.0
	 * @return
	 */
	T toEntity();

}
