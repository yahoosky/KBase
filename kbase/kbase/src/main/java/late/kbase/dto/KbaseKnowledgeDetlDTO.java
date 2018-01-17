/**
 * 
 */
package late.kbase.dto;

import late.kbase.entity.KbaseKnowledgeDetlEntity;

/**
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName KbaseKnowledgeDetlDTO.java
 * @author chijingjia
 * @createTime :2018年1月16日 下午3:02:34
 * @version: v1.0
 */
public class KbaseKnowledgeDetlDTO extends KbaseKnowledgeDetlEntity
		implements IEntityConvertDTO<KbaseKnowledgeDetlEntity> {
	private String kTextArea;

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

	public KbaseKnowledgeDetlEntity toEntity() {
		this.setkText(this.getkTextArea().getBytes());
		return this;
	}

}
