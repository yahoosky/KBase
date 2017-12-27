/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseQueryRequestDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * ���˵���ѯ�ϴ�ʵ��
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuQueryRequestDTO.java
 * @author chijingjia
 * @createTime :2017��12��14�� ����10:48:45
 * @version: v1.0
 */
public class MainMenuQueryRequestDTO extends BaseQueryRequestDTO {

	/**
	 * �˵�����
	 */
	private KbaseMenuMastEntity menuMast;
	/**
	 * ��ʾ�㼶 0-ȫ��
	 */
	private int lvl;

	/**
	 * @return the menuMast
	 */
	public KbaseMenuMastEntity getMenuMast() {
		return menuMast;
	}

	/**
	 * @param menuMast
	 *            the menuMast to set
	 */
	public void setMenuMast(KbaseMenuMastEntity menuMast) {
		this.menuMast = menuMast;
	}

	/**
	 * @return the lvl
	 */
	public int getLvl() {
		return lvl;
	}

	/**
	 * @param lvl
	 *            the lvl to set
	 */
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

}
