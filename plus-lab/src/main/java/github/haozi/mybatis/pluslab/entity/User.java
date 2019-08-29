package github.haozi.mybatis.pluslab.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createDate;
}
