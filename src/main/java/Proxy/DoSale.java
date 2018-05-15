package Proxy;

import org.junit.Test;

public class DoSale {
    @Test
    public void saleBySelf() {
        SaleService saleService = new SaleServiceImpl();
        System.out.println("自营");
        int money = saleService.account("42");
        System.out.println("衣服成交价:"+money);
    }
}
