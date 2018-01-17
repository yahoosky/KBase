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

import com.alibaba.fastjson.JSONObject;

import late.comm.dto.BaseResponseDTO;
import late.comm.dto.BaseTradeRequestDTO;
import late.comm.log.TraceLogger;
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
	private static final String THIS_COMPONMENT_NAME = UserAop.class.getName();
	static final String TICKET_MARK = "ticket";

	@Resource
	IKbaseUserTicketMapper ticketMapper = null;
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
	 * PointCutû���������ã�ֻ�����������
	 * 
	 * @methodName getUserById
	 * @author chijingjia
	 * @createTime 2018��1��15�� ����10:23:38
	 * @version v1.0
	 */
	@Pointcut("execution(* late.kbase.controller.KBaseController.*(..))")
	private void kbaseController() {
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

	/**
	 * �������棬����ticket��ȡ�û���Ϣ
	 * 
	 * @notice late.kbase.controller.CommonController.login()
	 * @methodName getUserById
	 * @author chijingjia
	 * @createTime 2018��1��15�� ����3:10:33
	 * @version v1.0
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("late.kbase.aop.UserAop.commonController()||late.kbase.aop.UserAop.kbaseController()")
	public BaseResponseDTO getUserById(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] objs = joinPoint.getArgs();

		if (objs[0] instanceof BaseTradeRequestDTO) {
			BaseTradeRequestDTO baseRequestDTO = (BaseTradeRequestDTO) objs[0];

			TraceLogger.tradeStep(THIS_COMPONMENT_NAME, "���ս���", "����", JSONObject.toJSONString(baseRequestDTO));

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			HttpSession session = request.getSession();
			String ticket = (String) session.getAttribute(TICKET_MARK);
			KbaseUserTicketEntity ticketEntity = null;
			if (ticket == null) {
				Long userId = baseRequestDTO.getContext().getUser().getUserId();
				if (userId == null) {
					KBaseErrorManager.throwMessage(KBaseErrCodeConstants.USER_CONTEXT_ISNULL, "�û�����δ����");
				}
				ticket = session.getId();
				session.setAttribute(TICKET_MARK, ticket);
				baseRequestDTO.getContext().getUser().setTicket(ticket);
				// �Ǽ�ticket
				ticketEntity = new KbaseUserTicketEntity();
				ticketEntity.setTicket(ticket);
				ticketEntity.setUserId(baseRequestDTO.getContext().getUser().getUserId());
				ticketMapper.insert(ticketEntity);
			} else {
				KbaseUserTicketEntity userTicket = ticketMapper.getByPk(ticket);
				if (userTicket == null) {
					KBaseErrorManager.throwMessage(KBaseErrCodeConstants.USER_LOGIN_TIMEOUT, "�û���¼��ʱ", "SESSION ID",
							ticket);
				}
				UserProfileEntity userEntity = userMapper.getByPk(userTicket.getUserId());
				baseRequestDTO.getContext().getUser().setUserId(userEntity.getUserId());
				baseRequestDTO.getContext().getUser().setUserName(userEntity.getUserName());
				baseRequestDTO.getContext().getUser().setLvl(userEntity.getLvl());
				baseRequestDTO.getContext().getUser().setTicket(ticket);
			}
		}
		BaseResponseDTO response = null;
		try {
			response = (BaseResponseDTO) joinPoint.proceed(objs);
		} catch (Throwable e) {
			if (response == null) {
				response = new BaseResponseDTO() {
				};
			}
			TraceLogger.error(joinPoint.getTarget().getClass().getName(), "���׳����쳣", e);
			response.setExcp(e);
		}
		return response;

	}

}
