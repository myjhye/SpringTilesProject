package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {

	@Autowired
	private RecipeMapper mapper;
	
	//==================== 기본
	
	
	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}
	
	
	
	// 총 페이지
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	
	
	
	// 관련 레시피
	public List<RecipeVO> recipeFindData(String ss)
	{
		return mapper.recipeFindData(ss);
	}
	
}
