package com.sam.jpa.JPAProject;

import com.sam.jpa.JPAProject.entities.ProductEntity;
import com.sam.jpa.JPAProject.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaProjectApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("Nestle123")
				.title("Nestle chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(4)
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2026,1,1,0,0,0));
		// List<ProductEntity> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(4, BigDecimal.valueOf(123.45));
		//List<ProductEntity> entities = productRepository.findByTitleLike("%Choco%");
//		List<ProductEntity> entities = productRepository.findByTitleContaining("Choco");
		List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("CHOCO");
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("Pepsi coke", BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}
}
