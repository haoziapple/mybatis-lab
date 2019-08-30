package github.haozi.mybatis.pluslab;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private ObjectMapper objectMapper = new ObjectMapper();

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

    @Test
    public void testSelectCondition() {
        System.out.println(("----- selectCondition method test: like function ------"));
        List<User> userList1 = userMapper.selectList(new LambdaQueryWrapper<User>()
                .like(User::getEmail, "test"));
        userList1.forEach(System.out::println);

        System.out.println(("----- selectCondition method test: or function ------"));
        List<User> userList2 = userMapper.selectList(new LambdaQueryWrapper<User>()
                .eq(User::getId, 1)
                .or().eq(User::getId, 2));
        userList2.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() throws Throwable{
        System.out.println(("----- selectPage method test ------"));
        IPage<User> userIPage = userMapper.selectPage(new Page<>(1, 5),
                new LambdaQueryWrapper<User>().in(User::getAge, 21, 24));
        System.out.println(objectMapper.writeValueAsString(userIPage));
    }

    @Test
    public void testSelectMaxId() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as id");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);

        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByDesc(User::getId));
        Assert.assertEquals(user.getId().longValue(), users.get(0).getId().longValue());
    }

}
