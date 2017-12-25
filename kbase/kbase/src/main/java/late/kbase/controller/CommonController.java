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

import com.alibaba.fastjson.JSONObject;

import late.kbase.dto.UserLoginRequestDTO;
import late.kbase.dto.UserLoginResponseDTO;
import late.kbase.entity.UserProfile;
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
		JSONObject json = (JSONObject) JSONObject.toJSON(request);
		System.out.println(json.toString());

		UserLoginResponseDTO resonse = new UserLoginResponseDTO();
		UserProfile user = userService.getUserByUsername(request.getUser().getUserName());

		resonse.setUser(user);
		return resonse;
	}
}
