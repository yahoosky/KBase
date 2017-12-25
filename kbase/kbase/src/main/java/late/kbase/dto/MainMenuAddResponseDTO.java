/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeResponseDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * 主菜单添加下传实体
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuAddResponseDTO.java
 * @author chijingjia
 * @createTime :2017年12月14日 上午10:47:06
 * @version: v1.0
 */
public class MainMenuAddResponseDTO extends BaseTradeResponseDTO {

	/**
	 * 菜单实体
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
