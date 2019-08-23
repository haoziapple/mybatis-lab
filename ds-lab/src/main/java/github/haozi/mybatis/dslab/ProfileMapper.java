package github.haozi.mybatis.dslab;

import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author wanghao
 * @Description
 * @date 2019-08-23 15:30
 */
@Mapper
@Resource
public interface ProfileMapper {
    HashMap selectOne();

    HashMap selectById(String id);
}
