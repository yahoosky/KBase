/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeResponseDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * ���˵�����´�ʵ��
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuAddResponseDTO.java
 * @author chijingjia
 * @createTime :2017��12��14�� ����10:47:06
 * @version: v1.0
 */
public class MainMenuAddResponseDTO extends BaseTradeResponseDTO {

	/**
	 * �˵�ʵ��
	 */
	private KbaseMenuMastEntity menuMast;

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

}
