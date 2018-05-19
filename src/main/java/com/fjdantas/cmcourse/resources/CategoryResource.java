package com.fjdantas.cmcourse.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fjdantas.cmcourse.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)//assigning http verbs
	public List<Category> toList() {
		//calling the constructor with parameters
		Category cat1 = new Category(1, "Conputing");
		Category cat2 = new Category(2, "Office");
		
		//instantiating a category list
		List<Category> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);
		
		return list;
	}
}
