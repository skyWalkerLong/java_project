package Proxy;

public class SaleServiceImpl implements SaleService {

    @Override
    public int account(String size) {
        System.out.println("衣服型号:"+size);
        return 50;
    }
}
