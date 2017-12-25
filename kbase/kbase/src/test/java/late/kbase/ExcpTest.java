/**
 * 
 */
package late.kbase;

import org.junit.Test;

import late.kbase.excp.KBaseErrCodeConstants;
import late.kbase.excp.KBaseErrorManager;
import late.kbase.excp.KBaseException;

/**
 *  
 * @projectName kbase
 * @packageName late.kbase
 * @fileName ExcpTest.java
 * @author chijingjia
 * @createTime :2017年12月4日 下午1:44:59
 * @version: v1.0
 */
public class ExcpTest {

	@Test
	public void testExcp() {
		try {
			
			KBaseErrorManager.throwMessage(KBaseErrCodeConstants.USER_DEFINED_MSG,"aa", "bbcc","dd");
		} catch (KBaseException e) {
			e.printStackTrace();
		}
	}

}
