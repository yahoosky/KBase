package late.kbase.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import late.kbase.entity.KbaseErrDefEntity;

@Repository
public interface IKbaseErrDefMapper extends BaseMapper<KbaseErrDefEntity, String> {

	/**
	 * ��ȡ���м�¼
	 * 
	 * @methodName getAll
	 * @author chijingjia
	 * @createTime 2017��12��25�� ����10:04:39
	 * @version v1.0
	 * @return
	 */
	List<KbaseErrDefEntity> getAll();
}