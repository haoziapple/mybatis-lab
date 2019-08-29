package github.haozi.mybatis.pluslab;

import github.haozi.mybatis.pluslab.entity.User;
import github.haozi.mybatis.pluslab.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusLabApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
