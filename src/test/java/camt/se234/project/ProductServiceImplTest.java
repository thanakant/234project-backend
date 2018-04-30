package camt.se234.project;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import camt.se234.project.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductServiceImplTest {
    ProductDao productDao;
    ProductServiceImpl productService;
    @Before
    public void setUp(){
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void  testGetAllProducts() {

        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("p01","SampleP","This one used for test","image",30.25));
        mockProducts.add(new Product("p021","SampleP2","This one used for test","image2",0.25));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(),hasItems(new Product("p01","SampleP","This one used for test","image",30.25),new Product("p021","SampleP2","This one used for test","image2",0.25)));
    }


}
