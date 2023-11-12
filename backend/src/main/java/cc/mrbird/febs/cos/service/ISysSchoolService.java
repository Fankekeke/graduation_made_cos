package cc.mrbird.febs.cos.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fate.archer.cos.entity.SysSchool;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface ISysSchoolService extends IService<SysSchool> {

    /**
     * 分页查询学校信息
     * @param page 分页对象
     * @param sysSchool 学校信息
     * @return 学校信息列表
     */
    IPage<LinkedHashMap<String, Object>> getSchoolByPage(Page page, SysSchool sysSchool);

    /**
     * 学校数据联想
     * @param key 关键字
     * @return 学校数据
     */
    List<LinkedHashMap<String, Object>> schoolUnited(String key);

    /**
     * 根据ID获取学校信息 （为什么不用getById(),库中存在特殊字段）
     * @param id 学校Id
     * @return 学校信息
     */
    SysSchool getSchoolById(Integer id);
}
