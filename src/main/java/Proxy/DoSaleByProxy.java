package Proxy;

import org.junit.Test;

public class DoSaleByProxy {
    @Test
    public void saleByProxy() {
        SaleService saleService = ProxyClass.getProxy(20);
        System.out.println("pop");
        int money = saleService.account("42");
        System.out.println("成交价："+money);
    }
}
