package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DianyingxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianyingxinxiView;


/**
 * 电影信息
 *
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
public interface DianyingxinxiService extends IService<DianyingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingxinxiView> selectListView(Wrapper<DianyingxinxiEntity> wrapper);
   	
   	DianyingxinxiView selectView(@Param("ew") Wrapper<DianyingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingxinxiEntity> wrapper);
   	

}

