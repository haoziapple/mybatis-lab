package github.haozi.lab.activitimybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ActivitiMybatisApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelectOne() {
        System.out.println(("----- selectOne method test ------"));
        assertThat(userMapper.selectOne()).isNotNull();
        System.out.println(userMapper.selectOne());
    }

}
