package github.haozi.mybatis.baselab;

import github.haozi.mybatis.baselab.bean.Company;
import github.haozi.mybatis.baselab.dao.CompanyDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-22 15:56
 */
@RestController
@RequestMapping("mybatis")
public class MybatisController {
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    private void initSqlSessionFactory() throws IOException {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * http://localhost:8080/mybatis/select?orgId=100000722
     *
     * @param orgId
     * @return
     */
    @GetMapping("select")
    public Company select(String orgId) {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            Company company = sqlSession.selectOne("MyMapper.selectCompany", orgId);
            System.out.println(company);
            return company;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * http://localhost:8080/mybatis/select2?orgId=100000722
     * @param orgId
     * @return
     */
    @GetMapping("select2")
    public Company select2(String orgId) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            CompanyDao companyDao = sqlSession.getMapper(CompanyDao.class);
            Company company = companyDao.selectCompany(orgId);
            System.out.println(company);
            System.out.println(companyDao.selectCompanyMap(orgId));
            return  company;
        } finally {
            sqlSession.close();
        }
    }
}
