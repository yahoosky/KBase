/**
 * 
 */
package late.kbase.excp;

import late.comm.BaseThreadAttribute;
import late.comm.excp.BaseException;
import late.comm.log.TraceLogger;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.excp
 * @fileName KBaseException.java
 * @author chijingjia
 * @createTime :2017��12��4�� ����9:19:49
 * @version: v1.0
 */
public class KBaseException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8887514433345001008L;

	private static final String THIS_COMPONMENT_NAME = KBaseException.class.getName();

	KBaseException(String errMsg) {
		super(errMsg);
	}

	KBaseException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

	@Override
	public void printStackTrace() {
		// TODO
		StringBuilder msg = new StringBuilder()//
				.append(BaseThreadAttribute.getStr(BaseThreadAttribute.TRADE_ID)).append("���׳����쳣")//
				.append("[")//
				.append(errCode)//
				.append("]")//
				.append(errMsg)//
		;
		StackTraceElement[] traceEles = getStackTrace();
		for (int i = 0; i < traceEles.length && i < 15; i++) {
			//TODO ��ʵ�������쳣���
		}
		TraceLogger.debug(THIS_COMPONMENT_NAME, msg.toString());
		super.printStackTrace();
	}

}
