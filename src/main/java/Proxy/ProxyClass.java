package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass {
    public static SaleService getProxy(final int discount) {
        Object proxyObj = Proxy.newProxyInstance(SaleServiceImpl.class.getClassLoader(),
                new Class[]{SaleService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Integer returnValue = (Integer) method.invoke(new SaleServiceImpl(),args);
                        return returnValue-discount;
                    }
                });
        return (SaleService) proxyObj;
    }
}
