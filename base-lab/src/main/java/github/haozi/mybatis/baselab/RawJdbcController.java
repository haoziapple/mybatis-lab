package github.haozi.mybatis.baselab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.List;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-22 15:14
 */
@RestController
@RequestMapping("rawJdbc")
public class RawJdbcController {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    private void initConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * http://localhost:8080/rawJdbc/select?orgId=100000722
     *
     * @param orgId
     */
    @GetMapping("select")
    public void select(String orgId) throws SQLException {
        String sql = "select * from t_company where org_id = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orgId);
            // 执行查询
            rs = preparedStatement.executeQuery();

            // 处理结果集
            while (rs.next()) {
                System.out.println(rs.getString("company_name"));
                System.out.println(rs.getString("short_name"));
                System.out.println(rs.getInt("is_nzb"));
                System.out.println(rs.getDate("create_date"));
            }
        } finally {
            // 关闭连接，释放资源
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
