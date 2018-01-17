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
 * @createTime :2018��1��17�� ����4:46:19
 * @version: v1.0
 */
public class KnowledgeBaseQueryResponseDTO extends BaseTradeResponseDTO {

	/**
	 * ֪ʶ���
	 */
	private String kId;
	/**
	 * ֪ʶ��Ϣ
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
