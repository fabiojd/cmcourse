package com.fjdantas.cmcourse.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjdantas.cmcourse.domain.Category;
import com.fjdantas.cmcourse.repositories.CategoryRepository;

/*
 * class of operation to fetch caterogy  by code for service layer
 */

@Service
public class CategoryService {
	
	/*
	 * dependency for call operation of data access in the repository layer with auto instance by Spring with the Autowired annotation
	 */
	@Autowired
	private CategoryRepository repo; //
	
	//operation to fetch a category by code returning an object
	public Category fetch(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
