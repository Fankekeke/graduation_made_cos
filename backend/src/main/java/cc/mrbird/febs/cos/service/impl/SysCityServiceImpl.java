package cc.mrbird.febs.cos.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fate.archer.cos.dao.SysCityMapper;
import com.fate.archer.cos.entity.SysCity;
import com.fate.archer.cos.service.ISysCityService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityMapper, SysCity> implements ISysCityService {

    /**
     * 分页查询城市信息
     * @param page
     * @param sysCity
     * @return
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> getCityByPage(Page page, SysCity sysCity) {
        return baseMapper.getCityByPage(page, sysCity);
    }
}
