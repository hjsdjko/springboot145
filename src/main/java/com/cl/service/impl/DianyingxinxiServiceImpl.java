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


import com.cl.dao.DianyingxinxiDao;
import com.cl.entity.DianyingxinxiEntity;
import com.cl.service.DianyingxinxiService;
import com.cl.entity.view.DianyingxinxiView;

@Service("dianyingxinxiService")
public class DianyingxinxiServiceImpl extends ServiceImpl<DianyingxinxiDao, DianyingxinxiEntity> implements DianyingxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingxinxiEntity> page = this.selectPage(
                new Query<DianyingxinxiEntity>(params).getPage(),
                new EntityWrapper<DianyingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingxinxiEntity> wrapper) {
		  Page<DianyingxinxiView> page =new Query<DianyingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DianyingxinxiView> selectListView(Wrapper<DianyingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingxinxiView selectView(Wrapper<DianyingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
