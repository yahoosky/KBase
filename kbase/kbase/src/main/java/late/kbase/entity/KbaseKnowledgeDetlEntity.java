package late.kbase.entity;

public class KbaseKnowledgeDetlEntity extends BaseDetlEntity {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_dtls.k_id
	 * 
	 * @mbg.generated Mon Jan 15 18:05:33 CST 2018
	 */
	private String kId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_dtls.k_text
	 * 
	 * @mbg.generated Mon Jan 15 18:05:33 CST 2018
	 */
	private byte[] kText;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_dtls.k_id
	 * 
	 * @return the value of kbase_knowledge_dtls.k_id
	 * @mbg.generated Mon Jan 15 18:05:33 CST 2018
	 */
	public String getkId() {
		return kId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_dtls.k_id
	 * 
	 * @param kId
	 *            the value for kbase_knowledge_dtls.k_id
	 * @mbg.generated Mon Jan 15 18:05:33 CST 2018
	 */
	public void setkId(String kId) {
		this.kId = kId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_dtls.k_text
	 * 
	 * @return the value of kbase_knowledge_dtls.k_text
	 * @mbg.generated Mon Jan 15 18:05:33 CST 2018
	 */
	public byte[] getkText() {
		return kText;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_dtls.k_text
	 * 
	 * @param kText
	 *            the value for kbase_knowledge_dtls.k_text
	 * @mbg.generated Mon Jan 15 18:05:33 CST 2018
	 */
	public void setkText(byte[] kText) {
		this.kText = kText;
	}
	
}