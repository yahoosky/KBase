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
	static Logger logger = Logger.getLogger(CommonController.class);

	@Resource
	IUserService userService = null;

	@RequestMapping(value = "show", method = RequestMethod.POST)
	@ResponseBody
	public UserLoginResponseDTO showUser(@RequestBody UserLoginRequestDTO request) {

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
}
