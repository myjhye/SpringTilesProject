package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

public interface FoodMapper {

	// 카테고리 목록 
	@Select("SELECT cno, title, poster, subject "
			+ "FROM food_category "
			+ "WHERE cno BETWEEN #{start} AND #{end}")
	public List<CategoryVO> categoryListData(Map map);
	
	
	
	// fno => 맛집 고유 번호 => 상세보기 / cno => 카테고리 번호
	// 맛집 목록
	@Select("SELECT fno, name, poster, address, tel, type, score "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	
	// 카테고리 상단 카드 정보
	@Select("SELECT cno, title, subject "
			+ "FROM food_category "
			+ "WHERE cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
	
	
	
	// 상세보기
	@Select("SELECT fno, name, poster, address, score, tel, type, time, parking, menu, price "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno); // 명소, 쇼핑, 자연, 레시피 
	
	
	
	
}
