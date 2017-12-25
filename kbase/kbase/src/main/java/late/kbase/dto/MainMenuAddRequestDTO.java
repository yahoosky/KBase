/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeRequestDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * ���˵�����ϴ�ʵ��
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuAddRequestDTO.java
 * @author chijingjia
 * @createTime :2017��12��14�� ����10:45:06
 * @version: v1.0
 */
public class MainMenuAddRequestDTO extends BaseTradeRequestDTO {

	/**
	 * �˵�����
	 */
	private KbaseMenuMastEntity menuMast;

	public KbaseMenuMastEntity getMenuMast() {
		return menuMast;
	}

	public void setMenuMast(KbaseMenuMastEntity menuMast) {
		this.menuMast = menuMast;
	}

}
