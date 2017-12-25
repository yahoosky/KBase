/**
 * 
 */
package late.kbase.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import late.kbase.dto.UserLoginRequestDTO;
import late.kbase.dto.UserLoginResponseDTO;
import late.kbase.entity.UserProfileEntity;
import late.kbase.excp.KBaseException;
import late.kbase.service.IUserService;

/**
 * 知识库控制器
 * 
 * @projectName kbase
 * @packageName late.kbase.controller
 * @fileName KBaseController.java
 * @author chijingjia
 * @createTime :2017年12月14日 上午10:00:03
 * @version: v1.0
 */
@Controller
@RequestMapping("kbase")
public class KBaseController extends BaseController {
	static Logger logger = Logger.getLogger(CommonController.class);

	@Resource
	IUserService userService = null;

	@RequestMapping(value = "show", method = RequestMethod.POST)
	@ResponseBody
	public UserLoginResponseDTO showUser(@RequestBody UserLoginRequestDTO request) {

		UserLoginResponseDTO resonse = new UserLoginResponseDTO();
		try {
			UserProfileEntity user = userService.getUserByUsername(request.getUser().getUserName());
			resonse.setUser(user);
		} catch (KBaseException e) {
			resonse.setRetInfo(e.getErrCode(), e.getErrMsg());
		}

		return resonse;
	}
}
