/**
 * 
 */
package late.kbase;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import late.kbase.service.IUserService;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase
 * @fileName TestMybatis.java
 * @author chijingjia
 * @createTime :2017年12月1日 下午3:50:04
 * @version: v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml","classpath:spring-mvc.xml" })
public class TestMybatis {

//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml"});
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void Test() {
		try {
			userService.getUserByUsername("aa");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
