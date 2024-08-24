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
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;

import com.cl.entity.DianyingxinxiEntity;
import com.cl.entity.view.DianyingxinxiView;

import com.cl.service.DianyingxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 电影信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-08 09:58:49
 */
@RestController
@RequestMapping("/dianyingxinxi")
public class DianyingxinxiController {
    @Autowired
    private DianyingxinxiService dianyingxinxiService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingxinxiEntity dianyingxinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date changcistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date changciend,
		HttpServletRequest request){
        EntityWrapper<DianyingxinxiEntity> ew = new EntityWrapper<DianyingxinxiEntity>();
                if(changcistart!=null) ew.ge("changci", changcistart);
                if(changciend!=null) ew.le("changci", changciend);

		PageUtils page = dianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingxinxiEntity dianyingxinxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date changcistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date changciend,
		HttpServletRequest request){
        EntityWrapper<DianyingxinxiEntity> ew = new EntityWrapper<DianyingxinxiEntity>();
                if(changcistart!=null) ew.ge("changci", changcistart);
                if(changciend!=null) ew.le("changci", changciend);

		PageUtils page = dianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyingxinxiEntity dianyingxinxi){
       	EntityWrapper<DianyingxinxiEntity> ew = new EntityWrapper<DianyingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianyingxinxi, "dianyingxinxi")); 
        return R.ok().put("data", dianyingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyingxinxiEntity dianyingxinxi){
        EntityWrapper< DianyingxinxiEntity> ew = new EntityWrapper< DianyingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianyingxinxi, "dianyingxinxi")); 
		DianyingxinxiView dianyingxinxiView =  dianyingxinxiService.selectView(ew);
		return R.ok("查询电影信息成功").put("data", dianyingxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingxinxiEntity dianyingxinxi = dianyingxinxiService.selectById(id);
		dianyingxinxi.setClicknum(dianyingxinxi.getClicknum()+1);
		dianyingxinxi.setClicktime(new Date());
		dianyingxinxiService.updateById(dianyingxinxi);
        return R.ok().put("data", dianyingxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyingxinxiEntity dianyingxinxi = dianyingxinxiService.selectById(id);
		dianyingxinxi.setClicknum(dianyingxinxi.getClicknum()+1);
		dianyingxinxi.setClicktime(new Date());
		dianyingxinxiService.updateById(dianyingxinxi);
        return R.ok().put("data", dianyingxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        DianyingxinxiEntity dianyingxinxi = dianyingxinxiService.selectById(id);
        if(type.equals("1")) {
        	dianyingxinxi.setThumbsupnum(dianyingxinxi.getThumbsupnum()+1);
        } else {
        	dianyingxinxi.setCrazilynum(dianyingxinxi.getCrazilynum()+1);
        }
        dianyingxinxiService.updateById(dianyingxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingxinxiEntity dianyingxinxi, HttpServletRequest request){
    	dianyingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingxinxi);
        dianyingxinxiService.insert(dianyingxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingxinxiEntity dianyingxinxi, HttpServletRequest request){
    	dianyingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingxinxi);
        dianyingxinxiService.insert(dianyingxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingxinxiEntity dianyingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianyingxinxi);
        dianyingxinxiService.updateById(dianyingxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DianyingxinxiEntity dianyingxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DianyingxinxiEntity> ew = new EntityWrapper<DianyingxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = dianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingxinxi), params), params));
        return R.ok().put("data", page);
    }

        /**
     * 按用户购买推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,DianyingxinxiEntity dianyingxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "dianyingfenlei";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "dianyingxinxi").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<DianyingxinxiEntity> dianyingxinxiList = new ArrayList<DianyingxinxiEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        dianyingxinxiList.addAll(dianyingxinxiService.selectList(new EntityWrapper<DianyingxinxiEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<DianyingxinxiEntity> ew = new EntityWrapper<DianyingxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = dianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingxinxi), params), params));
        List<DianyingxinxiEntity> pageList = (List<DianyingxinxiEntity>)page.getList();
        if(dianyingxinxiList.size()<limit) {
                int toAddNum = (limit-dianyingxinxiList.size())<=pageList.size()?(limit-dianyingxinxiList.size()):pageList.size();
                for(DianyingxinxiEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(DianyingxinxiEntity o2 : dianyingxinxiList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        dianyingxinxiList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(dianyingxinxiList.size()>limit) {
            dianyingxinxiList = dianyingxinxiList.subList(0, limit);
        }
        page.setList(dianyingxinxiList);
        return R.ok().put("data", page);
    }







}
