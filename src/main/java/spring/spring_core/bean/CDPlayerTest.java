package spring.spring_core.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * <p>
 * TODO  some word
 * </p >
 *
 * @author Long Chao
 * @version 1.0
 * @date 2018/12/12
 */
//创建应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//去指定类加载配置
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        //assertNotNull(cd);
        cd.play();
    }
}
