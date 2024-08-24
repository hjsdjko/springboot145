package com.cl.dao;

import com.cl.entity.FangyingtingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyingtingView;


/**
 * 放映厅
 * 
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
public interface FangyingtingDao extends BaseMapper<FangyingtingEntity> {
	
	List<FangyingtingView> selectListView(@Param("ew") Wrapper<FangyingtingEntity> wrapper);

	List<FangyingtingView> selectListView(Pagination page,@Param("ew") Wrapper<FangyingtingEntity> wrapper);
	
	FangyingtingView selectView(@Param("ew") Wrapper<FangyingtingEntity> wrapper);
	

}
