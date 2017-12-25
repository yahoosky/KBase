/**
 * @description
 */
package late.kbase.excp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import late.comm.log.TraceLogger;
import late.kbase.dao.IKbaseErrDefMapper;

/**
 * @description 文件异常信息缓存类
 * @projectName FileProcessorAPI
 * @packageName tf.file.comm.excp
 * @fileName FileProcessorErrorCache.java
 * @author chijingjia
 * @createTime :2017-3-2 下午04:51:50
 * @version: v1.0
 */
public class KBaseErrorCache {
	/**
	 * @description 缓存的异常信息
	 */
	private final static Map<String, ErrorMessage> ERROR_MESSAGES = new HashMap<String, ErrorMessage>();
	private static Boolean loaded = Boolean.FALSE;

	@Resource
	IKbaseErrDefMapper mapper = null;

	/**
	 * @description 初始化方法
	 * @methodName init
	 * @author chijingjia
	 * @createTime 2017-3-2 下午04:55:37
	 * @version v1.0
	 */
	private void init() {
		List<Map<String, String>> errDefList = mapper.getAll();

		for (Map<String, String> errDef : errDefList) {
			String errCode = errDef.get("err_code");
			String errMsg = errDef.get("err_msg");

			TraceLogger.debug("加载异常代码", errCode, errMsg);
			ERROR_MESSAGES.put(errCode, new ErrorMessage(errCode, errMsg));
		}

		TraceLogger.debug("异常代码加载完成");

		/**
		 * 生成文件部分异常
		 */
		ERROR_MESSAGES.put(KBaseErrCodeConstants.USER_DEFINED_MSG,
				new ErrorMessage(KBaseErrCodeConstants.USER_DEFINED_MSG, "{0}"));

		loaded = Boolean.TRUE;
	}

	/**
	 * @description 获取异常欣喜
	 * @methodName getErrMsg
	 * @author chijingjia
	 * @createTime 2017-3-2 下午04:58:15
	 * @version v1.0
	 * @param errCode
	 * @return
	 */
	public static String getErrMsg(String errCode, String... params) {
		synchronized (KBaseErrorCache.class) {
			TraceLogger.debug("加载异常代码");
			new KBaseErrorCache().init();
		}
		String msg = "未找到错误信息";
		if (loaded) {
			if (ERROR_MESSAGES.get(errCode) != null) {
				msg = ERROR_MESSAGES.get(errCode).getMsg();
			}
		} else {
			// 如果未加载完成，等待0.1秒，再次查询。
			try {
				Thread.sleep(100);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			msg = getErrMsg(errCode);
		}
		for (int i = 0; i < params.length; i++) {
			String filter = "\\{" + i + "\\}";
			msg = msg.replaceAll(filter, params[i]);
		}
		return msg;
	}

	/**
	 * @description 异常信息类
	 * @projectName FileProcessorAPI
	 * @packageName tf.file.excp
	 * @fileName FileProcessorErrorCache.java
	 * @author chijingjia
	 * @createTime :2017-3-2 下午04:53:44
	 * @version: v1.0
	 */
	static class ErrorMessage {
		ErrorMessage(String errCode, String errMsg) {
			this.errCode = errCode;
			this.errMsg = errMsg;
		}

		private String errCode;
		private String errMsg;

		/**
		 * @description 获取错误信息
		 * @methodName getMsg
		 * @author chijingjia
		 * @createTime 2017-3-2 下午05:01:50
		 * @version v1.0
		 * @return
		 */
		private String getMsg() {
			return this.errMsg;
		}
	}

}
