package com.pis.productinventorysystem;

import com.pis.productinventorysystem.domain.entity.Product;
import com.pis.productinventorysystem.domain.entity.ProductRepository;
import com.pis.productinventorysystem.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductinventorysystemApplicationTests {
	@Mock
	ProductRepository productRepository;
	@InjectMocks
	ProductService productService;

	private Product product;

	@BeforeEach
	public void init(){
		product = Product.builder().id(2L).name("new name").description("description").quantity(2).type("electroni").price(23.00).build();
	}

	@DisplayName("test product update")
	@Test
	public void giverProduct_whenUpdateProduct_theReturnProduct(){
		when(productRepository.saveAndFlush(product)).thenReturn(product);
		product.setName("my product");
		product.setPrice(23.00);
		Product product1 = productService.updateProduct(product);
		assertThat(product1.getName()).isEqualTo("withname");
		assertThat(product1.getPrice()).isEqualTo(23.00);
	}

	@DisplayName("test product save")
	@Test
	public void giverProduct_whenSaveProduct_theReturnProduct(){
		when(productRepository.save(product)).thenReturn(product);
		Product product1 = productService.addProduct(product);
		assertThat(product1.getType()).isEqualTo("FOOD");
	}
}
