/**
 * @description
 */
package late.kbase.excp;

import java.util.HashMap;
import java.util.Map;

/**
 * @description �ļ��쳣��Ϣ������
 * @projectName FileProcessorAPI
 * @packageName tf.file.comm.excp
 * @fileName FileProcessorErrorCache.java
 * @author chijingjia
 * @createTime :2017-3-2 ����04:51:50
 * @version: v1.0
 */
public class KBaseErrorCache {
	/**
	 * @description ������쳣��Ϣ
	 */
	private final static Map<String, ErrorMessage> ERROR_MESSAGES = new HashMap<String, ErrorMessage>();
	private static Boolean loaded = Boolean.FALSE;

	/**
	 * @description ��ʼ������
	 * @methodName init
	 * @author chijingjia
	 * @createTime 2017-3-2 ����04:55:37
	 * @version v1.0
	 */
	private static void init() {
		/**
		 * �����ļ������쳣
		 */
		ERROR_MESSAGES.put(KBaseErrCodeConstants.USER_DEFINED_MSG,
				new ErrorMessage(KBaseErrCodeConstants.USER_DEFINED_MSG, "{0}"));

		loaded = Boolean.TRUE;
	}

	/**
	 * @description ��ȡ�쳣��ϲ
	 * @methodName getErrMsg
	 * @author chijingjia
	 * @createTime 2017-3-2 ����04:58:15
	 * @version v1.0
	 * @param errCode
	 * @return
	 */
	public static String getErrMsg(String errCode, String... params) {
		String msg = "δ�ҵ�������Ϣ";
		if (loaded) {
			if (ERROR_MESSAGES.get(errCode) != null) {
				msg = ERROR_MESSAGES.get(errCode).getMsg();
			}
		} else {
			// ���δ������ɣ��ȴ�0.1�룬�ٴβ�ѯ��
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
	 * @description �쳣��Ϣ��
	 * @projectName FileProcessorAPI
	 * @packageName tf.file.excp
	 * @fileName FileProcessorErrorCache.java
	 * @author chijingjia
	 * @createTime :2017-3-2 ����04:53:44
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
		 * @description ��ȡ������Ϣ
		 * @methodName getMsg
		 * @author chijingjia
		 * @createTime 2017-3-2 ����05:01:50
		 * @version v1.0
		 * @return
		 */
		private String getMsg() {
			return this.errMsg;
		}
	}

	static {
		init();
	}
}
