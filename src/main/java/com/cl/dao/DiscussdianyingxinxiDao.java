package com.cl.dao;

import com.cl.entity.DiscussdianyingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussdianyingxinxiView;


/**
 * 电影信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-08 09:58:50
 */
public interface DiscussdianyingxinxiDao extends BaseMapper<DiscussdianyingxinxiEntity> {
	
	List<DiscussdianyingxinxiView> selectListView(@Param("ew") Wrapper<DiscussdianyingxinxiEntity> wrapper);

	List<DiscussdianyingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdianyingxinxiEntity> wrapper);
	
	DiscussdianyingxinxiView selectView(@Param("ew") Wrapper<DiscussdianyingxinxiEntity> wrapper);
	

}
