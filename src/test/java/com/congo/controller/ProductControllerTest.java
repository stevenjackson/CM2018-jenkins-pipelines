package com.congo.controller;

import com.congo.domain.Product;
import com.congo.service.ProductService;
import mockit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Tested
    ProductController productController;

    @Injectable
    ProductService productService;

    @Test
    public void indexReturnsProductView(){
        Product product = new Product(3, "b", "c", "d", "e", "f");

        new NonStrictExpectations(){
            {
                productService.getProduct(product.getId());
                returns(product);
            }
        };

        ModelAndView modelAndView = productController.index(product.getId());

        assertThat(modelAndView.getViewName(), equalTo("product"));
    }

    @Test
    public void indexReturnsDetailsOfProduct(){
        Product product = new Product(3, "b", "c", "d", "e", "f");

        new NonStrictExpectations(){
            {
                productService.getProduct(product.getId());
                returns(product);
            }
        };

        ModelAndView modelAndView = productController.index(product.getId());
        Map<String, Object> model = modelAndView.getModel();
        assertThat(model.get("name"), equalTo(product.getName()));
        assertThat(model.get("description"), equalTo(product.getDescription()));
        assertThat(model.get("price"), equalTo(product.getPrice()));
        assertThat(model.get("imageUrl"), equalTo("/images/" + product.getImageUrl()));
        assertThat(model.get("url"), equalTo(product.getUrl()));
    }

    @Test
    public void getProductReturnsProduct(){
        Integer productId = 3;
        Product product = new Product(3, "b", "c", "d", "e", "f");

        new NonStrictExpectations(){
            {
                productService.getProduct(productId);
                returns(product);
            }
        };

        Product actualProduct = productController.getProduct(productId);
        assertThat(actualProduct, equalTo(product));
    }

    @Test
    public void productHistoryReturnsAListOfProductsFromTheProductService(){
        Integer userId = 25;
        List<Product> products = new ArrayList<Product>();
        Product product = new Product(1, "b", "c", "d", "e", "f");
        products.add(product);

        new NonStrictExpectations(){
            {
                productService.productHistory(userId);
                returns(products);
            }
        };

        List<Product> productHistory = productController.productHistory(userId);

        assertThat(productHistory, equalTo(products));
    }


    @Test
    public void relatedProductsReturnsAListOfProductsFromTheProductService(){
        Integer userId = 25;
        List<Product> products = new ArrayList<Product>();
        Product product = new Product(1, "b", "c", "d", "e", "f");
        products.add(product);

        new NonStrictExpectations(){
            {
                productService.relatedProducts(userId);
                returns(products);
            }
        };

        List<Product> relatedProducts = productController.relatedProducts(userId);

        assertThat(relatedProducts, equalTo(products));
    }

    @Test
    public void trendingProductsReturnsAListOfProductsFromTheProductService(){
        List<Product> products = new ArrayList<Product>();
        Product product = new Product(1, "b", "c", "d", "e", "f");
        products.add(product);

        new NonStrictExpectations(){
            {
                productService.trendingProducts();
                returns(products);
            }
        };

        List<Product> trendingProducts = productController.trendingProducts();

        assertThat(trendingProducts, equalTo(products));
    }
}
