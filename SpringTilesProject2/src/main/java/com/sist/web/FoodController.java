package com.sist.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class FoodController {

	@Autowired
	private FoodService service;
	
	@Autowired
	private RecipeService rServ;
	
	//==============
	
	
	
	// 맛집 목록
	@GetMapping("food/food_list.do")
	public String food_list(int cno, Model model)
	{
		List<FoodVO> list = service.foodListData(cno);
		CategoryVO vo = service.categoryInfoData(cno);
		
		model.addAttribute("list", list);
		model.addAttribute("cvo", vo);
		
		return "food/food_list";
	}
	
	
	
	
	// 맛집 상세보기
	@GetMapping("food/food_detail.do")
	public String food_detail(int fno, Model model)
	{
		FoodVO vo = service.foodDetailData(fno);
		model.addAttribute("vo", vo);
		
		
		
		//========== 관련 레시피
		String ss = vo.getType();
		ss = ss.replace("/", "|");
		
		List<RecipeVO> rList = rServ.recipeFindData(ss);
		model.addAttribute("rList", rList);
		
		
		
		return "food/food_detail";
	}
	
	
	
	
}
