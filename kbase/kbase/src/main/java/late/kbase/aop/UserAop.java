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
 * @createTime :2018��1��12�� ����2:44:28
 * @version: v1.0
 */
/**
 * �����������Ϊһ�����棺 1. ʹ��ע�⡰@Repository���Ѹ�����뵽IOC������ 2. ʹ��ע�⡰@Aspect���Ѹ�������Ϊһ������
 * 
 * ������������ȼ�: 3. ʹ��ע�⡰@Order(number)��ָ��ǰ������ȼ���ֵԽС�����ȼ�Խ��
 */
@Order(1)
@Aspect
@Repository
public class UserAop {

	@Resource
	IUserProfileMapper userMapper = null;

	/**
	 * PointCutû���������ã�ֻ�����������
	 * 
	 * @methodName getUserById
	 * @author chijingjia
	 * @createTime 2018��1��15�� ����10:23:38
	 * @version v1.0
	 */
	@Pointcut("execution(* late.kbase.controller.CommonController.*(..))")
	private void commonController() {
	}

	/**
	 * �û���¼�е�
	 * 
	 * @methodName userLogion
	 * @author chijingjia
	 * @createTime 2018��1��15�� ����10:57:03
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
