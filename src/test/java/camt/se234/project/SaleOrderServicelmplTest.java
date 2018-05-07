package camt.se234.project;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.dao.OrderDaoImpl;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.service.SaleOrderService;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServicelmplTest {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void getSaleOrdersTest(){
        List<SaleTransaction> mockSaleTransactions = new ArrayList<>();
        List<SaleTransaction> mockSaleTransactions2 = new ArrayList<>();
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        Product p= new Product();
        Product p2= new Product();
        p.setPrice(20.00);
        p2.setPrice(30.00);
        SaleOrder sl = new SaleOrder();
        SaleOrder s2 = new SaleOrder();
        mockSaleTransactions.add(new SaleTransaction("t01",sl,p,2));
        mockSaleTransactions2.add(new SaleTransaction("t02",s2,p2,1));
        mockSaleOrders.add(new SaleOrder("s01",mockSaleTransactions));
        mockSaleOrders.add( new SaleOrder("s02",mockSaleTransactions2));
        when(orderDao.getOrders()).thenReturn(mockSaleOrders);
        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder("s01",mockSaleTransactions), new SaleOrder("s02",mockSaleTransactions2)));
    }




}
