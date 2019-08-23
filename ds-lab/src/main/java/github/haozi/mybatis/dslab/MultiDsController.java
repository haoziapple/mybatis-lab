package github.haozi.mybatis.dslab;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-23 15:32
 */
@RestController
public class MultiDsController {

    @Autowired
    private ProfileMapper profileMapper;

    /**
     * http://localhost:8080/master?id=311090218046324736
     * @param id
     * @return
     */
    @RequestMapping("master")
    @DS("master")
    public Map master(String id) {
        return profileMapper.selectById(id);
    }

    /**
     * http://localhost:8080/park?id=287542316766330880
     * @param id
     * @return
     */
    @RequestMapping("park")
    @DS("park")
    public Map park(String id) {
        return profileMapper.selectById(id);
    }

    /**
     * http://localhost:8080/auth?id=192330732767543296
     * @param id
     * @return
     */
    @RequestMapping("auth")
    @DS("auth")
    public Map auth(String id) {
        return profileMapper.selectById(id);
    }
}
