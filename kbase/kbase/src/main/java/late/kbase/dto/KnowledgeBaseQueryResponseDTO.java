/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeResponseDTO;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName KnowledgeBaseQueryResponseDTO.java
 * @author chijingjia
 * @createTime :2018年1月17日 下午4:46:19
 * @version: v1.0
 */
public class KnowledgeBaseQueryResponseDTO extends BaseTradeResponseDTO {

	/**
	 * 知识编号
	 */
	private String kId;
	/**
	 * 知识信息
	 */
	private String kTextArea;

	/**
	 * @return the kId
	 */
	public String getkId() {
		return kId;
	}

	/**
	 * @param kId
	 *            the kId to set
	 */
	public void setkId(String kId) {
		this.kId = kId;
	}

	/**
	 * @return the kTextArea
	 */
	public String getkTextArea() {
		return kTextArea;
	}

	/**
	 * @param kTextArea
	 *            the kTextArea to set
	 */
	public void setkTextArea(String kTextArea) {
		this.kTextArea = kTextArea;
	}

}
