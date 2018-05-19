package com.fjdantas.cmcourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fjdantas.cmcourse.domain.Category;
import com.fjdantas.cmcourse.domain.Product;
import com.fjdantas.cmcourse.repositories.CategoryRepository;
import com.fjdantas.cmcourse.repositories.ProductRepository;

/*
 * class implements interface CommandLineRunner for objects instantiation in the initialization of the application
 */
@SpringBootApplication
public class CmcourseApplication implements CommandLineRunner {
	
	/*
	 * dependencies for call operation of data access in the repository layer with auto instance by Spring with the Autowired annotation
	 */
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productrepository;
	
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
		
		//instantiating of the categories
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		//instantiating of the products
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		//associating the products elements  with your category list
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		//adding the products elements into category list by association
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
			
		//saving a category object list in the database with a auto list into saveAll method
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		//saving a product object list in the database with a auto list into saveAll method
		productrepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
