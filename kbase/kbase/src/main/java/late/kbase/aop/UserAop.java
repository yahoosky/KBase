/**
 * 
 */
package late.kbase.aop;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import late.comm.dto.BaseResponseDTO;
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
	@Pointcut("execution(* late.kbase.controller.CommonController.*(..))")
	private void commonController() {
	}

	/**
	 * 用户登录切点
	 * 
	 * @methodName userLogion
	 * @author chijingjia
	 * @createTime 2018年1月15日 上午10:57:03
	 * @version v1.0
	 */
	@Pointcut("execution(late.kbase.dto.UserLoginResponseDTO late.kbase.controller.CommonController.login(late.kbase.dto.UserLoginRequestDTO))")
	private void userLogion() {
	}

	@Around("late.kbase.aop.UserAop.commonController()")
	public BaseResponseDTO getUserById(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] objs = joinPoint.getArgs();
		BaseTradeRequestDTO baseRequestDTO = (BaseTradeRequestDTO) objs[0];

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		HttpSession session = request.getSession();
		Object ticket = session.getAttribute("ticket");

		if (ticket == null) {
			ticket = UUID.randomUUID().toString();
			session.setAttribute("ticket", ticket);
			baseRequestDTO.getContext().getUser().setTicket(ticket);
		} else {
			baseRequestDTO.getContext().getUser().setUserName("bb");
		}

		return (BaseResponseDTO) joinPoint.proceed(objs);

	}

}
