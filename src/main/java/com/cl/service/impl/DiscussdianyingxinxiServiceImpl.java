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


import com.cl.dao.DiscussdianyingxinxiDao;
import com.cl.entity.DiscussdianyingxinxiEntity;
import com.cl.service.DiscussdianyingxinxiService;
import com.cl.entity.view.DiscussdianyingxinxiView;

@Service("discussdianyingxinxiService")
public class DiscussdianyingxinxiServiceImpl extends ServiceImpl<DiscussdianyingxinxiDao, DiscussdianyingxinxiEntity> implements DiscussdianyingxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdianyingxinxiEntity> page = this.selectPage(
                new Query<DiscussdianyingxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussdianyingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdianyingxinxiEntity> wrapper) {
		  Page<DiscussdianyingxinxiView> page =new Query<DiscussdianyingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussdianyingxinxiView> selectListView(Wrapper<DiscussdianyingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdianyingxinxiView selectView(Wrapper<DiscussdianyingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
