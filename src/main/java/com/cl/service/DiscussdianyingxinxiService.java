package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussdianyingxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussdianyingxinxiView;


/**
 * 电影信息评论表
 *
 * @author 
 * @email 
 * @date 2024-01-08 09:58:50
 */
public interface DiscussdianyingxinxiService extends IService<DiscussdianyingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdianyingxinxiView> selectListView(Wrapper<DiscussdianyingxinxiEntity> wrapper);
   	
   	DiscussdianyingxinxiView selectView(@Param("ew") Wrapper<DiscussdianyingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdianyingxinxiEntity> wrapper);
   	

}

