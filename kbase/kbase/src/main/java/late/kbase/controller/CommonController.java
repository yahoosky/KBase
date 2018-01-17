/**
 * 
 */
package late.kbase.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import late.comm.UserProfile;
import late.kbase.dto.KnowledgeBaseAddRequestDTO;
import late.kbase.dto.KnowledgeBaseAddResponseDTO;
import late.kbase.dto.MainMenuAddRequestDTO;
import late.kbase.dto.MainMenuAddResponseDTO;
import late.kbase.dto.MainMenuQueryRequestDTO;
import late.kbase.dto.MainMenuQueryResponseDTO;
import late.kbase.dto.UserLoginRequestDTO;
import late.kbase.dto.UserLoginResponseDTO;
import late.kbase.entity.KbaseMenuMastEntity;
import late.kbase.entity.UserProfileEntity;
import late.kbase.excp.KBaseException;
import late.kbase.service.IMenuService;
import late.kbase.service.IUserService;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.controller
 * @fileName CommonController.java
 * @author chijingjia
 * @createTime :2017年12月2日 上午7:12:45
 * @version: v1.0
 */
@Controller
@RequestMapping("comm")
public class CommonController {
	private static final String THIS_COMPONMENT_NAME = CommonController.class.getName();

	@Resource
	IUserService userService = null;
	@Resource
	IMenuService menuService = null;

	/**
	 * 用户登录，为了切面区分获取用户，将方法独立
	 * 
	 * @see late.kbase.aop.UserAop.getUserById() 方式
	 * @methodName login
	 * @author chijingjia
	 * @createTime 2018年1月15日 上午10:58:12
	 * @version v1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO request) {
		UserLoginResponseDTO resopnse = getUser(request);
		UserProfile contextUser = new UserProfile();

		String sessionId = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
				.getSession().getId();

		contextUser.setTicket(sessionId);
		contextUser.setUserId(resopnse.getUser().getUserId());
		contextUser.setUserName(resopnse.getUser().getUserName());
		contextUser.setLvl(resopnse.getUser().getLvl());
		resopnse.setContextUser(contextUser);

		return resopnse;
	}

	/**
	 * 获取用户信息
	 * 
	 * @methodName getUser
	 * @author chijingjia
	 * @createTime 2017年12月27日 下午6:56:14
	 * @version v1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getUser", method = RequestMethod.POST)
	@ResponseBody
	public UserLoginResponseDTO getUser(@RequestBody UserLoginRequestDTO request) {
		UserLoginResponseDTO resonse = new UserLoginResponseDTO();
		UserProfileEntity user = null;
		try {
			user = userService.getUserByUsername(request.getUser().getUserName());
		} catch (KBaseException e) {
			resonse.setRetInfo(e.getErrCode(), e.getErrMsg());
		}

		resonse.setUser(user);
		return resonse;
	}

	/**
	 * 查询主菜单列表
	 * 
	 * @methodName qryMainMenu
	 * @author chijingjia
	 * @createTime 2017年12月27日 下午6:58:10
	 * @version v1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getMenu", method = RequestMethod.POST)
	@ResponseBody
	public MainMenuQueryResponseDTO qryMainMenu(@RequestBody MainMenuQueryRequestDTO request) {
		MainMenuQueryResponseDTO response = new MainMenuQueryResponseDTO();

		List<KbaseMenuMastEntity> menuList = menuService.queryMenuByParentId(request.getMenuMast().getParentId(),
				request.getLvl());

		response.setMenuMasts(menuList);

		return response;
	}

	/**
	 * 添加主菜单信息
	 * 
	 * @methodName addMainMenu
	 * @author chijingjia
	 * @createTime 2017年12月28日 上午9:23:52
	 * @version v1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addMenu", method = RequestMethod.POST)
	@ResponseBody
	public MainMenuAddResponseDTO addMainMenu(@RequestBody MainMenuAddRequestDTO request) {
		MainMenuAddResponseDTO response = new MainMenuAddResponseDTO();
		KbaseMenuMastEntity mastEntity = request.getMenuMast();

		try {
			menuService.addMenu(mastEntity);
		} catch (KBaseException e) {
			e.printStackTrace();
			response.setExcp(e);
		}

		return response;
	}

	/**
	 * 添加知识点
	 * 
	 * @methodName addKBase
	 * @author chijingjia
	 * @createTime 2018年1月15日 下午4:46:33
	 * @version v1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addKBase", method = RequestMethod.POST)
	@ResponseBody
	public KnowledgeBaseAddResponseDTO addKBase(KnowledgeBaseAddRequestDTO request) {
		KnowledgeBaseAddResponseDTO response = new KnowledgeBaseAddResponseDTO();

		return response;

	}

}
