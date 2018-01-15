/**
 * 
 */
package late.kbase.aop;

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
import late.kbase.contant.KBaseErrCodeConstants;
import late.kbase.dao.IKbaseUserTicketMapper;
import late.kbase.dao.IUserProfileMapper;
import late.kbase.entity.KbaseUserTicketEntity;
import late.kbase.entity.UserProfileEntity;
import late.kbase.excp.KBaseErrorManager;

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
	static final String TICKET_MARK = "ticket";

	@Resource
	IKbaseUserTicketMapper ticketMapper = null;
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
		String ticket = (String) session.getAttribute(TICKET_MARK);
		KbaseUserTicketEntity ticketEntity = null;
		if (ticket == null) {
			Long userId = baseRequestDTO.getContext().getUser().getUserId();
			if (userId == null) {
				KBaseErrorManager.throwMessage(KBaseErrCodeConstants.USER_CONTEXT_ISNULL, "用户总线未输入");
			}
			ticket = session.getId();
			session.setAttribute(TICKET_MARK, ticket);
			baseRequestDTO.getContext().getUser().setTicket(ticket);
			// 登记ticket
			ticketEntity = new KbaseUserTicketEntity();
			ticketEntity.setTicket(ticket);
			ticketEntity.setUserId(baseRequestDTO.getContext().getUser().getUserId());
			ticketMapper.insert(ticketEntity);
		} else {
			KbaseUserTicketEntity userTicket = ticketMapper.getByPk(ticket);
			if (userTicket == null) {
				KBaseErrorManager.throwMessage(KBaseErrCodeConstants.USER_LOGIN_TIMEOUT, "用户登录超时", "SESSION ID",
						ticket);
			}
			UserProfileEntity userEntity = userMapper.getByPk(userTicket.getUserId());
			baseRequestDTO.getContext().getUser().setUserId(userEntity.getUserId());
			baseRequestDTO.getContext().getUser().setUserName(userEntity.getUserName());
			baseRequestDTO.getContext().getUser().setLvl(userEntity.getLvl());
			baseRequestDTO.getContext().getUser().setTicket(ticket);
		}

		return (BaseResponseDTO) joinPoint.proceed(objs);

	}

}
