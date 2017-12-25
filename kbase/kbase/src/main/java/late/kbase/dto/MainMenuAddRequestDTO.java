/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseTradeRequestDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * 主菜单添加上传实体
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuAddRequestDTO.java
 * @author chijingjia
 * @createTime :2017年12月14日 上午10:45:06
 * @version: v1.0
 */
public class MainMenuAddRequestDTO extends BaseTradeRequestDTO {

	/**
	 * 菜单主体
	 */
	private KbaseMenuMastEntity menuMast;

	public KbaseMenuMastEntity getMenuMast() {
		return menuMast;
	}

	public void setMenuMast(KbaseMenuMastEntity menuMast) {
		this.menuMast = menuMast;
	}

}
