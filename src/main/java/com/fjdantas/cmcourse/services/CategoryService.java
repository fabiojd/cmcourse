package com.fjdantas.cmcourse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjdantas.cmcourse.domain.Category;
import com.fjdantas.cmcourse.repositories.CategoryRepository;
import com.fjdantas.cmcourse.services.exceptions.ObjectNotFoundException;

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
	
	/* operation to find a category by code returning an optional object or a lambda expression 
	 * through a function without arguments that instantiates an exception
	 */
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Category.class.getName()));
	}
}
