package camt.se234.project;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class ProductServiceImplTest {
    ProductDao productDao;
    ProductServiceImpl productService;
    @Before
    public void setUp(){
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }


}
