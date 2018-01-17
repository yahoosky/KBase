/**
 * 
 */
package late.kbase.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import late.kbase.contant.KBaseErrCodeConstants;
import late.kbase.dao.IKbaseKnowledgeDetlMapper;
import late.kbase.dao.IKbaseKnowledgeMastMapper;
import late.kbase.dao.IKbaseKnowledgeTagMapper;
import late.kbase.dto.KnowledgeBaseAddRequestDTO;
import late.kbase.dto.KnowledgeBaseAddResponseDTO;
import late.kbase.entity.KbaseKnowledgeDetlEntity;
import late.kbase.entity.KbaseKnowledgeMastEntity;
import late.kbase.entity.KbaseKnowledgeTagEntity;
import late.kbase.excp.KBaseErrorManager;
import late.kbase.excp.KBaseException;

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

	@Resource
	IKbaseKnowledgeMastMapper kMastMapper = null;
	@Resource
	IKbaseKnowledgeDetlMapper kDetlMapper = null;
	@Resource
	IKbaseKnowledgeTagMapper ktagMapper = null;

	/**
	 * 创建知识点
	 * 
	 * @methodName createK
	 * @author chijingjia
	 * @createTime 2018年1月16日 上午10:06:42
	 * @version v1.0
	 * @param request
	 * @return
	 * @throws KBaseException
	 */
	@RequestMapping(value = "kCreate", method = RequestMethod.POST)
	@ResponseBody
	public KnowledgeBaseAddResponseDTO createK(@RequestBody KnowledgeBaseAddRequestDTO request) throws KBaseException {

		KnowledgeBaseAddResponseDTO resonse = new KnowledgeBaseAddResponseDTO();

		KbaseKnowledgeMastEntity kmastEntity = request.getkMast();
		KbaseKnowledgeDetlEntity kdetlEntity = request.getkDetl().toEntity();
		KbaseKnowledgeTagEntity[] ktagEnties = request.getkTags();

		KbaseKnowledgeMastEntity checkKMastEntity = kMastMapper.getByPk(kmastEntity.getId());
		if (checkKMastEntity != null) {
			KBaseErrorManager.throwMessage(KBaseErrCodeConstants.DB_RECORD_ALREADY_EXISTS, "记录已存在", "ID",
					String.valueOf(kmastEntity.getId()));
		}

		kMastMapper.insert(kmastEntity);
		kDetlMapper.insert(kdetlEntity);
		for (KbaseKnowledgeTagEntity ktagEntity : ktagEnties) {
			ktagMapper.insert(ktagEntity);
		}

		return resonse;
	}
}
