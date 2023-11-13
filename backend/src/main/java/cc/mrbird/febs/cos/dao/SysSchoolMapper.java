package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.SysSchool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface SysSchoolMapper extends BaseMapper<SysSchool> {

    /**
     * 分页查询学校信息
     * @param page 分页对象
     * @param sysSchool 学校信息
     * @return 学校信息列表
     */
    IPage<LinkedHashMap<String, Object>> getSchoolByPage(Page page, @Param("sysSchool") SysSchool sysSchool);

    /**
     * 学校数据联想
     * @param key - -
     * @return 学校数据
     */
    List<LinkedHashMap<String, Object>> schoolUnited(@Param("key") String key);

    /**
     * 根据ID获取学校信息 （为什么不用getById(),库中存在特殊字段）
     * @param id 学校Id
     * @return 学校信息
     */
    SysSchool getSchoolById(@Param("id") Integer id);
}
