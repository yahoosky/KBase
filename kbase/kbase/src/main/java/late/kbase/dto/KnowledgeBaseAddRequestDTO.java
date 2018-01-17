/**
 * 
 */
package late.kbase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import late.comm.dto.BaseTradeRequestDTO;
import late.kbase.entity.KbaseKnowledgeMastEntity;
import late.kbase.entity.KbaseKnowledgeTagEntity;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName KnowledgeBaseAddRequestDTO.java
 * @author chijingjia
 * @createTime :2018年1月15日 下午4:44:25
 * @version: v1.0
 */
@JsonIgnoreProperties
public class KnowledgeBaseAddRequestDTO extends BaseTradeRequestDTO {
	private KbaseKnowledgeMastEntity kMast;

	private KbaseKnowledgeDetlDTO kDetl;

	private KbaseKnowledgeTagEntity[] kTags;

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

	/**
	 * @return the kDetl
	 */
	public KbaseKnowledgeDetlDTO getkDetl() {
		return kDetl;
	}

	/**
	 * @param kDetl
	 *            the kDetl to set
	 */
	public void setkDetl(KbaseKnowledgeDetlDTO kDetl) {
		this.kDetl = kDetl;
	}

	/**
	 * @return the kTags
	 */
	public KbaseKnowledgeTagEntity[] getkTags() {
		return kTags;
	}

	/**
	 * @param kTags
	 *            the kTags to set
	 */
	public void setkTags(KbaseKnowledgeTagEntity[] kTags) {
		this.kTags = kTags;
	}

}
