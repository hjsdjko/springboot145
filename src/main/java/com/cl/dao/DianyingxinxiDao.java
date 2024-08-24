package com.cl.dao;

import com.cl.entity.DianyingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianyingxinxiView;


/**
 * 电影信息
 * 
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
public interface DianyingxinxiDao extends BaseMapper<DianyingxinxiEntity> {
	
	List<DianyingxinxiView> selectListView(@Param("ew") Wrapper<DianyingxinxiEntity> wrapper);

	List<DianyingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingxinxiEntity> wrapper);
	
	DianyingxinxiView selectView(@Param("ew") Wrapper<DianyingxinxiEntity> wrapper);
	

}
