/**
 * 
 */
package late.kbase.aop;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import late.comm.UserProfile;
import late.comm.dto.BaseTradeRequestDTO;
import late.kbase.dao.IUserProfileMapper;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.aop
 * @fileName UserAop.java
 * @author chijingjia
 * @createTime :2018年1月12日 下午2:44:28
 * @version: v1.0
 */
/**
 * 把这个类声明为一个切面： 1. 使用注解“@Repository”把该类放入到IOC容器中 2. 使用注解“@Aspect”把该类声明为一个切面
 * 
 * 设置切面的优先级: 3. 使用注解“@Order(number)”指定前面的优先级，值越小，优先级越高
 */
@Order(1)
@Aspect
@Repository
public class UserAop {

	@Resource
	IUserProfileMapper userMapper = null;

	/**
	 * PointCut没有切面作用，只是设置切入点
	 * 
	 * @methodName getUserById
	 * @author chijingjia
	 * @createTime 2018年1月15日 上午10:23:38
	 * @version v1.0
	 */
	@Pointcut("execution(* late.kbase.controller.CommonController.*(late.comm.dto.BaseTradeRequestDTO))")
	public void commonController() {
	}

	@Before("late.kbase.aop.UserAop.commonController()")
	public void getUserById(JoinPoint joinPoint) {
		Object[] objs = joinPoint.getArgs();
		BaseTradeRequestDTO baseRequestDTO = (BaseTradeRequestDTO) objs[0];
		UserProfile user = baseRequestDTO.getContext().getUser();
		if (user != null) {
			System.out.println(user.getUserName());
			user.setUserName("aabbcc");
		} else {
			System.out.println("无用户");
		}
	}

}
