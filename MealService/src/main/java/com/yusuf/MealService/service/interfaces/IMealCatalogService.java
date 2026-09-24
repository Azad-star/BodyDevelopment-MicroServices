package com.yusuf.MealService.service.interfaces;

import java.util.List;

import com.yusuf.MealService.entity.MealCatalog;

public interface IMealCatalogService {
	
	public List <MealCatalog> suggestMeal(Long id);

}
