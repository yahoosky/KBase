/**
 * 
 */
package late.kbase.dto;

import late.comm.dto.BaseQueryRequestDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * 主菜单查询上传实体
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuQueryRequestDTO.java
 * @author chijingjia
 * @createTime :2017年12月14日 上午10:48:45
 * @version: v1.0
 */
public class MainMenuQueryRequestDTO extends BaseQueryRequestDTO {

	/**
	 * 菜单主体
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
