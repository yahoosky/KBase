/**
 * 
 */
package late.kbase.dto;

import java.util.List;

import late.comm.dto.BaseQueryResponseDTO;
import late.kbase.entity.KbaseMenuMastEntity;

/**
 * 主菜单查询下传实体
 * 
 * @projectName kbase
 * @packageName late.kbase.dto
 * @fileName MainMenuQueryResponseDTO.java
 * @author chijingjia
 * @createTime :2017年12月14日 上午10:49:50
 * @version: v1.0
 */
public class MainMenuQueryResponseDTO extends BaseQueryResponseDTO {

	List<KbaseMenuMastEntity> menuMasts;

	/**
	 * @return the menuMasts
	 */
	public List<KbaseMenuMastEntity> getMenuMasts() {
		return menuMasts;
	}

	/**
	 * @param menuMasts
	 *            the menuMasts to set
	 */
	public void setMenuMasts(List<KbaseMenuMastEntity> menuMasts) {
		this.menuMasts = menuMasts;
	}

}
