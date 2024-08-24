package com.cl.dao;

import com.cl.entity.DianyingfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianyingfenleiView;


/**
 * 电影分类
 * 
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
public interface DianyingfenleiDao extends BaseMapper<DianyingfenleiEntity> {
	
	List<DianyingfenleiView> selectListView(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);

	List<DianyingfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
	
	DianyingfenleiView selectView(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
	

}
