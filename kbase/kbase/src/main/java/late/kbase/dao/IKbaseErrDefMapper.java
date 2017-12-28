package late.kbase.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import late.kbase.entity.KbaseErrDefEntity;

@Repository
public interface IKbaseErrDefMapper extends BaseMapper<KbaseErrDefEntity, String> {

	/**
	 * 获取所有记录
	 * 
	 * @methodName getAll
	 * @author chijingjia
	 * @createTime 2017年12月25日 下午10:04:39
	 * @version v1.0
	 * @return
	 */
	List<KbaseErrDefEntity> getAll();
}