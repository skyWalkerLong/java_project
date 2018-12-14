package spring.spring_core.bean;

import org.springframework.stereotype.Component;

/**
 * <p>
 * TODO  some word
 * </p >
 *
 * @author Long Chao
 * @version 1.0
 * @date 2018/12/12
 */
//声明被扫描
@Component
public class CdInfo implements CompactDisc {

    @Override
    public void play() {
        System.out.println("jj--jiangnan");
    }
}
