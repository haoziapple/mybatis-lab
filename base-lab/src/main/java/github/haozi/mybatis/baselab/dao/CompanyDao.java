package github.haozi.mybatis.baselab.dao;

import github.haozi.mybatis.baselab.bean.Company;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-22 16:49
 */
public interface CompanyDao {
    Company selectCompany(String id);

    @Select("select * from t_company where org_id = #{id}")
    Map selectCompanyMap(String id);
}
