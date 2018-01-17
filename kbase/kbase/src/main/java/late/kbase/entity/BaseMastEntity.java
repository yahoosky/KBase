/**
 * 
 */
package late.kbase.entity;

import java.util.Date;

/**
 * 主体类抽象父类
 * 
 * @projectName kbase
 * @packageName late.kbase.entity
 * @fileName BaseMastEntity.java
 * @author chijingjia
 * @createTime :2018年1月16日 上午9:27:14
 * @version: v1.0
 */
public abstract class BaseMastEntity extends BaseEntity {
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.k_id
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private String id;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.k_title
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private String desc;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.make_user
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private Long makeUser;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.make_date
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private Date makeDate;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.last_mnt_user
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private Long lastMntUser;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.last_mnt_date
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private Date lastMntDate;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kbase_knowledge_mast.flg_mnt_status
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	private String flgMntStatus;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_mast.make_user
	 *
	 * @return the value of kbase_knowledge_mast.make_user
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public Long getMakeUser() {
		return makeUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_mast.make_user
	 *
	 * @param makeUser
	 *            the value for kbase_knowledge_mast.make_user
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public void setMakeUser(Long makeUser) {
		this.makeUser = makeUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_mast.make_date
	 *
	 * @return the value of kbase_knowledge_mast.make_date
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public Date getMakeDate() {
		return makeDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_mast.make_date
	 *
	 * @param makeDate
	 *            the value for kbase_knowledge_mast.make_date
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_mast.last_mnt_user
	 *
	 * @return the value of kbase_knowledge_mast.last_mnt_user
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public Long getLastMntUser() {
		return lastMntUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_mast.last_mnt_user
	 *
	 * @param lastMntUser
	 *            the value for kbase_knowledge_mast.last_mnt_user
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public void setLastMntUser(Long lastMntUser) {
		this.lastMntUser = lastMntUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_mast.last_mnt_date
	 *
	 * @return the value of kbase_knowledge_mast.last_mnt_date
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public Date getLastMntDate() {
		return lastMntDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_mast.last_mnt_date
	 *
	 * @param lastMntDate
	 *            the value for kbase_knowledge_mast.last_mnt_date
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public void setLastMntDate(Date lastMntDate) {
		this.lastMntDate = lastMntDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kbase_knowledge_mast.flg_mnt_status
	 *
	 * @return the value of kbase_knowledge_mast.flg_mnt_status
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public String getFlgMntStatus() {
		return flgMntStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kbase_knowledge_mast.flg_mnt_status
	 *
	 * @param flgMntStatus
	 *            the value for kbase_knowledge_mast.flg_mnt_status
	 *
	 * @mbg.generated Tue Jan 16 09:06:45 CST 2018
	 */
	public void setFlgMntStatus(String flgMntStatus) {
		this.flgMntStatus = flgMntStatus;
	}
}
