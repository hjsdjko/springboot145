package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DianyingfenleiDao;
import com.cl.entity.DianyingfenleiEntity;
import com.cl.service.DianyingfenleiService;
import com.cl.entity.view.DianyingfenleiView;

@Service("dianyingfenleiService")
public class DianyingfenleiServiceImpl extends ServiceImpl<DianyingfenleiDao, DianyingfenleiEntity> implements DianyingfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingfenleiEntity> page = this.selectPage(
                new Query<DianyingfenleiEntity>(params).getPage(),
                new EntityWrapper<DianyingfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingfenleiEntity> wrapper) {
		  Page<DianyingfenleiView> page =new Query<DianyingfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DianyingfenleiView> selectListView(Wrapper<DianyingfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingfenleiView selectView(Wrapper<DianyingfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
