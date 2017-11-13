package com.congo.service;

import com.congo.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class ProductServiceTest {

    private ProductService service;
    Map<Integer, Product> mockedProducts;

    @Before
    public void setup(){
        mockedProducts = new HashMap<Integer, Product>();
        Product myProduct = new Product(
                1,
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10));
        mockedProducts.put(1, myProduct);
        service = new ProductService();
        service.products = mockedProducts;
    }

    @Test
    public void getAllProductsReturnsAllProducts(){
        assertThat(service.getAllProducts(), equalTo(mockedProducts));
    }

    @Test
    public void getAllProductsReturnsAllEmptyMapWhenNull(){
        service.products = null;

        assertThat(service.getAllProducts(), equalTo(new HashMap<Integer, Product>()));
    }

    @Test
    public void getProductByIdReturnsProductWhenFound(){
        Product actualProduct = service.getProduct(1);

        assertThat(actualProduct, equalTo(mockedProducts.get(1)));
    }

    @Test
    public void getProductByIdReturnsNullWhenNotFound(){
        Product actualProduct = service.getProduct(2);

        assertThat(actualProduct, nullValue());
    }
}
