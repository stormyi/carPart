package com.xiupeilian.car.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiupeilian.car.base.Page;
import com.xiupeilian.car.base.Pager;
import com.xiupeilian.car.model.Dynmsn;
import com.xiupeilian.car.model.News;
import com.xiupeilian.car.model.Notice;
import com.xiupeilian.car.service.DynmsnService;
import com.xiupeilian.car.service.NewsService;
import com.xiupeilian.car.service.NoticeService;
import com.xiupeilian.car.util.DateUtil;

@Controller
@RequestMapping("/index")
public class IndexAction {
	@Resource
	private NoticeService noticeService;
	@Resource
	private DynmsnService dynmsnService;
	@Resource
	private NewsService newsService;
	
	@RequestMapping("/index.shtml")
	public String index(){
		return "index/index";
	}
	
	@RequestMapping("/top.shtml")
	public String top(HttpServletRequest request){
		String now=DateUtil.dateToStr(new Date());
		request.setAttribute("now", now);
		return "index/top";
	}
	
	@RequestMapping("/navigation.shtml")
	public String navigation(){
		return "index/navigation";
	}
	
	@RequestMapping("/dynmsn.shtml")
	public String dynmsn(HttpServletRequest request){
		//查询动态消息表,最新的10条
		List<Dynmsn> list=dynmsnService.findDymsnsPageQueryByTime();
		request.setAttribute("list", list);
		return "index/dynmsn";
	}
	/**
	 * 公告
	 */
	
	@RequestMapping("/notice.shtml")
	public String notice(Page page,HttpServletRequest request){
		//如果是第一次点击公告的时候，由于没有携带参数，所以page==null
		if(page.getPager()==null){
			Pager pager=new Pager();
			page.setPager(pager);
		}
		//查询满足条件的记录
		List<Notice> list=noticeService.findByPageQuery(page);
		//查询出满足条件的总条数
		int totalRows=noticeService.findTotalRowsByPageQuery(page);
		page.setList(list);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "index/notice";
	}
	
	/**
	 * 新闻
	 */
	@RequestMapping("/news.shtml")
	public String news(Page page,HttpServletRequest request){
		if(page.getPager()==null){
			Pager pager=new Pager();
			page.setPager(pager);
		}
		List<News> list=newsService.findByPageQuery(page);
		int totalRows=newsService.findTotalRowsByPageQuery(page);
		page.setList(list);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "index/news";
	}

}
