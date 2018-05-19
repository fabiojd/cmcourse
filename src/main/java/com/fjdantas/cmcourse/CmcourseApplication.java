package com.fjdantas.cmcourse;

import java.util.Arrays;

import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fjdantas.cmcourse.domain.Category;
import com.fjdantas.cmcourse.repositories.CategoryRepository;

/*
 * class implements interface CommandLineRunner for objects instantiation in the initialization of the application
 */
@SpringBootApplication
public class CmcourseApplication implements CommandLineRunner {
	
	/*
	 * dependency for call operation of data access in the repository layer with auto instance by Spring with the Autowired annotation
	 */
	@Autowired
	private CategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(CmcourseApplication.class, args);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 * object instantiation method of the application
	 */
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		//saving a category object list in the database with a auto list into saveAll method
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
}
