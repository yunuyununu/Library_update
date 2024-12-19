package com.example.SyLibrary.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.SyLibrary.admin.model.dao.LoanDAO;
import com.example.SyLibrary.admin.model.dto.LoanDTO;
import com.example.SyLibrary.util.PageUtil;

@Controller
@RequestMapping("/loan/*")
public class LoanController {
	@Autowired
	LoanDAO dao;
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(name = "cur_page", defaultValue = "1") int curPage,
			@RequestParam(name = "search_option", defaultValue = "none") String search_option,
			@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		System.out.println(curPage+" "+search_option+" "+keyword+"끝");
		int count = dao.count(search_option, keyword);
		System.out.println(count);
		PageUtil page = new PageUtil(count, curPage);
		int start = page.getPageBegin();
		int end = page.getPageEnd();
		List<LoanDTO> dto = dao.list(search_option, keyword, start, end);
		System.out.println(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/l_book/loan");
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		map.put("count", count);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("page", page);
		mav.addObject("map", map);
		return mav;
	}
	
	@GetMapping("re_book.do")
	public ModelAndView re_book(@RequestParam(name="l_num") String l_num) {
		int num = Integer.valueOf(l_num);
		String result = dao.re_book(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/l_book/loan");
		mav.addObject("result", result);
		System.out.println(mav);
		return mav;
	}
}
