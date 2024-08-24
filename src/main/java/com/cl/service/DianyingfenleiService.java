package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DianyingfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianyingfenleiView;


/**
 * 电影分类
 *
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
public interface DianyingfenleiService extends IService<DianyingfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingfenleiView> selectListView(Wrapper<DianyingfenleiEntity> wrapper);
   	
   	DianyingfenleiView selectView(@Param("ew") Wrapper<DianyingfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingfenleiEntity> wrapper);
   	

}

