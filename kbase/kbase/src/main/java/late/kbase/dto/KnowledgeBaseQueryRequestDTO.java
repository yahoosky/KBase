/**
 * 
 */
package late.kbase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import late.comm.dto.BaseTradeRequestDTO;
import late.kbase.entity.KbaseKnowledgeMastEntity;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName KnowledgeBaseQueryRequestDTO.java
 * @author chijingjia
 * @createTime :2018年1月17日 下午4:44:49
 * @version: v1.0
 */
@JsonIgnoreProperties
public class KnowledgeBaseQueryRequestDTO extends BaseTradeRequestDTO {
	private KbaseKnowledgeMastEntity kMast;

	/**
	 * @return the kMast
	 */
	public KbaseKnowledgeMastEntity getkMast() {
		return kMast;
	}

	/**
	 * @param kMast
	 *            the kMast to set
	 */
	public void setkMast(KbaseKnowledgeMastEntity kMast) {
		this.kMast = kMast;
	}

}
