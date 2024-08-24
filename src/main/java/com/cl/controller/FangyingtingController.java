package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.FangyingtingEntity;
import com.cl.entity.view.FangyingtingView;

import com.cl.service.FangyingtingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 放映厅
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
@RestController
@RequestMapping("/fangyingting")
public class FangyingtingController {
    @Autowired
    private FangyingtingService fangyingtingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyingtingEntity fangyingting,
		HttpServletRequest request){
        EntityWrapper<FangyingtingEntity> ew = new EntityWrapper<FangyingtingEntity>();

		PageUtils page = fangyingtingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyingting), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyingtingEntity fangyingting, 
		HttpServletRequest request){
        EntityWrapper<FangyingtingEntity> ew = new EntityWrapper<FangyingtingEntity>();

		PageUtils page = fangyingtingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyingting), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyingtingEntity fangyingting){
       	EntityWrapper<FangyingtingEntity> ew = new EntityWrapper<FangyingtingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyingting, "fangyingting")); 
        return R.ok().put("data", fangyingtingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyingtingEntity fangyingting){
        EntityWrapper< FangyingtingEntity> ew = new EntityWrapper< FangyingtingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyingting, "fangyingting")); 
		FangyingtingView fangyingtingView =  fangyingtingService.selectView(ew);
		return R.ok("查询放映厅成功").put("data", fangyingtingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyingtingEntity fangyingting = fangyingtingService.selectById(id);
        return R.ok().put("data", fangyingting);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyingtingEntity fangyingting = fangyingtingService.selectById(id);
        return R.ok().put("data", fangyingting);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyingtingEntity fangyingting, HttpServletRequest request){
    	fangyingting.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyingting);
        fangyingtingService.insert(fangyingting);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangyingtingEntity fangyingting, HttpServletRequest request){
    	fangyingting.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyingting);
        fangyingtingService.insert(fangyingting);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangyingtingEntity fangyingting, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyingting);
        fangyingtingService.updateById(fangyingting);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyingtingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
