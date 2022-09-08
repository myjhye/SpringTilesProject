package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

/*
	순서
	Mapper => DAO => Service => ServiceImpl 
 */


@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO dao;
	
	@Override
	public List<RecipeVO> recipeListData(Map map) {
		
		return dao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {

		return dao.recipeTotalPage();
	}

	@Override
	public List<RecipeVO> recipeFindData(String ss) {
		// TODO Auto-generated method stub
		return dao.recipeFindData(ss);
	}
	
}
