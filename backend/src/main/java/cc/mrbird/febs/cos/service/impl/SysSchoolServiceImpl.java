package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.SysSchoolMapper;
import cc.mrbird.febs.cos.entity.SysSchool;
import cc.mrbird.febs.cos.service.ISysSchoolService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
@Service
public class SysSchoolServiceImpl extends ServiceImpl<SysSchoolMapper, SysSchool> implements ISysSchoolService {
    /**
     * 分页查询学校信息
     * @param page
     * @param sysSchool
     * @return
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> getSchoolByPage(Page page, SysSchool sysSchool) {
        return baseMapper.getSchoolByPage(page, sysSchool);
    }

    /**
     * 学校数据联想
     * @param key
     * @return
     */
    @Override
    public List<LinkedHashMap<String, Object>> schoolUnited(String key) {
        return baseMapper.schoolUnited(key);
    }

    /**
     * 根据ID获取学校信息
     * @param id
     * @return
     */
    @Override
    public SysSchool getSchoolById(Integer id) {
        return baseMapper.getSchoolById(id);
    }
}
