/**
 * @description
 */
package late.kbase.contant;

import late.comm.excp.BaseErrCodeConstants;

/**
 * @description 错误代码常量
 * @projectName FileProcessorAPI
 * @packageName tf.file.comm.excp
 * @fileName FileProcessorErrCodeConstants.java
 * @author chijingjia
 * @createTime :2017-3-2 下午05:52:04
 * @version: v1.0
 */
public interface KBaseDBErrCodeConstants extends BaseErrCodeConstants {

	/**
	 * 数据库错误-未找到符合条件的记录
	 */
	public static final String DB_NO_DATA_FOUND = "DBER0001";

	/**
	 * 记录已存在
	 */
	public static final String DB_RECORD_ALREADY_EXISTS = "DBER0002";

}
