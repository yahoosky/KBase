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
			System.out.println("���û�");
		}
	}

}
