package spring.spring_core.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * TODO  some word
 * </p >
 *
 * @author Long Chao
 * @version 1.0
 * @date 2018/12/12
 */
//声明java配置方式
@Configuration
//声明扫描类，该类所在包下所有配置了@Component的类均被自动扫描装配bean
@ComponentScan
public class CDPlayerConfig {
}
