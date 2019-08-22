package github.haozi.mybatis.baselab.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-22 16:22
 */
@Data
@ToString
public class Company {
    private String companyName;

    private String shortName;

    private Integer isNzb;

    private Date createDate;
}
