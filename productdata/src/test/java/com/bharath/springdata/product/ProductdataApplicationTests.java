package com.bharath.springdata.product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.springdata.product.entities.Product;
import com.bharath.springdata.product.repos.ProductReository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductReository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("samsung");
		product.setDesc("Awesome");
		product.setPrice(25000d);
		System.out.println(">>>>>>>> Inside testCreate <<<<<<<<<<");

		repository.save(product);
	}

	@Test
	public void testRead() {
		Optional<Product> p = repository.findById(1);
		if (p.isPresent()) {
			Product pro = p.get();
			System.out.println(">>>>>>>> Inside testRead <<<<<<<<<<");
			System.out.println(">>>>>>>> " + pro.getName() + " " + pro.getDesc() + " " + pro.getPrice());
		}
	}

	@Test
	public void testUpdate() {
		Optional<Product> p = repository.findById(1);
		if (p.isPresent()) {
			System.out.println(">>>>>>>> Inside testUpdate <<<<<<<<<<");
			Product pro = p.get();
			pro.setPrice(20000d);
			pro.setDesc("Awesome Brand");
			repository.save(pro);
			System.out.println(">>> Product successfully inserted inside  mydb  <<<");
		}
	}

	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println(">>>>>>>> Inside testDelete id present <<<<<<<<<<");
			repository.deleteById(1);
		} else {
			System.out.println(">>>>>>>> Inside testDelete id absent <<<<<<<<<<");
		}

	}

	@Test
	public void testCount() {
		System.out.println("Total record count =====  " + repository.count());
	}

	@Test
	public void findByName() {
		List<Product> products = repository.findByName("samsung");
		products.forEach(p -> System.out.println(">> Product price : " + p.getPrice()));
	}

	@Test
	public void findByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("IWatch", "From Apple");
		products.forEach(p -> System.out.println(">> Product price : " + p.getPrice()));
	}

	@Test
	public void findByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Desc :  " + p.getDesc()));
	}

	@Test
	public void findByDescContains() {
		List<Product> products = repository.findByDescContains("From Apple");
		products.forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " >> Product Desc : " + p.getDesc()));
	}

	@Test
	public void findByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " >> Product Desc : " + p.getDesc()));
	}

	@Test
	public void findByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(1000d, 5000d);
		products.forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Desc :  " + p.getDesc()));
	}

	@Test
	public void findByIdIn() {
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 3, 4, 5));
		products.forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Desc :  " + p.getDesc()));
	}

	@Test

	public void findByIdInPageable() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 3, 4), pageable);
		products.forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Desc :  " + p.getDesc()));
	}

	// ============================== Sorting & Paging
	// ===============================================

	@Test
	public void testFindAllPaging() {
//		List<Product>list=repository.findByName("IWatch", PageRequest.of(0, 3));          
//		list.forEach(p -> System.out.println(">> Product name : " + p.getName() + " Product Desc :  " + p.getDesc()));
		// OR
		Pageable pageable = PageRequest.of(0, 3);
		Page<Product> results = repository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindAllSortingASC() {
//		List<Product>list=repository.findByName("IWatch", PageRequest.of(0, 4, Sort.by("price")));
//		list.forEach(p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()));
		// OR
		repository.findAll(Sort.by(Direction.ASC, "price")).forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()));
	}

	@Test
	public void testFindAllSortingDESC() {
//		List<Product>list=repository.findByName("IWatch", PageRequest.of(0, 4, Sort.by(Direction.DESC,"price")));
//		list.forEach( p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()) );
		// OR
		repository.findAll(Sort.by(Direction.DESC, "price")).forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()));

	}

	@Test
	public void testFindAllSortingDirectionASC() {
		repository.findAll(Sort.by(Direction.ASC, "name", "price")).forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()));
	}

	@Test
	public void testFindAllSortingDirectionDESC() {
		repository.findAll(Sort.by(Direction.DESC, "name", "price")).forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()));
	}

	@Test
	public void testFindAllSortingMultiDirection() {
		repository.findAll(Sort.by(Direction.ASC, "name").and(Sort.by(Direction.DESC, "price"))).forEach(
				p -> System.out.println(">> Product name : " + p.getName() + " Product Price :  " + p.getPrice()));

	}

	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 4, Direction.DESC, "price");
		repository.findAll(pageable).forEach(
				p -> System.out.println(" Product name : " + p.getName() + " Product Price :  " + p.getPrice()));
	}

}