/**
 * @description
 */
package late.kbase.excp;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;

import late.com.utils.ArrayUtils;
import late.comm.BaseThreadAttribute;
import late.comm.log.TraceLogger;

/**
 * @description 异常处理类。一般用于抛出异常信息。
 * @projectName FileProcessorAPI
 * @packageName tf.file.comm.excp
 * @fileName ErrorManager.java
 * @author chijingjia
 * @createTime :2017-3-2 下午01:16:34
 * @version: v1.0
 */
public class KBaseErrorManager {
	private static final String THIS_COMPONMENT_NAME = KBaseErrorManager.class.getName();
	/**
	 * @description 内部日志类
	 */
	protected static final Logger logger = Logger.getLogger(KBaseErrorManager.class);

	/**
	 * @description 抛出错误信息。用于业务级
	 * @methodName throwMessage
	 * @author chijingjia
	 * @createTime 2017-3-2 下午01:18:15
	 * @version v1.0
	 * @param errCode
	 * @param errMsg
	 * @throws KBaseException
	 */
	public static void throwMessage(String errCode, String info, String... params) throws KBaseException {
		String errMsg = KBaseErrorCache.getErrMsg(errCode, params);
		StackTraceElement element = Thread.currentThread().getStackTrace()[1];
		ArrayUtils.headAdd(params, element.getClassName(), element.getMethodName(), "line:", element.getLineNumber());
		TraceLogger.error(THIS_COMPONMENT_NAME, info, null, params);
		TraceLogger.error(THIS_COMPONMENT_NAME, errMsg, null);
		throw new KBaseException(errCode, errMsg);
	}

	/**
	 * 登记异常信息
	 * 
	 * @methodName logException
	 * @author chijingjia
	 * @createTime 2017-6-27 下午04:16:35
	 * @version 1.0
	 * @param e
	 * @param params
	 */
	public static void logException(Throwable e, String... params) {
		TraceLogger.error(THIS_COMPONMENT_NAME, "交易出现异常", e, params);
	}

	/**
	 * 抛出异常
	 * 
	 * @methodName throwException
	 * @author chijingjia
	 * @createTime 2017-7-13 下午12:08:11
	 * @version 1.0
	 * @param e
	 * @param info
	 * @param params
	 */
	public static void throwException(Throwable e, String info, String... params) throws KBaseException {
		if (e == null) {
			logException(e, params);
		} else if (e instanceof KBaseException) {
			throw (KBaseException) e;
		} else if (e instanceof SQLException) {
			SQLException e2 = (SQLException) e;
			logException(e, "错误码", e2.getSQLState(), "错误信息", e2.getMessage());
			throw new KBaseException("数据库错误");
		} else if (e instanceof NullPointerException) {
			logException(e, params);
			throw new KBaseException("空指针错误");
		} else {
			logException(e, params);
			throw new KBaseException("未知错误");
		}
	}

	/**
	 * @description 测试方法
	 * @methodName main
	 * @author chijingjia
	 * @createTime 2017-3-2 下午05:33:42
	 * @version v1.0
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BaseThreadAttribute.set(BaseThreadAttribute.TRADE_ID, UUID.randomUUID().toString());
			KBaseErrorManager.throwMessage(KBaseErrCodeConstants.USER_DEFINED_MSG, null, "123");
		} catch (KBaseException e) {
			try {
				throwException(e, "哈哈", "11", "2");
			} catch (KBaseException e1) {
				e1.printStackTrace();
			}
		}
	}
}
