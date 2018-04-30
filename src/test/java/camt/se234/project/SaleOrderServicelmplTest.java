package camt.se234.project;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.dao.OrderDaoImpl;
import camt.se234.project.service.SaleOrderService;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.junit.Before;
import static org.mockito.Mockito.mock;

public class SaleOrderServicelmplTest {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

}
