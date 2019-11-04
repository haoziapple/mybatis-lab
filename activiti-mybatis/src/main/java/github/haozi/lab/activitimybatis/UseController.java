package github.haozi.lab.activitimybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * @author wanghao
 * @Description
 * @date 2019-11-02 16:36
 */
@Controller
@RequestMapping("user")
public class UseController {
    /**
     * mybatis-starter自动创建的sqlSessionFactory
     * activiti-starter自己也创建了一个sqlSessionFactory, initSqlSessionFactory()
     * @see org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl
     */
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void printSqlSessionFactory() {
        System.out.println(sqlSessionFactory);
    }
}
