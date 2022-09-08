package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeMapper {

	// 레시피 목록
	@Select("SELECT no, title, poster, chef, num "
			+ "FROM (SELECT no, title, poster, chef, rownum as num "
			+ "FROM (SELECT /* + INDEX_ASC(recipe recipe_no_pk)*/ no, title, poster, chef "
			+ "FROM recipe)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	
	
	// 총 페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
	public int recipeTotalPage();
	
	
	
	
	// 관련 레시피
	@Select("SELECT no, title, poster, rownum "
			+ "FROM recipe "
			+ "WHERE REGEXP_LIKE(title, #{ss}) "
			+ "AND rownum <= 6") // 6개 상품 찾기
	public List<RecipeVO> recipeFindData(String ss);
	
	
}
