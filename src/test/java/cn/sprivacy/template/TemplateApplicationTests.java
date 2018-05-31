package cn.sprivacy.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("cn.sprivacy.template.modules.*.mapper")
public class TemplateApplicationTests {

    @Test
    public void contextLoads() {
    }

}
