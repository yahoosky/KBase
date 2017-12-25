/**
 * 
 */
package late.kbase.excp;

import late.comm.excp.BaseException;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.excp
 * @fileName KBaseException.java
 * @author chijingjia
 * @createTime :2017年12月4日 上午9:19:49
 * @version: v1.0
 */
public class KBaseException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8887514433345001008L;

	KBaseException(String errMsg) {
		super(errMsg);
	}

	KBaseException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}
